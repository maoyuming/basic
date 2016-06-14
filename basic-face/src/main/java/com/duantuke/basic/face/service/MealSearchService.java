package com.duantuke.basic.face.service;

import java.util.List;

import com.duantuke.basic.face.esbean.output.MealOutputBean;
import com.duantuke.basic.face.esbean.query.MealQueryBean;

/**
 * @author he
 * meal es搜索相关接口
 */
public interface MealSearchService {
	/**
	 * @param mealQueryBean
	 * 搜索es
	 */
	List<MealOutputBean> searchMealsFromEs(MealQueryBean mealQueryBean);
	
	/**
	 * @param mealId 不传则刷全部
	 * 初始化es 
	 */
	void initEs(Long mealId);
	
	/**
	 * @param mealId
	 * 通过mealid删除es
	 */
	boolean delEsByMealId(Long mealId);
	
	/**
	 * 删除es
	 */
	void delEs();
}
