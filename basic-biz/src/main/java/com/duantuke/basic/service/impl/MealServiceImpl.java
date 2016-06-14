package com.duantuke.basic.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duantuke.basic.face.service.MealService;
import com.duantuke.basic.mappers.MealMapper;
import com.duantuke.basic.po.Meal;
import com.duantuke.basic.po.MealExample;

/**
 * @author he
 * 饮食相关接口
 */
@Service
public class MealServiceImpl implements MealService {
	
	private static Logger logger = LoggerFactory.getLogger(MealServiceImpl.class);
	@Autowired
	private MealMapper mealMapper;
	
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
		return null;
	}

	@Override
	public Meal queryMealById(Long skuid) {
		MealExample example = new MealExample();
		MealExample.Criteria criteria = example.createCriteria();
		criteria.andSkuIdEqualTo(skuid);
		List<Meal> list = mealMapper.selectByExample(example);
		if(CollectionUtils.isNotEmpty(list)){
			return list.get(0);
		}
		return null;
	}

	@Override
	public List<Meal> queryMealByHotleId(Long hotelId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Meal queryMealByMealId(Long roomtypeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Meal> queryMealByMealIds(List<Long> mealIds) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
