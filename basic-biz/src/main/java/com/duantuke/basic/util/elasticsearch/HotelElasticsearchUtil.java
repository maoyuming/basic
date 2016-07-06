package com.duantuke.basic.util.elasticsearch;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.PreDestroy;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.dozer.Mapper;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequestBuilder;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsRequest;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsResponse;
import org.elasticsearch.action.admin.indices.exists.types.TypesExistsRequest;
import org.elasticsearch.action.admin.indices.exists.types.TypesExistsResponse;
import org.elasticsearch.action.admin.indices.mapping.put.PutMappingResponse;
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
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.duantuke.basic.esbean.input.HotelInputBean;
import com.duantuke.basic.face.bean.PageItem;
import com.duantuke.basic.face.esbean.output.HotelOutputBean;
import com.duantuke.basic.face.esbean.query.HotelQueryBean;
import com.duantuke.basic.face.esbean.query.MealQueryBean;
import com.duantuke.basic.face.esbean.query.TeamSkuQueryBean;
import com.duantuke.basic.util.DateUtil;
import com.duantuke.basic.util.MD5Util;
import com.google.common.base.Strings;
import com.google.gson.Gson;

/**
 * Elasticsearch  农家院搜索工具类
 */
@Repository
public class HotelElasticsearchUtil {
    /**
     * 默认index
     */
    public final static String ES_INDEX = "otc";
    /**
     * 默认type
     */
    public final static String ES_TYPE = "hotel";
    
    private Logger logger = org.slf4j.LoggerFactory.getLogger(HotelElasticsearchUtil.class);
    
    private Gson gson = new Gson();
    
    private Client client = null;
    
    private Properties prop;
    
    @Autowired
    private Mapper dozerMapper;

    /**
     *
     */
    public HotelElasticsearchUtil() {
        try {
            this.initClient();
        } catch (Exception e) {
            logger.error("HotelElasticsearchUtil error",e);
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
            logger.error("HotelElasticsearchUtil close",e);
            e.printStackTrace();
        }
    }

    /**
     * 批量添加文档
     *
     * @param objList
     * @return
     */
    public BulkResponse batchAddDocument(List<HotelInputBean> objList) {
        BulkResponse bulkResponse = null;
        try {
            BulkRequestBuilder requestBuilder = this.getClient().prepareBulk();
            for (HotelInputBean obj : objList) {
                requestBuilder.add(this.prepareIndex(obj,obj.getHotelId()+""));
            }
            bulkResponse = requestBuilder.execute().actionGet();
        } catch (Exception e) {
            logger.error("HotelElasticsearchUtil batchAddDocument error", e);
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
            logger.error("HotelElasticsearchUtil signleAddDocument error", e);
            e.printStackTrace();
        }
        return indexResponse;
    }

    /**
     * 删除所有文档.
     */
    public void deleteAllDocument() {
        try {
            DeleteByQueryResponse deleteByQueryResponse = this.getClient().prepareDeleteByQuery(ES_INDEX).setTypes(ES_TYPE)
                    .setQuery(QueryBuilders.matchAllQuery()).execute().actionGet();
            int status = deleteByQueryResponse.status().getStatus();
            logger.info("HotelElasticsearchUtil deleteAllDocument from index: {}, type: {}, state is {}", ES_INDEX, ES_TYPE, status);
        } catch (Exception e) {
            logger.error("HotelElasticsearchUtil deleteAllDocument error", e);
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
            logger.error("HotelElasticsearchUtil deleteDocument error", e);
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
            String docs = gson.toJson(obj);
            updateResponse = this.prepareUpdate().setId(id).setDoc(docs).execute().actionGet();
            this.logger.info("updateDocument id: {}, use object: {}.", id, docs);
        } catch (Exception e) {
            logger.error("HotelElasticsearchUtil updateDocument error", e);
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
            this.logger.error("HotelElasticsearchUtil updateDocument method error:{},id,:{}, field: {}, value: {}", e.getLocalizedMessage(), id,field, value);
            e.printStackTrace();
        }
        return updateResponse;
    }

    /**
     * @param obj
     * @return
     */
    private IndexRequestBuilder prepareIndex(Object obj,String id) {
    	if(StringUtils.isBlank(id)){
    		return this.getClient().prepareIndex(ES_INDEX, ES_TYPE).setSource(gson.toJson(obj));
    	}
    	return this.getClient().prepareIndex(ES_INDEX, ES_TYPE,id).setSource(gson.toJson(obj));
    }

    /**
     * 默认删除
     *
     * @return
     */
    private DeleteRequestBuilder prepareDelete() {
        return this.getClient().prepareDelete().setIndex(ES_INDEX).setType(ES_TYPE);
    }

    /**
     * 默认更新
     *
     * @return
     */
    private UpdateRequestBuilder prepareUpdate() {
        return this.getClient().prepareUpdate().setIndex(ES_INDEX).setType(ES_TYPE);
    }

    /**
     * 默认搜索
     *
     * @return
     */
    public SearchRequestBuilder prepareSearch() {
        return this.getClient().prepareSearch(ES_INDEX).setTypes(ES_TYPE);
    }

    /**
     * @throws IOException
     */
    private void initClient() throws IOException {
        try {
            this.prop = new Properties();
            InputStream in = this.getClass().getResourceAsStream("/elasticsearch.properties");
            this.prop.load(in);
            Map<String, String> settingMap = new HashMap<String, String>();
            settingMap.put("cluster.name", this.prop.getProperty("elasticsearch.clustername"));
            Settings settings = ImmutableSettings.settingsBuilder().put(settingMap).build();
            this.client = new TransportClient(settings);

            String clusterHosts = this.prop.getProperty("elasticsearch.clusterhosts");
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
            if (!this.indexExists(ES_INDEX)) {
                final CreateIndexRequestBuilder createIndexRequestBuilder = this.client.admin().indices().prepareCreate(ES_INDEX);
                //final XContentBuilder hotelMappingBuilder = this.createGeoMappingBuilder();
                //createIndexRequestBuilder.addMapping(ES_TYPE, hotelMappingBuilder);
                
                createIndexRequestBuilder.execute().actionGet();
                
            }
            //创建type
            if(!this.typeExists(ES_INDEX, ES_TYPE)){
            	final XContentBuilder hotelMappingBuilder = this.createGeoMappingBuilder();
            	PutMappingResponse response =
            	        client.admin().indices().preparePutMapping(ES_INDEX).setType(ES_TYPE)
            	            .setSource(hotelMappingBuilder).execute().actionGet();
            	 if (response.isAcknowledged()) {
            	      logger.info("HotelElasticsearchUtil Type and mapping created !{}", ES_TYPE);
        	     } else {
        	    	 logger.info("HotelElasticsearchUtil Type and mapping failed !{}", ES_TYPE);
        	     }
            }
        } catch (Exception e) {
            this.logger.error("HotelElasticsearchUtil init elasticsearch client is error", e);
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
     * @param indexName
     * @param typeName
     * 指定type是否存在
     */
    private boolean typeExists(String indexName,String typeName){
    	String[] indexArray = new String[1];
    	indexArray[0] = indexName;
    	TypesExistsRequest request = new TypesExistsRequest(indexArray,typeName);
    	TypesExistsResponse response = this.client.admin().indices().typesExists(request).actionGet();
    	if (response.isExists()) {
            this.logger.info("Type {} has exists.", typeName);
            return true;
        }
        this.logger.info("No such type name: {}", typeName);
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
        
        xBuilder.startObject("prices");
        xBuilder.field("type", "nested");
        xBuilder.endObject();
        
        xBuilder.startObject("meals");
        xBuilder.field("type", "nested");
        xBuilder.endObject();
        
        xBuilder.startObject("teamskus");
        xBuilder.field("type", "nested");
        xBuilder.endObject();
        
        xBuilder.startObject("hotelName");
        xBuilder.field("type", "string")
        .field("indexAnalyzer", "ik")  
        .field("searchAnalyzer", "ik");
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
     * @param hotelid
     * @return
     */
    public SearchHit[] searchHotelByHotelId(String hotelId) {
        SearchHit[] hits = null;
        try {
            SearchRequestBuilder searchBuilder = this.prepareSearch();
            FilterBuilder termFilter = FilterBuilders.termFilter("hotelId", hotelId);
            BoolFilterBuilder boolFilter = FilterBuilders.boolFilter().must(termFilter);
            searchBuilder.setPostFilter(boolFilter);

            hits = queryEsPageing(searchBuilder);
        } catch (Exception e) {
            this.logger.error("HotelElasticsearchUtil searchHotelByHotelId error",e);
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


    public NestedQueryBuilder nestedBoolQuery(final Map<String, String> propertyValues, final String nestedPath) {

        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        Iterator<String> iterator = propertyValues.keySet().iterator();

        while (iterator.hasNext()) {
            String propertyName = iterator.next();
            String propertValue = propertyValues.get(propertyName);
            MatchQueryBuilder matchQuery = QueryBuilders.matchQuery(propertyName, propertValue);
            boolQueryBuilder.should(matchQuery);
        }

        return QueryBuilders.nestedQuery(nestedPath, boolQueryBuilder);
    }
    public NestedQueryBuilder nestedBoolQuery(String key,String value, final String nestedPath) {

        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();

        MatchQueryBuilder matchQuery = QueryBuilders.matchQuery(key, value);
        boolQueryBuilder.must(matchQuery);

        return QueryBuilders.nestedQuery(nestedPath, boolQueryBuilder);
    }
    public NestedQueryBuilder nestedCompareQuery(final List<String> fields, final String nestedPath,Double queryminprice,Double querymaxprice) {
    	
    	BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
    	for (String field:fields) {
    		RangeQueryBuilder rangeQuery = QueryBuilders.rangeQuery(field);
    		if(queryminprice!=null)
    			rangeQuery.gte(queryminprice);
    		if(queryminprice!=null)
    			rangeQuery.lte(querymaxprice);
    		//boolQueryBuilder.must(rangeQuery);
    		boolQueryBuilder.should(rangeQuery);
		}
    	return QueryBuilders.nestedQuery(nestedPath, boolQueryBuilder);
    }
    public NestedQueryBuilder nestedComparePeopleNumQuery(final String field,Integer queryMinPeopleNum,Integer queryMaxPeopleNum,final String nestedPath) {
    	
    	BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
		RangeQueryBuilder rangeQuery = QueryBuilders.rangeQuery(field);
		if(queryMinPeopleNum!=null)
			rangeQuery.gte(queryMinPeopleNum);
		if(queryMaxPeopleNum!=null)
			rangeQuery.lte(queryMaxPeopleNum);
		boolQueryBuilder.must(rangeQuery);
    	return QueryBuilders.nestedQuery(nestedPath, boolQueryBuilder);
    }

    public List<HotelOutputBean> searchHotels(HotelQueryBean hotelQueryBean,Map<String,List<String>> tags,MealQueryBean mealQueryBean,TeamSkuQueryBean teamSkuQueryBean) {
        SearchHit[] hits = null;
        List<HotelOutputBean> list = new ArrayList<HotelOutputBean>();
        try {
            SearchRequestBuilder searchBuilder = this.prepareSearch();
            // 设置查询类型 1.SearchType.DFS_QUERY_THEN_FETCH = 精确查询 2.SearchType.SCAN = 扫描查询,无序
            searchBuilder.setSearchType(SearchType.DFS_QUERY_THEN_FETCH);
            List<FilterBuilder> filterBuilders = new ArrayList<FilterBuilder>();
            // 遍历查询条件，并进行过滤
            String hotelName = hotelQueryBean.getHotelName();
            BigDecimal longitude = hotelQueryBean.getLongitude();
            BigDecimal latitude = hotelQueryBean.getLatitude();
            String isvisible = hotelQueryBean.getIsvisible();
            String readonly = hotelQueryBean.getReadonly();
            String hotelPhone = hotelQueryBean.getHotelPhone();
            String qtPhone = hotelQueryBean.getQtPhone();
            String businessType = hotelQueryBean.getBusinessType();
            Integer provinceCode = hotelQueryBean.getProvinceCode();
            Integer cityCode = hotelQueryBean.getCityCode();
            Integer districtCode = hotelQueryBean.getDistrictCode();
            Integer page = hotelQueryBean.getPage();
            Integer pagesize = hotelQueryBean.getPagesize();
            String sortby = hotelQueryBean.getSortby();
            String sortorder = hotelQueryBean.getSortorder();
            Double querymaxprice = hotelQueryBean.getQuerymaxprice();
            Double queryminprice = hotelQueryBean.getQueryminprice();
            String querystarttime = hotelQueryBean.getQuerystarttime();
            String queryendtime = hotelQueryBean.getQueryendtime();
            List<String> hotelIds = hotelQueryBean.getHotelIds();
            
            //meal
            String mealname=null;
            if(mealQueryBean!=null){
            	mealname = mealQueryBean.getName();
            }
            String meatVegetable=null;
            if(mealQueryBean!=null){
            	meatVegetable = mealQueryBean.getMeatVegetable();
            }
            String descrition=null;
            if(mealQueryBean!=null){
            	descrition = mealQueryBean.getDescrition();
            }
            Integer queryMinPeopleNum=null;
            if(mealQueryBean!=null){
            	queryMinPeopleNum = mealQueryBean.getQueryMinPeopleNum();
            }
            Integer queryMaxPeopleNum=null;
            if(mealQueryBean!=null){
            	queryMaxPeopleNum = mealQueryBean.getQueryMaxPeopleNum();
            }
            
            //teamsku
            String teamskuname=null;
            if(teamSkuQueryBean!=null)
            	teamskuname = teamSkuQueryBean.getName();
            String teamskudescrition=null;
            if(teamSkuQueryBean!=null)
            	teamskudescrition = teamSkuQueryBean.getDescrition();
            Integer teamskuqueryMinPeopleNum=null;
            if(teamSkuQueryBean!=null)
                teamskuqueryMinPeopleNum = teamSkuQueryBean.getQueryMinPeopleNum();
            Integer teamskuqueryMaxPeopleNum=null;
            if(teamSkuQueryBean!=null)
                teamskuqueryMaxPeopleNum = teamSkuQueryBean.getQueryMaxPeopleNum();
            
            //酒店信息搜索条件
            if (hotelName != null) {
            	filterBuilders.add(FilterBuilders.queryFilter(QueryBuilders.matchQuery("hotelName", hotelName).operator(Operator.AND)));
            }
            if (readonly != null) {
            	filterBuilders.add(FilterBuilders.queryFilter(QueryBuilders.matchQuery("readonly", readonly).operator(Operator.AND)));
            }
            if (isvisible != null) {
                filterBuilders.add(FilterBuilders.queryFilter(QueryBuilders.matchQuery("isvisible", isvisible).operator(Operator.AND)));
            }
            if (hotelPhone != null) {
                filterBuilders.add(FilterBuilders.queryFilter(QueryBuilders.matchQuery("hotelPhone", hotelPhone).operator(Operator.AND)));
            }
            if (qtPhone != null) {
                filterBuilders.add(FilterBuilders.queryFilter(QueryBuilders.matchQuery("qtPhone", qtPhone).operator(Operator.AND)));
            }
            if (provinceCode != null) {
                filterBuilders.add(FilterBuilders.queryFilter(QueryBuilders.matchQuery("provinceCode", provinceCode.toString()).operator(Operator.AND)));
            }
            if (cityCode != null) {
                filterBuilders.add(FilterBuilders.queryFilter(QueryBuilders.matchQuery("cityCode", cityCode.toString()).operator(Operator.AND)));
            }
            if (districtCode != null) {
                filterBuilders.add(FilterBuilders.queryFilter(QueryBuilders.matchQuery("discode", districtCode.toString()).operator(Operator.AND)));
            }
            if(CollectionUtils.isNotEmpty(hotelIds)){
            	String[]a = new String[]{};
            	filterBuilders.add(FilterBuilders.queryFilter(QueryBuilders.idsQuery().ids(hotelIds.toArray(a))));
            }
            if (tags != null && tags.size() > 0) {
            	for (String key:tags.keySet()) {
            		List<String> value = tags.get(key);
					if(CollectionUtils.isEmpty(value)){
						continue;
					}
					Map<String, String> propertyValues = new HashMap<String, String>();
					for (String searchcontent:value) {
						propertyValues.put(key + ".tagName", searchcontent);
						if(businessType!=null){
							propertyValues.put(key + ".businessType", businessType);
						}
						searchBuilder.setQuery(nestedBoolQuery(propertyValues, key));
					}
				}
            }
            //搜索餐饮条件
            if(mealname!=null){
            	searchBuilder.setQuery(nestedBoolQuery("meals.name",mealname, "meals"));
            }
            if(meatVegetable!=null){
            	searchBuilder.setQuery(nestedBoolQuery("meals.meatVegetable",meatVegetable, "meals"));
            }
            if(descrition!=null){
            	searchBuilder.setQuery(nestedBoolQuery("meals.descrition",descrition, "meals"));
            }
            if(!(queryMinPeopleNum==null && queryMaxPeopleNum==null)){
            	searchBuilder.setQuery(nestedComparePeopleNumQuery("meals.peopleNumber", queryMinPeopleNum,queryMaxPeopleNum,"meals"));
            }
            //teamsku
            if(teamskuname!=null){
            	searchBuilder.setQuery(nestedBoolQuery("teamskus.name",teamskuname, "teamskus"));
            }
            if(teamskudescrition!=null){
            	searchBuilder.setQuery(nestedBoolQuery("teamskus.descrition",teamskudescrition, "teamskus"));
            }
            if(!(teamskuqueryMinPeopleNum==null && teamskuqueryMaxPeopleNum==null)){
            	searchBuilder.setQuery(nestedComparePeopleNumQuery("teamskus.peopleNumber", teamskuqueryMinPeopleNum,teamskuqueryMaxPeopleNum,"teamskus"));
            }
            
            //酒店价格搜索条件
            List<String> days = new ArrayList<String>();
            Calendar startc = Calendar.getInstance();
            Calendar endc = Calendar.getInstance();
            endc.add(Calendar.DAY_OF_MONTH, 1);
            if(querystarttime==null){
            	querystarttime = DateUtil.dateToStr(startc.getTime(), "yyyyMMdd");
            }
            if(queryendtime==null){
            	queryendtime = DateUtil.dateToStr(endc.getTime(), "yyyyMMdd");
            }
            List<Date> datedays = DateUtil.listDays(DateUtil.strToDate(querystarttime, "yyyyMMdd"),DateUtil.strToDate(queryendtime, "yyyyMMdd"));
            for (int i = 0; i < datedays.size(); i++) {
            	days.add(DateUtil.dateToStr(datedays.get(i), "yyyyMMdd"));
            }
            if(!(querymaxprice==null && queryminprice==null)){
            	searchBuilder.setQuery(nestedCompareQuery(days,"prices", queryminprice,querymaxprice));
            }
            //LBS
            if(longitude!=null &&latitude!=null){
            	GeoDistanceFilterBuilder geoFilter = FilterBuilders.geoDistanceFilter("pin");
            	GeoPoint geoPoint = new GeoPoint(latitude.doubleValue(), longitude.doubleValue());
            	geoFilter.point(geoPoint.getLat(), geoPoint.getLon()).distance(hotelQueryBean.getRange(), DistanceUnit.METERS).optimizeBbox("memory")
				.geoDistance(GeoDistance.ARC);
            	filterBuilders.add(geoFilter);
            	// 距离排序
            	this.sortByDistance(searchBuilder, geoPoint);
            }
            if(CollectionUtils.isNotEmpty(filterBuilders)){
            	FilterBuilder[] builders = new FilterBuilder[]{};
            	BoolFilterBuilder boolFilter = FilterBuilders.boolFilter().must(filterBuilders.toArray(builders));
            	searchBuilder.setPostFilter(boolFilter);
            }
            
            // 添加排序
            if (!Strings.isNullOrEmpty(sortby)) {
            	SortOrder sortOrder = SortOrder.ASC;
            	if ("ASC".equals(sortorder)) {
            		sortOrder = SortOrder.ASC;
    			} else if ("DESC".equals(sortorder)) {
    				sortOrder = SortOrder.DESC;
    			}
                this.sortByFields(searchBuilder, sortby, sortOrder);
            }
            
            //按打分排序
            this.sortByFields(searchBuilder, "paidScore", SortOrder.DESC);

            // 分页应用
            if (page > 0) {
                searchBuilder.setFrom((page - 1) * pagesize).setSize(pagesize);
            }

            SearchResponse searchResponse = searchBuilder.execute().actionGet();
            SearchHits searchHits = searchResponse.getHits();
            hits = searchHits.getHits();
            // 对返回结果进行封装
            if ((null != hits) && (hits.length > 0)) {
                list = this.dataTransfer(hits,days);
            }
        } catch (Exception e) {
        	this.logger.error("HotelElasticsearchUtil searchHotels error",e);
            e.printStackTrace();
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
    private List<HotelOutputBean> dataTransfer(SearchHit[] hits,List<String> days) {
        List<HotelOutputBean> list = new ArrayList<HotelOutputBean>();
        for (SearchHit searchHit : hits) {
            Map<String, Object> map = searchHit.getSource();
            List<Map<String,Double>> prices = (List<Map<String,Double>>)map.get("prices");
            Double minPrice=null;
            try {
            	minPrice = getMinPrice(days,prices);
			} catch (Exception e) {
				logger.error("dataTransfer error",e);
			}
            HotelOutputBean hotelOutputBean = dozerMapper.map(map, HotelOutputBean.class);
            hotelOutputBean.setMinPrice(minPrice);
            list.add(hotelOutputBean);
        }
        return list;
    }
    private Double getMinPrice(List<String> days,List<Map<String,Double>> prices){
    	Double minPrice=Double.MAX_VALUE;
        Map<String,Double> priceMap = new HashMap<String,Double>();
        if(CollectionUtils.isNotEmpty(prices)){
        	for (Map<String,Double> daypricemap:prices) {
        		for (String key:daypricemap.keySet()) {
        			priceMap.put(key, daypricemap.get(key));
				}
        	}
        }
        if(!priceMap.isEmpty()){
        	//找出最低价
        	for (String day:days) {
				Double tempprice = priceMap.get(day);
				if(tempprice.compareTo(minPrice)==-1){
					minPrice = tempprice;
				}
			}
        }
        if(minPrice.compareTo(Double.MAX_VALUE)==0){
        	minPrice = null;
        }
        return minPrice;
    }
    
    public static void main(String[] args) throws Exception {
    	
    	String time = "2016-07-05 14:25:44";
    	
    	String partnerCode ="bjjielv";
    	String securityCode = "lGwoEaLzzU6YAyFiVZ87D8z";
    	securityCode = MD5Util.encryption(securityCode).toUpperCase();
    	String signature =  time + partnerCode + securityCode + "checkRoomAvail";
    	signature =  MD5Util.encryption(signature).toUpperCase();
    	System.out.println(signature);
    	System.out.println("57A11575C38B4112A6A1B1E6110DE645");
    	
    }

}
