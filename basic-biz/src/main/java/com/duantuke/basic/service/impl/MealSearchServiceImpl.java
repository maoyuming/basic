package com.duantuke.basic.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.elasticsearch.action.delete.DeleteResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duantuke.basic.esbean.input.MealInputBean;
import com.duantuke.basic.face.esbean.output.MealOutputBean;
import com.duantuke.basic.face.esbean.query.MealQueryBean;
import com.duantuke.basic.face.service.MealSearchService;
import com.duantuke.basic.service.IMealService;
import com.duantuke.basic.util.DateUtil;
import com.duantuke.basic.util.elasticsearch.MealElasticsearchUtil;
import com.google.gson.Gson;

/**
 * @author he 餐饮 搜索相关接口
 */
@Service
public class MealSearchServiceImpl implements MealSearchService {

	private static Logger logger = LoggerFactory.getLogger(MealSearchServiceImpl.class);

	@Autowired
	private MealElasticsearchUtil esutil;
	@Autowired
	private IMealService imealService;

	private Gson gson = new Gson();

	@Override
	public List<MealOutputBean> searchMealsFromEs(MealQueryBean mealQueryBean) {
		logger.info("MealSearchServiceImpl searchMealsFromEs param:{}", gson.toJson(mealQueryBean));
		// page参数校验：如果page小于等于0，默认为1.
		Integer page = mealQueryBean.getPage();
		if ((null == page) || (page <= 0)) {
			page = MealQueryBean.SEARCH_PAGE_DEFAULT;
			mealQueryBean.setPage(page);
		}
		// size参数校验：如果size小于等于0，默认为10.
		Integer pagesize = mealQueryBean.getPagesize();
		if ((null == pagesize) || (pagesize <= 0)) {
			pagesize = MealQueryBean.SEARCH_LIMIT_DEFAULT;
			mealQueryBean.setPagesize(pagesize);
		}
		if (mealQueryBean.getRange() == null) {
			mealQueryBean.setRange(Double.valueOf(MealQueryBean.SEARCH_RANGE_DEFAULT));
		}
		List<MealOutputBean> result = esutil.searchMeals(mealQueryBean);
		logger.info("MealSearchServiceImpl searchMealsFromEs result:{}", gson.toJson(result));
		return result;
	}

	@Override
	public void initEs(Long mealId) {
		logger.info("MealSearchServiceImpl initEs begin:{}", mealId);
		List<MealInputBean> esInputlist = imealService.queryEsInputMeals(mealId);
		
		// TODO 应改为多线程
		for (MealInputBean mealInputBean:esInputlist) {
			mealInputBean.setCreatetime(DateUtil.dateToStr(DateUtil.getNowDate(), "yyyy-MM-dd HH:mm"));
		}
		esutil.batchAddDocument(esInputlist);
		logger.info("MealSearchServiceImpl initEs end:{}", mealId);
	}

	@Override
	public boolean delEsByMealId(Long mealId) {
		DeleteResponse resp = esutil.deleteDocument(mealId+"");
		return resp.isFound();
	}

	@Override
	public void delEs() {
		esutil.deleteAllDocument();
	}

}
