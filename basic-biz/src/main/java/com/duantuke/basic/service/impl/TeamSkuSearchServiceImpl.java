package com.duantuke.basic.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.elasticsearch.action.delete.DeleteResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duantuke.basic.esbean.input.TeamSkuInputBean;
import com.duantuke.basic.face.esbean.output.TeamSkuOutputBean;
import com.duantuke.basic.face.esbean.query.TeamSkuQueryBean;
import com.duantuke.basic.face.service.TeamSkuSearchService;
import com.duantuke.basic.service.ITeamSkuService;
import com.duantuke.basic.util.DateUtil;
import com.duantuke.basic.util.elasticsearch.TeamSkuElasticsearchUtil;
import com.google.gson.Gson;

/**
 * @author he teamsku 搜索相关接口
 */
@Service
public class TeamSkuSearchServiceImpl implements TeamSkuSearchService {

	private static Logger logger = LoggerFactory.getLogger(TeamSkuSearchServiceImpl.class);

	@Autowired
	private TeamSkuElasticsearchUtil esutil;
	@Autowired
	private ITeamSkuService iteamSkuService;

	private Gson gson = new Gson();

	@Override
	public List<TeamSkuOutputBean> searchTeamSkusFromEs(TeamSkuQueryBean teamSkuQueryBean) {
		logger.info("TeamSkuSearchServiceImpl searchTeamSkusFromEs param:{}", gson.toJson(teamSkuQueryBean));
		// page参数校验：如果page小于等于0，默认为1.
		Integer page = teamSkuQueryBean.getPage();
		if ((null == page) || (page <= 0)) {
			page = TeamSkuQueryBean.SEARCH_PAGE_DEFAULT;
			teamSkuQueryBean.setPage(page);
		}
		// size参数校验：如果size小于等于0，默认为10.
		Integer pagesize = teamSkuQueryBean.getPagesize();
		if ((null == pagesize) || (pagesize <= 0)) {
			pagesize = TeamSkuQueryBean.SEARCH_LIMIT_DEFAULT;
			teamSkuQueryBean.setPagesize(pagesize);
		}
		if (teamSkuQueryBean.getRange() == null) {
			teamSkuQueryBean.setRange(Double.valueOf(TeamSkuQueryBean.SEARCH_RANGE_DEFAULT));
		}
		List<TeamSkuOutputBean> result = esutil.searchTeamSkus(teamSkuQueryBean);
		logger.info("TeamSkuSearchServiceImpl searchTeamSkusFromEs result:{}", gson.toJson(result));
		return result;
	}

	@Override
	public void initEs(Long teamSkuId) {
		logger.info("TeamSkuSearchServiceImpl initEs begin:{}", teamSkuId);
		List<TeamSkuInputBean> esInputlist = iteamSkuService.queryEsInputTeamSkus(teamSkuId);
		
		// TODO 应改为多线程
		for (TeamSkuInputBean teamSkuInputBean:esInputlist) {
			teamSkuInputBean.setCreatetime(DateUtil.dateToStr(DateUtil.getNowDate(), "yyyy-MM-dd HH:mm"));
		}
		esutil.batchAddDocument(esInputlist);
		logger.info("TeamSkuSearchServiceImpl initEs end:{}", teamSkuId);
	}

	@Override
	public boolean delEsByTeamSkuId(Long teamSkuId) {
		DeleteResponse resp = esutil.deleteDocument(teamSkuId+"");
		return resp.isFound();
	}

	@Override
	public void delEs() {
		esutil.deleteAllDocument();
	}

}
