package com.duantuke.basic.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.duantuke.basic.face.service.MealService;
import com.duantuke.basic.po.Meal;

/**
 * @author he
 * 饮食相关接口
 */
@Service
public class MealServiceImpl implements MealService {
	
	private static Logger logger = LoggerFactory.getLogger(MealServiceImpl.class);

	@Override
	public int addMeal(Meal meal) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateMeal(Meal meal) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delMealById(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Meal> queryMeals(Meal meal) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
