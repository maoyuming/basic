package com.duantuke.basic.util.elasticsearch;

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

import org.apache.commons.collections.CollectionUtils;
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
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.FilterBuilder;
import org.elasticsearch.index.query.FilterBuilders;
import org.elasticsearch.index.query.GeoDistanceFilterBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder.Operator;
import org.elasticsearch.index.query.NestedQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.slf4j.Logger;
import org.springframework.stereotype.Repository;

import com.google.common.base.Strings;
import com.google.gson.Gson;

/**
 * Elasticsearch  景点搜索工具类
 */
@Repository
public class SightElasticsearchUtil {
    /**
     * 默认index
     */
    public final static String ES_INDEX = "otc";
    /**
     * 默认type
     */
    public final static String ES_TYPE = "sight";
    
    private Logger logger = org.slf4j.LoggerFactory.getLogger(SightElasticsearchUtil.class);
    
    private Gson gson = new Gson();
    
    private Client client = null;
    
    private Properties prop;

    /**
     *
     */
    public SightElasticsearchUtil() {
        try {
            this.initClient();
        } catch (Exception e) {
            logger.error("SightElasticsearchUtil error",e);
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
            logger.error("SightElasticsearchUtil close",e);
            e.printStackTrace();
        }
    }

    /**
     * 批量添加文档
     *
     * @param objList
     * @return
     */
    public BulkResponse batchAddDocument(List<HotelBean> objList) {
        BulkResponse bulkResponse = null;
        try {
            BulkRequestBuilder requestBuilder = this.getClient().prepareBulk();
            for (HotelBean obj : objList) {
                requestBuilder.add(this.prepareIndex(obj,genEsId(obj)));
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
    public IndexResponse signleAddDocument(Object obj,String id) {
        IndexResponse indexResponse = null;
        try {
            indexResponse = this.prepareIndex(obj,id).execute().actionGet();
        } catch (Exception e) {
            this.logger.error("signleAddDocument method error:\n" + e.getLocalizedMessage(), e);
            e.printStackTrace();
        }
        return indexResponse;
    }
    /**
     * 添加单个文档
     *
     * @param obj
     * @return
     */
//    public IndexResponse signleAddDocument(Object obj) {
//    	IndexResponse indexResponse = null;
//    	try {
//    		indexResponse = this.prepareIndex(obj).execute().actionGet();
//    	} catch (Exception e) {
//    		this.logger.error("signleAddDocument method error:\n" + e.getLocalizedMessage(), e);
//    		e.printStackTrace();
//    	}
//    	return indexResponse;
//    }

    /**
     * 删除所有文档.
     */
    public void deleteAllDocument() {
        try {
            DeleteByQueryResponse deleteByQueryResponse = this.getClient().prepareDeleteByQuery(HotelElasticsearchUtil.OTS_INDEX_DEFAULT).setTypes(HotelElasticsearchUtil.HOTEL_TYPE_DEFAULT)
                    .setQuery(QueryBuilders.matchAllQuery()).execute().actionGet();
            int status = deleteByQueryResponse.status().getStatus();
            this.logger.info("deleteAllDocument from index: {}, type: {}, state is {}", HotelElasticsearchUtil.OTS_INDEX_DEFAULT, HotelElasticsearchUtil.HOTEL_TYPE_DEFAULT, status);
        } catch (Exception e) {
            this.logger.error("deleteAllDocument method error:\n" + e.getLocalizedMessage(), e);
            e.printStackTrace();
        }
    }

    /**
     * 删除指定id的文档数据
     *
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
     * 更新指定id的文档
     *
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
            //this.logger.error("updateDocument method error:\n" + e.getLocalizedMessage(), e);
            e.printStackTrace();
        }
        return updateResponse;
    }

    /**
     * 更新指定id某个域的值
     *
     * @param id
     * @param obj
     * @return
     */
    public UpdateResponse updateDocument(String id, String field, Object value) {
        UpdateResponse updateResponse = null;
        try {
            updateResponse = this.prepareUpdate().setId(id).setDoc(field, value).execute().actionGet();
        } catch (Exception e) {
            this.logger.error("updateDocument method error:\n{},id,:{}, field: {}, value: {}", e.getLocalizedMessage(), id,field, value);
            e.printStackTrace();
        }
        return updateResponse;
    }

    /**
     * @param obj
     * @return
     */
//    private IndexRequestBuilder prepareIndex(Object obj) {
//        return this.getClient().prepareIndex(HotelElasticsearchUtil.OTS_INDEX_DEFAULT, HotelElasticsearchUtil.HOTEL_TYPE_DEFAULT).setSource(this.getGson().toJson(obj));
//    }
    /**
     * @param obj
     * @return
     */
    private IndexRequestBuilder prepareIndex(Object obj,String id) {
    	if(StringUtils.isBlank(id)){
    		return this.getClient().prepareIndex(HotelElasticsearchUtil.OTS_INDEX_DEFAULT, HotelElasticsearchUtil.HOTEL_TYPE_DEFAULT).setSource(this.getGson().toJson(obj));
    	}
    	return this.getClient().prepareIndex(HotelElasticsearchUtil.OTS_INDEX_DEFAULT, HotelElasticsearchUtil.HOTEL_TYPE_DEFAULT,id).setSource(this.getGson().toJson(obj));
    }

    /**
     * 默认删除
     *
     * @return
     */
    private DeleteRequestBuilder prepareDelete() {
        return this.getClient().prepareDelete().setIndex(HotelElasticsearchUtil.OTS_INDEX_DEFAULT).setType(HotelElasticsearchUtil.HOTEL_TYPE_DEFAULT);
    }

    /**
     * 默认更新
     *
     * @return
     */
    private UpdateRequestBuilder prepareUpdate() {
        return this.getClient().prepareUpdate().setIndex(HotelElasticsearchUtil.OTS_INDEX_DEFAULT).setType(HotelElasticsearchUtil.HOTEL_TYPE_DEFAULT);
    }

    /**
     * 默认搜索
     *
     * @return
     */
    public SearchRequestBuilder prepareSearch() {
        return this.getClient().prepareSearch(HotelElasticsearchUtil.OTS_INDEX_DEFAULT).setTypes(HotelElasticsearchUtil.HOTEL_TYPE_DEFAULT);
    }

    /**
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
            if (!this.indexExists(HotelElasticsearchUtil.OTS_INDEX_DEFAULT)) {
                // auto create the index if it not exists.
                final CreateIndexRequestBuilder createIndexRequestBuilder = this.client.admin().indices().prepareCreate(HotelElasticsearchUtil.OTS_INDEX_DEFAULT);
                final XContentBuilder mappingBuilder = this.createGeoMappingBuilder();
                createIndexRequestBuilder.addMapping(HotelElasticsearchUtil.HOTEL_TYPE_DEFAULT, mappingBuilder);
                createIndexRequestBuilder.execute().actionGet();
                this.logger.info("auto create the index: {}, type: {}.", HotelElasticsearchUtil.OTS_INDEX_DEFAULT, HotelElasticsearchUtil.HOTEL_TYPE_DEFAULT);
            }

            // 其它城市的index
            if (StringUtils.isBlank(cityIndexs)) {
                return;
            }
            String[] indexs = cityIndexs.split(",");
            for (String index : indexs) {
                String _index = index;
                if (!this.indexExists(_index)) {
                    // auto create the index if it not exists.
                    final CreateIndexRequestBuilder createIndexRequestBuilder = this.client.admin().indices().prepareCreate(_index);
                    final XContentBuilder mappingBuilder = this.createGeoMappingBuilder();
                    createIndexRequestBuilder.addMapping(HotelElasticsearchUtil.HOTEL_TYPE_DEFAULT, mappingBuilder);
                    createIndexRequestBuilder.execute().actionGet();
                    this.logger.info("auto create the index: {}, type: {}.", _index, HotelElasticsearchUtil.HOTEL_TYPE_DEFAULT);
                }
            }
        } catch (Exception e) {
            this.logger.error("init elasticsearch client is error:\n" + e.getMessage(), e);
        }
    }

    /**
     * 指定index是否存在
     *
     * @param indexName 参数：index
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

        xBuilder.startObject("taggroup_1");
        xBuilder.field("type", "nested");
        xBuilder.endObject();

        xBuilder.startObject("taggroup_2");
        xBuilder.field("type", "nested");
        xBuilder.endObject();

        xBuilder.startObject("taggroup_3");
        xBuilder.field("type", "nested");
        xBuilder.endObject();

        xBuilder.startObject("taggroup_4");
        xBuilder.field("type", "nested");
        xBuilder.endObject();
        
        xBuilder.startObject("minprice");
        xBuilder.field("type", "double");
        xBuilder.endObject();
        
        xBuilder.startObject("maxprice");
        xBuilder.field("type", "double");
        xBuilder.endObject();

        xBuilder.endObject();
        xBuilder.endObject();

        return xBuilder;
    }

    /**
     * @return
     */
    private Client getClient() {
        return this.client;
    }

    /**
     * @return
     */
    private Gson getGson() {
        return this.gson;
    }

    /**
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

            hits = queryEsPageing(searchBuilder);
        } catch (Exception e) {
            this.logger.error("searchHotelByHotelId method error:\n" + e.getMessage());
        }
        return hits;
    }
    public SearchHit[] searchHotelByPrimaryKey(String primarykey) {
		SearchHit[] hits = null;
		try {
			SearchRequestBuilder searchBuilder = this.prepareSearch();
			FilterBuilder termFilter = FilterBuilders.termFilter("_id", primarykey);
			BoolFilterBuilder boolFilter = FilterBuilders.boolFilter().must(termFilter);
			searchBuilder.setPostFilter(boolFilter);
			searchBuilder.setFrom(0).setSize(1);
			SearchResponse searchResponse = searchBuilder.execute().actionGet();
			SearchHits searchHits = searchResponse.getHits();
			hits = searchHits.getHits();
		} catch (Exception e) {
			this.logger.error("searchHotelByPrimaryKey method error",e);
		}
		return hits;
    }
    
    /**
     * 分页查询总量es
     * @param searchBuilder
     * @return
     */
    private SearchHit[] queryEsPageing(SearchRequestBuilder searchBuilder){
    	SearchHit[] hits = null;
    	 //查询下总数
        SearchResponse totalResponse = searchBuilder.setSize(-1).execute().actionGet();
        
        int page=1;
        int size=100;
        
        PageItem item = new PageItem();
        item.setIndex(page);
        item.setPageSize(size);
        
        
        long totalItem = totalResponse.getHits().getTotalHits();
        
        item.setTotalItem(Integer.valueOf(totalItem+""));
//        hits = new SearchHit[item.getTotalItem()];
        
        List<SearchHit> list = new ArrayList<SearchHit>();
        for (int i = 0; i < item.getTotalPage(); i++) {
        	searchBuilder.setFrom(item.getBegin()).setSize(size);
        	 //分页查询
            
            SearchResponse searchResponse = searchBuilder.execute().actionGet();
            SearchHits searchHits = searchResponse.getHits();
            SearchHit[] hits2 = searchHits.getHits();
            if(hits2!=null){
            	for (SearchHit searchHit : hits2) {
            		list.add(searchHit);
				}
            }
            

            item.setBegin(item.getBegin()+size);
		}
        
        if(CollectionUtils.isNotEmpty(list)){
        	hits = list.toArray(new SearchHit[item.getTotalItem()] );
        }
        return hits;
    }

    public SearchHit[] searchHotelByOtaType(Long otatype) {
    	SearchHit[] hits = null;
        try {
            SearchRequestBuilder searchBuilder = this.prepareSearch();
            FilterBuilder termFilter = FilterBuilders.termFilter("otatype", otatype);
            BoolFilterBuilder boolFilter = FilterBuilders.boolFilter().must(termFilter);
            searchBuilder.setPostFilter(boolFilter);

            hits =  queryEsPageing(searchBuilder);
           
            
            if(hits!=null){
            	logger.info("要删除的es大小：{}",hits.length);
            }
        } catch (Exception e) {
            this.logger.error("searchHotelByHotelId method error:\n" + e.getMessage(),e);
        }
        return hits;
    }

    /*public List<HotelModelEsBean> searchHotelWithFields(Map<String, String> fields, int page, int size, String sortby, SortOrder sortOrder) {
        return searchHotelWithFields(fields, null, page, size, sortby, sortOrder);
    }*/

    public NestedQueryBuilder nestedBoolQuery(final Map<String, String> propertyValues, final String nestedPath) {

        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        Iterator<String> iterator = propertyValues.keySet().iterator();

        while (iterator.hasNext()) {
            String propertyName = iterator.next();
            String propertValue = propertyValues.get(propertyName);
            MatchQueryBuilder matchQuery = QueryBuilders.matchQuery(propertyName, propertValue);
            boolQueryBuilder.must(matchQuery);
        }

        return QueryBuilders.nestedQuery(nestedPath, boolQueryBuilder);
    }

    public List<HotelModelEsBean> searchHotelWithFields(HotelModelEsBean hotelModelEsBean, Map<String, String> dynamicCondition, int page, int size, String sortby, SortOrder sortOrder) {
        SearchHit[] hits = null;
        List<HotelModelEsBean> list = new ArrayList<HotelModelEsBean>();
        try {
            SearchRequestBuilder searchBuilder = this.prepareSearch();
            // 设置查询类型 1.SearchType.DFS_QUERY_THEN_FETCH = 精确查询 2.SearchType.SCAN
            // = 扫描查询,无序
            searchBuilder.setSearchType(SearchType.DFS_QUERY_THEN_FETCH);
            List<FilterBuilder> filterBuilders = new ArrayList<FilterBuilder>();
            // 遍历查询条件，并进行过滤
            Long otatype = hotelModelEsBean.getOtatype();
            Integer channelId = hotelModelEsBean.getChannelId();
            BigDecimal minprice = hotelModelEsBean.getMinprice();
            BigDecimal maxprice = hotelModelEsBean.getMaxprice();
            Integer hoteltype = hotelModelEsBean.getHoteltype();
            String hotelname = hotelModelEsBean.getHotelname();
            Integer provcode = hotelModelEsBean.getProvcode();
            Integer citycode = hotelModelEsBean.getCitycode();
            Integer discode = hotelModelEsBean.getDiscode();
            Integer maxnum = hotelModelEsBean.getMaxnum();
            Integer minnum = hotelModelEsBean.getMinnum();
            BigDecimal latitude = hotelModelEsBean.getLatitude();
            BigDecimal longitude = hotelModelEsBean.getLongitude();
            String isvisible = hotelModelEsBean.getIsvisible();
            
            Long id = hotelModelEsBean.getId();
            Integer repairyear = hotelModelEsBean.getRepairyear();
            Date repairtime = hotelModelEsBean.getRepairtime();
            if (id != null) {
            	filterBuilders.add(FilterBuilders.queryFilter(QueryBuilders.matchQuery("id", id.toString()).operator(Operator.AND)));
            }
            if (otatype != null) {
                filterBuilders.add(FilterBuilders.queryFilter(QueryBuilders.matchQuery("otatype", otatype.toString()).operator(Operator.AND)));
            }
            if (hoteltype != null) {
                filterBuilders.add(FilterBuilders.queryFilter(QueryBuilders.matchQuery("hoteltype", hoteltype.toString()).operator(Operator.AND)));
            }
            if (hotelname != null) {
                filterBuilders.add(FilterBuilders.queryFilter(QueryBuilders.matchQuery("hotelname", hotelname).operator(Operator.AND)));
            }
            if (provcode != null) {
                filterBuilders.add(FilterBuilders.queryFilter(QueryBuilders.matchQuery("provcode", provcode.toString()).operator(Operator.AND)));
            }
            if (citycode != null) {
                filterBuilders.add(FilterBuilders.queryFilter(QueryBuilders.matchQuery("citycode", citycode.toString()).operator(Operator.AND)));
            }
            if (discode != null) {
                filterBuilders.add(FilterBuilders.queryFilter(QueryBuilders.matchQuery("discode", discode.toString()).operator(Operator.AND)));
            }
//            if(!isNotFilterPrice(channelId)){//去哪儿不做强行拦截
            if (isvisible != null) {
            	//上线酒店才显示
            	filterBuilders.add(FilterBuilders.queryFilter(QueryBuilders.matchQuery("isvisible", isvisible).operator(Operator.AND)));
            }
//            }
            if (dynamicCondition != null && dynamicCondition.size() > 0) {
                for (Map.Entry<String, String> tmp : dynamicCondition.entrySet()) {
                    if (tmp.getValue() == null) {
                        continue;
                    }
                    Map<String, String> propertyValues = new HashMap<String, String>();
                    propertyValues.put(tmp.getKey() + ".tagname", tmp.getValue());
                    searchBuilder.setQuery(nestedBoolQuery(propertyValues, tmp.getKey()));
//                    filterBuilders.add(FilterBuilders.queryFilter(QueryBuilders.matchQuery(tmp.getKey() + ".tagname", tmp.getValue()).operator(Operator.AND)));
                }
            }
            //LBS
            if(longitude!=null &&latitude!=null){
            	GeoDistanceFilterBuilder geoFilter = FilterBuilders.geoDistanceFilter("pin");
            	GeoPoint geoPoint = new GeoPoint(latitude.doubleValue(), longitude.doubleValue());
            	geoFilter.point(geoPoint.getLat(), geoPoint.getLon()).distance(hotelModelEsBean.getRange(), DistanceUnit.METERS).optimizeBbox("memory")
				.geoDistance(GeoDistance.ARC);
            	filterBuilders.add(geoFilter);
            	// 距离排序
            	this.sortByDistance(searchBuilder, geoPoint);
            }
            FilterBuilder[] builders = new FilterBuilder[]{};
            BoolFilterBuilder boolFilter = FilterBuilders.boolFilter().must(filterBuilders.toArray(builders));
            if (minprice != null) {
                //boolFilter.mustNot(FilterBuilders.rangeFilter("maxprice").from(0).to(minprice));
                if(!isNotFilterPrice(channelId)){//去哪儿不做强行拦截
                	boolFilter.mustNot(FilterBuilders.rangeFilter("maxprice").gt(0).lt(minprice));
                }
            }else{
            	if(!isNotFilterPrice(channelId)){//去哪儿不做强行拦截
            		//boolFilter.mustNot(FilterBuilders.rangeFilter("maxprice").from(0));
            		boolFilter.mustNot(FilterBuilders.rangeFilter("maxprice").gt(0));
            	}
            }
            if (maxprice != null) {
                //boolFilter.mustNot(FilterBuilders.rangeFilter("minprice").from(maxprice).to(9999));
                boolFilter.mustNot(FilterBuilders.rangeFilter("minprice").gt(maxprice).lt(9999));
            }else{
            	if(!isNotFilterPrice(channelId)){//去哪儿不做强行拦截
            		//boolFilter.mustNot(FilterBuilders.rangeFilter("minprice").from(0));
            		boolFilter.mustNot(FilterBuilders.rangeFilter("minprice").gt(0));
            	}
            }
            if(repairyear!=null&&repairtime!=null){
                if(repairyear.intValue()!=0){
                    if(repairyear.intValue()==6){
                        boolFilter.must(FilterBuilders.rangeFilter("repairtimel").lte(repairtime.getTime()));
                        logger.info("********repairtime*******"+repairtime.getTime());
                    }else{
                        boolFilter.must(FilterBuilders.rangeFilter("repairtimel").gte(repairtime.getTime()));
                        logger.info("********repairtime*******"+repairtime.getTime());
                    }
                }
            }
            if (minnum != null) {
                boolFilter.must(FilterBuilders.rangeFilter("totalroom").gte(minnum));
            }
            if (maxnum != null) {
                boolFilter.must(FilterBuilders.rangeFilter("totalroom").lte(maxnum));
            }
            if(!isNotFilterPrice(channelId)){//去哪儿不做强行拦截
            	//必须大于0
            	boolFilter.must(FilterBuilders.rangeFilter("minprice").gte(0));
            }
            searchBuilder.setPostFilter(boolFilter);
            
            
            // 添加排序
            if (!Strings.isNullOrEmpty(sortby)) {
                this.sortByFields(searchBuilder, sortby, sortOrder);
            }

            // 分页应用
            if (page > 0) {
                searchBuilder.setFrom((page - 1) * size).setSize(size);
            }

            SearchResponse searchResponse = searchBuilder.execute().actionGet();
            SearchHits searchHits = searchResponse.getHits();
            hits = searchHits.getHits();
            // 对返回结果进行封装
            if ((null != hits) && (hits.length > 0)) {
                list = this.dataTransfer(hits);
            }

        } catch (Exception e) {
            e.printStackTrace();
            this.logger.error("searchHotelWithFields method error:\n" + e.getMessage());
        }
        return list;
    }

    /**
     * 按距离排序
     *
     * @param searchBuilder 参数：查询请求builder
     * @param geopoint      参数：屏幕坐标对象
     */
    private void sortByDistance(SearchRequestBuilder searchBuilder, GeoPoint geopoint) {
        searchBuilder.addSort(SortBuilders.geoDistanceSort("pin").point(geopoint.getLat(), geopoint.getLon()).order(SortOrder.ASC));
    }

    /**
     * 按字段排序
     *
     * @param searchBuilder
     * @param sortBy
     * @param sortOrder
     */
    private void sortByFields(SearchRequestBuilder searchBuilder, String sortBy, SortOrder sortOrder) {
        searchBuilder.addSort(SortBuilders.fieldSort(sortBy).order(sortOrder));
    }

    /**
     * 查找数据转换
     *
     * @param hits
     * @return
     */
    private List<HotelModelEsBean> dataTransfer(SearchHit[] hits) {
        List<HotelModelEsBean> list = new ArrayList<HotelModelEsBean>();
        for (SearchHit searchHit : hits) {
            Map<String, Object> map = searchHit.getSource();
            HotelModelEsBean hotelModelEsBean = new HotelModelEsBean();
            hotelModelEsBean.setBusinesslicenseback(map.get("businesslicenseback") == null ? null : String.valueOf(map.get("businesslicenseback")));
            hotelModelEsBean.setBusinesslicensefront(map.get("businesslicensefront") == null ? null : String.valueOf(map.get("businesslicensefront")));
            hotelModelEsBean.setCitycode(map.get("citycode") == null ? null : Integer.parseInt(map.get("citycode").toString()));
            hotelModelEsBean.setCityname(map.get("cityname") == null ? null : String.valueOf(map.get("cityname")));
            hotelModelEsBean.setDefaultleavetime(map.get("defaultleavetime") == null ? null : String.valueOf(map.get("defaultleavetime")));
            hotelModelEsBean.setDetailaddr(map.get("detailaddr") == null ? null : String.valueOf(map.get("detailaddr")));
            hotelModelEsBean.setDiscode(map.get("discode") == null ? null : Integer.parseInt(map.get("discode").toString()));
            hotelModelEsBean.setDistrictname(map.get("districtname") == null ? null : String.valueOf(map.get("districtname")));
            hotelModelEsBean.setHotelcontactname(map.get("hotelcontactname") == null ? null : String.valueOf(map.get("hotelcontactname")));
            hotelModelEsBean.setHotelname(map.get("hotelname") == null ? null : String.valueOf(map.get("hotelname")));
            hotelModelEsBean.setHotelphone(map.get("hotelphone") == null ? null : String.valueOf(map.get("hotelphone")));
            hotelModelEsBean.setHotelpms(map.get("hotelpms") == null ? null : String.valueOf(map.get("hotelpms")));
            hotelModelEsBean.setHoteltype(map.get("hoteltype") == null ? null : Integer.parseInt(String.valueOf(map.get("hoteltype"))));
            hotelModelEsBean.setId(map.get("id") == null ? null : Long.parseLong(String.valueOf(map.get("id"))));
            hotelModelEsBean.setIdcardback(map.get("idcardback") == null ? null : String.valueOf(map.get("idcardback")));
            hotelModelEsBean.setIdcardfront(map.get("idcardfront") == null ? null : String.valueOf(map.get("idcardfront")));
            hotelModelEsBean.setIntroduction(map.get("introduction") == null ? null : String.valueOf(map.get("introduction")));
            hotelModelEsBean.setIsonline(map.get("isonline") == null ? null : String.valueOf(map.get("isonline")));
            hotelModelEsBean.setIsvisible(map.get("isvisible") == null ? null : String.valueOf(map.get("isvisible")));
            hotelModelEsBean.setLatitude(map.get("latitude") == null ? null : new BigDecimal(String.valueOf(map.get("latitude"))));
            hotelModelEsBean.setLongitude(map.get("longitude") == null ? null : new BigDecimal(String.valueOf(map.get("longitude"))));
            hotelModelEsBean.setOpentime(map.get("opentime") == null ? null : new Date(String.valueOf(map.get("opentime"))));
            hotelModelEsBean.setProvcode(map.get("provcode") == null ? null : Integer.parseInt(String.valueOf(map.get("provcode"))));
            hotelModelEsBean.setProvincename(map.get("provincename") == null ? null : String.valueOf(map.get("provincename")));
            hotelModelEsBean.setQtphone(map.get("qtphone") == null ? null : String.valueOf(map.get("qtphone")));
            hotelModelEsBean.setRegtime(map.get("regtime") == null ? null : new Date(String.valueOf(map.get("regtime"))));
            hotelModelEsBean.setRepairtime(map.get("repairtime") == null ? null : new Date(String.valueOf(map.get("repairtime"))));
            hotelModelEsBean.setRetentiontime(map.get("retentiontime") == null ? null : String.valueOf(map.get("retentiontime")));
            hotelModelEsBean.setRoomnum(map.get("roomnum") == null ? null : Integer.parseInt(String.valueOf(map.get("roomnum"))));
            hotelModelEsBean.setMinprice((map.get("minprice") == null) || "0.0".equals(map.get("minprice")) ? BigDecimal.ZERO : new BigDecimal(map.get("minprice").toString()));
            hotelModelEsBean.setMaxprice((map.get("maxprice") == null) || "0.0".equals(map.get("maxprice")) ? BigDecimal.ZERO : new BigDecimal(map.get("maxprice").toString()));
            hotelModelEsBean.setHotelpic(map.get("hotelpic") == null ? null : String.valueOf(map.get("hotelpic")));
            hotelModelEsBean.setTotalroom(map.get("totalroom") == null ? 0 : Integer.parseInt(map.get("totalroom").toString()));
            
            hotelModelEsBean.setOtaHotelname(map.get("otaHotelname") == null ? null : String.valueOf(map.get("otaHotelname")));
            hotelModelEsBean.setOtaHotelphone(map.get("otaHotelphone") == null ? null : String.valueOf(map.get("otaHotelphone")));
            hotelModelEsBean.setOtaDetailaddr(map.get("otaDetailaddr") == null ? null : String.valueOf(map.get("otaDetailaddr")));
            hotelModelEsBean.setChannelId(map.get("channelId") == null ? null : Integer.valueOf(String.valueOf(map.get("channelId"))));
            hotelModelEsBean.setHotelpics(map.get("hotelpics") == null ? null : String.valueOf(map.get("hotelpics")));
            list.add(hotelModelEsBean);
        }
        return list;
    }
    
    
    public  String genEsId(HotelBean hotelBean){
    	return hotelBean.getOtatype()+"_"+hotelBean.getId();
    }
    
    
    private boolean isNotFilterPrice(Integer channelId){
    	return ChannelEnum.QUNAR.getId() == channelId;
    }


}
