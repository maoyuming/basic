package com.duantuke.basic.service.impl;

import java.util.List;

import org.elasticsearch.action.delete.DeleteResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duantuke.basic.esbean.input.SightInputBean;
import com.duantuke.basic.face.esbean.output.SightOutputBean;
import com.duantuke.basic.face.esbean.query.SightQueryBean;
import com.duantuke.basic.face.service.SightSearchService;
import com.duantuke.basic.service.ISightService;
import com.duantuke.basic.util.elasticsearch.SightElasticsearchUtil;
import com.google.gson.Gson;

/**
 * @author he 搜索相关接口
 */
@Service
public class SightSearchServiceImpl implements SightSearchService {

	private static Logger logger = LoggerFactory.getLogger(SightSearchServiceImpl.class);

	@Autowired
	private SightElasticsearchUtil esutil;
	@Autowired
	private ISightService isightService;

	private Gson gson = new Gson();

	@Override
	public List<SightOutputBean> searchSightsFromEs(SightQueryBean sightQueryBean) {
		logger.info("SightSearchServiceImpl searchSightsFromEs param:{}", gson.toJson(sightQueryBean));
		// page参数校验：如果page小于等于0，默认为1.
		Integer page = sightQueryBean.getPage();
		if ((null == page) || (page <= 0)) {
			page = SightQueryBean.SEARCH_PAGE_DEFAULT;
			sightQueryBean.setPage(page);
		}
		// size参数校验：如果size小于等于0，默认为10.
		Integer pagesize = sightQueryBean.getPagesize();
		if ((null == pagesize) || (pagesize <= 0)) {
			pagesize = SightQueryBean.SEARCH_LIMIT_DEFAULT;
			sightQueryBean.setPagesize(pagesize);
		}
		if (sightQueryBean.getRange() == null) {
			sightQueryBean.setRange(Double.valueOf(SightQueryBean.SEARCH_RANGE_DEFAULT));
		}
		List<SightOutputBean> result = esutil.searchSights(sightQueryBean);
		logger.info("SightSearchServiceImpl searchSightsFromEs result:{}", gson.toJson(result));
		return result;
	}

	@Override
	public void initEs(Long sightId) {
		logger.info("SightSearchServiceImpl initEs begin:{}", sightId);
		List<SightInputBean> esInputlist = isightService.queryEsInputSights(sightId);
		esutil.batchAddDocument(esInputlist);
		logger.info("SightSearchServiceImpl initEs end:{}", sightId);
	}

	@Override
	public boolean delEsBySightId(Long sightId) {
		DeleteResponse resp = esutil.deleteDocument(sightId+"");
		return resp.isFound();
	}

	@Override
	public void delEs() {
		esutil.deleteAllDocument();
	}

}
