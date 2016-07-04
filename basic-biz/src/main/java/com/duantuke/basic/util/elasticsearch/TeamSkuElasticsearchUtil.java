package com.duantuke.basic.util.elasticsearch;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
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
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.index.query.BoolFilterBuilder;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.FilterBuilder;
import org.elasticsearch.index.query.FilterBuilders;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder.Operator;
import org.elasticsearch.index.query.NestedQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.duantuke.basic.esbean.input.TeamSkuInputBean;
import com.duantuke.basic.face.bean.PageItem;
import com.duantuke.basic.face.esbean.output.TeamSkuOutputBean;
import com.duantuke.basic.face.esbean.query.TeamSkuQueryBean;
import com.google.common.base.Strings;
import com.google.gson.Gson;

/**
 * Elasticsearch  团体sku搜索工具类
 */
@Repository
public class TeamSkuElasticsearchUtil {
    /**
     * 默认index
     */
    public final static String ES_INDEX = "otc";
    /**
     * 默认type
     */
    public final static String ES_TYPE = "teamsku";
    
    private Logger logger = org.slf4j.LoggerFactory.getLogger(TeamSkuElasticsearchUtil.class);
    
    private Gson gson = new Gson();
    
    private Client client = null;
    
    private Properties prop;
    
    @Autowired
    private Mapper dozerMapper;

    /**
     *
     */
    public TeamSkuElasticsearchUtil() {
        try {
            this.initClient();
        } catch (Exception e) {
            logger.error("TeamSkuElasticsearchUtil error",e);
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
            logger.error("TeamSkuElasticsearchUtil close",e);
            e.printStackTrace();
        }
    }

    /**
     * 批量添加文档
     *
     * @param objList
     * @return
     */
    public BulkResponse batchAddDocument(List<TeamSkuInputBean> objList) {
        BulkResponse bulkResponse = null;
        try {
            BulkRequestBuilder requestBuilder = this.getClient().prepareBulk();
            for (TeamSkuInputBean obj : objList) {
                requestBuilder.add(this.prepareIndex(obj,obj.getSkuId()+""));
            }
            bulkResponse = requestBuilder.execute().actionGet();
        } catch (Exception e) {
            logger.error("TeamSkuElasticsearchUtil batchAddDocument error", e);
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
            logger.error("TeamSkuElasticsearchUtil signleAddDocument error", e);
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
            logger.info("TeamSkuElasticsearchUtil deleteAllDocument from index: {}, type: {}, state is {}", ES_INDEX, ES_TYPE, status);
        } catch (Exception e) {
            logger.error("TeamSkuElasticsearchUtil deleteAllDocument error", e);
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
            logger.error("TeamSkuElasticsearchUtil deleteDocument error", e);
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
            logger.error("TeamSkuElasticsearchUtil updateDocument error", e);
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
            this.logger.error("TeamSkuElasticsearchUtil updateDocument method error:{},id,:{}, field: {}, value: {}", e.getLocalizedMessage(), id,field, value);
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
                //final XContentBuilder teamSkuMappingBuilder = this.createGeoMappingBuilder();
                //createIndexRequestBuilder.addMapping(ES_TYPE, teamSkuMappingBuilder);
                
                createIndexRequestBuilder.execute().actionGet();
                
            }
            //创建type
            if(!this.typeExists(ES_INDEX, ES_TYPE)){
            	final XContentBuilder teamSkuMappingBuilder = this.createGeoMappingBuilder();
            	PutMappingResponse response =
            	        client.admin().indices().preparePutMapping(ES_INDEX).setType(ES_TYPE)
            	            .setSource(teamSkuMappingBuilder).execute().actionGet();
            	 if (response.isAcknowledged()) {
            	      logger.info("TeamSkuElasticsearchUtil Type and mapping created !{}", ES_TYPE);
        	     } else {
        	    	 logger.info("TeamSkuElasticsearchUtil Type and mapping failed !{}", ES_TYPE);
        	     }
            }
        } catch (Exception e) {
            this.logger.error("TeamSkuElasticsearchUtil init elasticsearch client is error", e);
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
     * @param teamSkuid
     * @return
     */
    public SearchHit[] searchTeamSkuByTeamSkuId(String teamSkuId) {
        SearchHit[] hits = null;
        try {
            SearchRequestBuilder searchBuilder = this.prepareSearch();
            FilterBuilder termFilter = FilterBuilders.termFilter("teamSkuId", teamSkuId);
            BoolFilterBuilder boolFilter = FilterBuilders.boolFilter().must(termFilter);
            searchBuilder.setPostFilter(boolFilter);

            hits = queryEsPageing(searchBuilder);
        } catch (Exception e) {
            this.logger.error("TeamSkuElasticsearchUtil searchTeamSkuByTeamSkuId error",e);
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

    public List<TeamSkuOutputBean> searchTeamSkus(TeamSkuQueryBean teamSkuQueryBean) {
        SearchHit[] hits = null;
        List<TeamSkuOutputBean> list = new ArrayList<TeamSkuOutputBean>();
        try {
            SearchRequestBuilder searchBuilder = this.prepareSearch();
            // 设置查询类型 1.SearchType.DFS_QUERY_THEN_FETCH = 精确查询 2.SearchType.SCAN = 扫描查询,无序
            searchBuilder.setSearchType(SearchType.DFS_QUERY_THEN_FETCH);
            List<FilterBuilder> filterBuilders = new ArrayList<FilterBuilder>();
            // 遍历查询条件，并进行过滤
            String name = teamSkuQueryBean.getName();
            String descrition = teamSkuQueryBean.getDescrition();
            Integer page = teamSkuQueryBean.getPage();
            Integer pagesize = teamSkuQueryBean.getPagesize();
            String sortby = teamSkuQueryBean.getSortby();
            String sortorder = teamSkuQueryBean.getSortorder();
            Integer queryMinPeopleNum = teamSkuQueryBean.getQueryMinPeopleNum();
            Integer queryMaxPeopleNum = teamSkuQueryBean.getQueryMaxPeopleNum();
            
            if (name != null) {
                filterBuilders.add(FilterBuilders.queryFilter(QueryBuilders.matchQuery("name", name).operator(Operator.AND)));
            }
            if (descrition != null) {
                filterBuilders.add(FilterBuilders.queryFilter(QueryBuilders.matchQuery("descrition", descrition).operator(Operator.AND)));
            }
            if (queryMinPeopleNum != null) {
            	filterBuilders.add(FilterBuilders.queryFilter(QueryBuilders.rangeQuery("peopleNumber").gte(queryMinPeopleNum)));
            }
            if (queryMaxPeopleNum != null) {
                filterBuilders.add(FilterBuilders.queryFilter(QueryBuilders.rangeQuery("peopleNumber").lte(queryMaxPeopleNum)));
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

            // 分页应用
            if (page > 0) {
                searchBuilder.setFrom((page - 1) * pagesize).setSize(pagesize);
            }

            SearchResponse searchResponse = searchBuilder.execute().actionGet();
            SearchHits searchHits = searchResponse.getHits();
            hits = searchHits.getHits();
            // 对返回结果进行封装
            if ((null != hits) && (hits.length > 0)) {
                list = this.dataTransfer(hits);
            }
        } catch (Exception e) {
        	this.logger.error("TeamSkuElasticsearchUtil searchTeamSkus error",e);
            e.printStackTrace();
        }
        return list;
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
    private List<TeamSkuOutputBean> dataTransfer(SearchHit[] hits) {
        List<TeamSkuOutputBean> list = new ArrayList<TeamSkuOutputBean>();
        for (SearchHit searchHit : hits) {
            Map<String, Object> map = searchHit.getSource();
            TeamSkuOutputBean teamSkuOutputBean = dozerMapper.map(map, TeamSkuOutputBean.class);
            list.add(teamSkuOutputBean);
        }
        return list;
    }

}
