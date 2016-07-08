package com.duantuke.basic.face.service;

import java.util.List;

import com.duantuke.basic.face.bean.MealInfo;
import com.duantuke.basic.po.Meal;

/**
 * @author he
 * 饮食相关接口
 */
public interface MealService {
	public int addMeal(Meal meal);
	public int updateMeal(Meal meal);
	public int delMealById(Long id);
	public List<Meal> queryMeals(Meal meal);
	public Meal queryMealById(Long skuid);
	

	public List<Meal> queryMealByHotleId(Long hotelId);
	public Meal queryMealByMealId(Long roomtypeId);
	public List<Meal> queryMealByMealIds(List<Long> mealIds);
	public List<MealInfo> queryMealInfo(List<Meal> meals,Long hotelId);
}
