package com.fangbaba.basic.util;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.PreDestroy;

import org.apache.commons.lang.StringUtils;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequestBuilder;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsRequest;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsResponse;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequestBuilder;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.deletebyquery.DeleteByQueryResponse;
import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.action.update.UpdateRequestBuilder;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.geo.GeoDistance;
import org.elasticsearch.common.geo.GeoPoint;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.unit.DistanceUnit;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.index.query.BoolFilterBuilder;
import org.elasticsearch.index.query.FilterBuilder;
import org.elasticsearch.index.query.FilterBuilders;
import org.elasticsearch.index.query.GeoDistanceFilterBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryFilterBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder.Operator;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.slf4j.Logger;
import org.springframework.stereotype.Repository;

import com.fangbaba.basic.po.HotelModel;
import com.google.common.base.Strings;
import com.google.gson.Gson;

/**
 * Elasticsearch Proxy ES搜索工具类
 */
@Repository
public class HotelElasticsearchUtil {
	
	private Logger logger = org.slf4j.LoggerFactory.getLogger(HotelElasticsearchUtil.class);

	/** 默认index */
	public final static String OTS_INDEX_DEFAULT = "gds";
	/** 默认type */
	public final static String HOTEL_TYPE_DEFAULT = "guesthouse";
	
	private Gson gson = new Gson();
	private Client client = null;
	private Properties prop;

	/**
	 *
	 */
	public HotelElasticsearchUtil() {
		try {
			this.initClient();
		} catch (IOException e) {
			this.logger.error(e.getLocalizedMessage(), e);
			e.printStackTrace();
		}
	}

	/**
	 *
	 */
	@PreDestroy
	public void close() {
		Client client = this.getClient();
		try {
			if (client != null) {
				client.close();
			}
		} catch (Exception e) {
			this.logger.error(e.getLocalizedMessage(), e);
			e.printStackTrace();
		}
	}

	/**
	 * 批量添加文档
	 *
	 * @param objList
	 * @return
	 */
	public BulkResponse batchAddDocument(List<HotelModel> objList) {
		BulkResponse bulkResponse = null;
		try {
			BulkRequestBuilder requestBuilder = this.getClient().prepareBulk();
			for (Object obj : objList) {
				requestBuilder.add(this.prepareIndex(obj));
			}
			bulkResponse = requestBuilder.execute().actionGet();
		} catch (Exception e) {
			this.logger.error("batchAddDocument method error:\n" + e.getLocalizedMessage(), e);
			e.printStackTrace();
		}
		return bulkResponse;
	}

	/**
	 * 添加单个文档
	 *
	 * @param obj
	 * @return
	 */
	public IndexResponse signleAddDocument(Object obj) {
		IndexResponse indexResponse = null;
		try {
			indexResponse = this.prepareIndex(obj).execute().actionGet();
		} catch (Exception e) {
			this.logger.error("signleAddDocument method error:\n" + e.getLocalizedMessage(), e);
			e.printStackTrace();
		}
		return indexResponse;
	}

	/**
	 * 删除所有文档.
	 *
	 * @param indexName
	 *            参数：index
	 * @param typeName
	 *            参数：type
	 */
	public void deleteAllDocument() {
		try {
			DeleteByQueryResponse deleteByQueryResponse = this.getClient().prepareDeleteByQuery(OTS_INDEX_DEFAULT).setTypes(HOTEL_TYPE_DEFAULT)
					.setQuery(QueryBuilders.matchAllQuery()).execute().actionGet();
			int status = deleteByQueryResponse.status().getStatus();
			this.logger.info("deleteAllDocument from index: {}, type: {}, state is {}", OTS_INDEX_DEFAULT, HOTEL_TYPE_DEFAULT, status);
		} catch (Exception e) {
			this.logger.error("deleteAllDocument method error:\n" + e.getLocalizedMessage(), e);
			e.printStackTrace();
		}
	}

	/**
	 *删除指定id的文档数据
	 * @param id
	 * @return
	 */
	public DeleteResponse deleteDocument(String id) {
		DeleteResponse deleteResponse = null;
		try {
			deleteResponse = this.prepareDelete().setId(id).execute().actionGet();
		} catch (Exception e) {
			this.logger.error("deleteDocument method error:\n" + e.getLocalizedMessage(), e);
			e.printStackTrace();
		}
		return deleteResponse;
	}

	/**
	 *更新指定id的文档
	 * @param id
	 * @param obj
	 * @return
	 */
	public UpdateResponse updateDocument(String id, Object obj) {
		UpdateResponse updateResponse = null;
		try {
			String docs = this.getGson().toJson(obj);
			updateResponse = this.prepareUpdate().setId(id).setDoc(docs).execute().actionGet();
			this.logger.info("updateDocument id: {}, use object: {}.", id, docs);
		} catch (Exception e) {
			this.logger.error("updateDocument method error:\n" + e.getLocalizedMessage(), e);
			e.printStackTrace();
		}
		return updateResponse;
	}


	/**
	 * 更新指定id某个域的值
	 * @param id
	 * @param obj
	 * @return
	 */
	public UpdateResponse updateDocument(String id, String field, Object value) {
		UpdateResponse updateResponse = null;
		try {
			updateResponse = this.prepareUpdate().setId(id).setDoc(field, value).execute().actionGet();
		} catch (Exception e) {
			this.logger.error("updateDocument method error:\n{}, field: {}, value: {}", e.getLocalizedMessage(), field, value);
			e.printStackTrace();
		}
		return updateResponse;
	}


	/**
	 *
	 * @param obj
	 * @return
	 */
	private IndexRequestBuilder prepareIndex(Object obj) {
		return this.getClient().prepareIndex(OTS_INDEX_DEFAULT, HOTEL_TYPE_DEFAULT).setSource(this.getGson().toJson(obj));
	}


	/**
	 * 默认删除
	 * @return
	 */
	private DeleteRequestBuilder prepareDelete() {
		return this.getClient().prepareDelete().setIndex(OTS_INDEX_DEFAULT).setType(HOTEL_TYPE_DEFAULT);
	}


	/**
	 * 默认更新
	 *
	 * @return
	 */
	private UpdateRequestBuilder prepareUpdate() {
		return this.getClient().prepareUpdate().setIndex(OTS_INDEX_DEFAULT).setType(HOTEL_TYPE_DEFAULT);
	}

	/**
	 * 默认搜索
	 *
	 * @return
	 */
	public SearchRequestBuilder prepareSearch() {
		return this.getClient().prepareSearch(OTS_INDEX_DEFAULT).setTypes(HOTEL_TYPE_DEFAULT);
	}

	/**
	 *
	 * @throws IOException
	 */
	private void initClient() throws IOException {
		String cityIndexs = "";
		try {
			this.prop = new Properties();
			InputStream in = this.getClass().getResourceAsStream("/elasticsearch.properties");
			this.prop.load(in);
			Map<String, String> settingMap = new HashMap<String, String>();
			settingMap.put("cluster.name", this.prop.getProperty("elasticsearch.clustername", "elasticsearch"));
			Settings settings = ImmutableSettings.settingsBuilder().put(settingMap).build();
			this.client = new TransportClient(settings);

			String clusterHosts = this.prop.getProperty("elasticsearch.clusterhosts", "127.0.0.1:9300");
			cityIndexs = this.prop.getProperty("elasticsearch.index", "");
			String[] hostsSplit = clusterHosts.split(",");
			if (hostsSplit != null) {
				for (String hostInfo : hostsSplit) {
					int flgPos = hostInfo.indexOf(":");
					if (flgPos > -1) {
						String host = hostInfo.substring(0, flgPos).trim();
						int port = Integer.parseInt(hostInfo.substring(flgPos + 1).trim());
						((TransportClient) this.client).addTransportAddress(new InetSocketTransportAddress(host, port));
					}
				}
			}

			// 默认index，没有index的话自动创建
			if (!this.indexExists(OTS_INDEX_DEFAULT)) {
				// auto create the index if it not exists.
				final CreateIndexRequestBuilder createIndexRequestBuilder = this.client.admin().indices().prepareCreate(OTS_INDEX_DEFAULT);
				final XContentBuilder mappingBuilder = this.createGeoMappingBuilder();
				createIndexRequestBuilder.addMapping(HOTEL_TYPE_DEFAULT, mappingBuilder);
				createIndexRequestBuilder.execute().actionGet();
				this.logger.info("auto create the index: {}, type: {}.", OTS_INDEX_DEFAULT, HOTEL_TYPE_DEFAULT);
			}

			// 其它城市的index
			if (StringUtils.isBlank(cityIndexs)) {
				return;
			}
			String[] indexs = cityIndexs.split(",");
			for (int i = 0; i < indexs.length; i++) {
				String _index = indexs[i];
				if (!this.indexExists(_index)) {
					// auto create the index if it not exists.
					final CreateIndexRequestBuilder createIndexRequestBuilder = this.client.admin().indices().prepareCreate(_index);
					final XContentBuilder mappingBuilder = this.createGeoMappingBuilder();
					createIndexRequestBuilder.addMapping(HOTEL_TYPE_DEFAULT, mappingBuilder);
					createIndexRequestBuilder.execute().actionGet();
					this.logger.info("auto create the index: {}, type: {}.", _index, HOTEL_TYPE_DEFAULT);
				}
			}
		} catch (Exception e) {
			this.logger.error("init elasticsearch client is error:\n" + e.getMessage(), e);
		}
	}

	/**
	 * 指定index是否存在
	 *
	 * @param indexName
	 *            参数：index
	 * @return boolean
	 */
	private boolean indexExists(String indexName) {
		this.logger.info(String.format("Verifying existence of index \"%s\"", indexName));
		IndicesExistsRequest request = new IndicesExistsRequest(indexName);
		IndicesExistsResponse response = this.client.admin().indices().exists(request).actionGet();
		if (response.isExists()) {
			this.logger.info("Index {} has exists.", indexName);
			return true;
		}
		this.logger.info("No such index name: {}", indexName);
		return false;
	}

	/**
	 *
	 * @return
	 * @throws IOException
	 */
	private XContentBuilder createGeoMappingBuilder() throws IOException {
		XContentBuilder xBuilder = XContentFactory.jsonBuilder();

		xBuilder.startObject();
		xBuilder.startObject("properties");
		xBuilder.startObject("pin");

		xBuilder.field("type", "geo_point");

		xBuilder.endObject();
		xBuilder.endObject();
		xBuilder.endObject();

		return xBuilder;
	}

	/**
	 *
	 * @return
	 */
	private Client getClient() {
		return this.client;
	}

	/**
	 *
	 * @return
	 */
	private Gson getGson() {
		return this.gson;
	}

	/**
	 *
	 * @param hotelid
	 * @return
	 */
	public SearchHit[] searchHotelByHotelId(String hotelid) {
		SearchHit[] hits = null;
		try {
			SearchRequestBuilder searchBuilder = this.prepareSearch();
			FilterBuilder termFilter = FilterBuilders.termFilter("id", hotelid);
			BoolFilterBuilder boolFilter = FilterBuilders.boolFilter().must(termFilter);
			searchBuilder.setPostFilter(boolFilter);

			SearchResponse searchResponse = searchBuilder.execute().actionGet();
			SearchHits searchHits = searchResponse.getHits();
			hits = searchHits.getHits();
		} catch (Exception e) {
			this.logger.error("searchHotelByHotelId method error:\n" + e.getMessage());
		}
		return hits;
	}

	public List<HotelModel> searchHotelWithFields(Map<String, String> fields,int page,int size) {
		SearchHit[] hits = null;
		List<HotelModel> list=new ArrayList<HotelModel>();
		try {
			SearchRequestBuilder searchBuilder = this.prepareSearch();
			// 设置查询类型 1.SearchType.DFS_QUERY_THEN_FETCH = 精确查询 2.SearchType.SCAN = 扫描查询,无序
            searchBuilder.setSearchType(SearchType.DFS_QUERY_THEN_FETCH);
            GeoPoint geoPoint=null;
			List<FilterBuilder> filterBuilders = new ArrayList<FilterBuilder>();
			Iterator<String > iterator=fields.keySet().iterator();
			//遍历查询条件，并进行过滤
			while (iterator.hasNext()) {
				String keyString=iterator.next();
				String valueString=fields.get(keyString);
				//对于坐标单独处理
				if (!Strings.isNullOrEmpty(valueString)) {
					if (keyString.equals("pin")) {
						GeoDistanceFilterBuilder geoFilter = FilterBuilders.geoDistanceFilter("pin");
						geoPoint=GeoPoint.parseFromLatLon(valueString);
						geoFilter.point(geoPoint.getLat(), geoPoint.getLon()).distance(Double.parseDouble(fields.get("range")), DistanceUnit.METERS).optimizeBbox("memory").geoDistance(GeoDistance.ARC);
		                filterBuilders.add(geoFilter);
					}else if(!keyString.equals("range")){
						filterBuilders.add(FilterBuilders
		                        .queryFilter(QueryBuilders.matchQuery(keyString,
		                        		valueString).operator(Operator.AND)));
					}
	                
	            }
			}
			
			
			FilterBuilder[] builders = new FilterBuilder[] {};
			BoolFilterBuilder boolFilter = FilterBuilders.boolFilter().must(filterBuilders.toArray(builders));
			searchBuilder.setPostFilter(boolFilter);
			// 距离排序
			this.sortByDistance(searchBuilder, geoPoint);
			
			 // 分页应用
            searchBuilder.setFrom((page - 1) * size).setSize(size);

			SearchResponse searchResponse = searchBuilder.execute().actionGet();
			SearchHits searchHits = searchResponse.getHits();
			hits = searchHits.getHits();
			//对返回结果进行封装
			if (null !=hits &&hits.length>0) {
				list=dataTransfer(hits);
			}
			
		
		} catch (Exception e) {
			this.logger.error("searchHotelWithFields method error:\n" + e.getMessage());
		}
		return list;
	}
	
	/**
     * 按距离排序
     * @param searchBuilder
     * 参数：查询请求builder
     * @param geopoint
     * 参数：屏幕坐标对象
     */
	private void sortByDistance(SearchRequestBuilder searchBuilder, GeoPoint geopoint) {
        searchBuilder.addSort(SortBuilders.geoDistanceSort("pin").point(geopoint.getLat(), geopoint.getLon()).order(SortOrder.ASC));
    }
	
	/**
	 * 查找数据转换
	 * @param hits
	 * @return
	 */
	private List<HotelModel> dataTransfer(SearchHit[] hits){
		List<HotelModel> list=new ArrayList<HotelModel>();
		for (SearchHit searchHit : hits) {
			Map<String, Object> map=searchHit.getSource();
			HotelModel hotelModel=new HotelModel();
			hotelModel.setBusinesslicenseback(map.get("businesslicenseback") == null ? null : String.valueOf(map.get("businesslicenseback")));
			hotelModel.setBusinesslicensefront(map.get("businesslicensefront") == null ? null : String.valueOf(map.get("businesslicensefront")));
			hotelModel.setCitycode(map.get("citycode") == null ? null : Integer.parseInt(map.get("citycode").toString()));
			hotelModel.setCityname(map.get("cityname") == null ? null : String.valueOf(map.get("cityname")));
			hotelModel.setDefaultleavetime(map.get("defaultleavetime") == null ? null : String.valueOf(map.get("defaultleavetime")));
			hotelModel.setDetailaddr(map.get("detailaddr") == null ? null : String.valueOf(map.get("detailaddr")));
			hotelModel.setDiscode(map.get("discode") == null ? null : Integer.parseInt(map.get("discode").toString()));
			hotelModel.setDistrictname(map.get("districtname") == null ? null : String.valueOf(map.get("districtname")));
			hotelModel.setHotelcontactname(map.get("hotelcontactname") == null ? null : String.valueOf(map.get("hotelcontactname")));
			hotelModel.setHotelname(map.get("hotelname") == null ? null : String.valueOf(map.get("hotelname")));
			hotelModel.setHotelphone(map.get("hotelphone") == null ? null : String.valueOf(map.get("hotelphone")));
			hotelModel.setHotelpms(map.get("hotelpms") == null ? null : String.valueOf(map.get("hotelpms")));
			hotelModel.setHoteltype(map.get("hoteltype") == null ? null : Integer.parseInt(String.valueOf(map.get("hoteltype"))));
			hotelModel.setId(map.get("id") == null ? null :Long.parseLong(String.valueOf(map.get("id"))) );
			hotelModel.setIdcardback(map.get("idcardback") == null ? null : String.valueOf(map.get("idcardback")));
			hotelModel.setIdcardfront(map.get("idcardfront") == null ? null : String.valueOf(map.get("idcardfront")));
			hotelModel.setIntroduction(map.get("introduction") == null ? null : String.valueOf(map.get("introduction")));
			hotelModel.setIsonline(map.get("isonline") == null ? null : String.valueOf(map.get("isonline")));
			hotelModel.setIsvisible(map.get("isvisible") == null ? null : String.valueOf(map.get("isvisible")));
			hotelModel.setLatitude(map.get("latitude") == null ? null :new BigDecimal(String.valueOf(map.get("latitude"))) );
			hotelModel.setLongitude(map.get("longitude") == null ? null :new BigDecimal(String.valueOf(map.get("longitude"))));
			hotelModel.setOpentime(map.get("opentime") == null ? null :new Date(String.valueOf(map.get("opentime"))));
			hotelModel.setProvcode(map.get("provcode") == null ? null :Integer.parseInt(String.valueOf(map.get("provcode"))));
			hotelModel.setProvincename(map.get("provincename") == null ? null : String.valueOf(map.get("provincename")));
			hotelModel.setQtphone(map.get("qtphone") == null ? null : String.valueOf(map.get("qtphone")));
			hotelModel.setRegtime(map.get("regtime") == null ? null :new Date(String.valueOf(map.get("regtime"))) );
			hotelModel.setRepairtime(map.get("repairtime") == null ? null : new Date(String.valueOf(map.get("repairtime"))));
			hotelModel.setRetentiontime(map.get("retentiontime") == null ? null : String.valueOf(map.get("retentiontime")));
			hotelModel.setRoomnum(map.get("roomnum") == null ? null :Integer.parseInt(String.valueOf(map.get("roomnum"))) );
			list.add(hotelModel);
		}
		return list;
	}
}
