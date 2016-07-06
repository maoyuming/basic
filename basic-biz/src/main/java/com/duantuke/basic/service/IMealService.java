package com.duantuke.basic.service;

import java.util.List;

import com.duantuke.basic.esbean.input.MealInputBean;
import com.duantuke.basic.face.service.MealService;

public interface IMealService extends MealService {
	public List<MealInputBean> queryEsInputMeals(Long mealId);
	public List<MealInputBean> queryEsInputMealsByHotelid(Long hotelId);
}
