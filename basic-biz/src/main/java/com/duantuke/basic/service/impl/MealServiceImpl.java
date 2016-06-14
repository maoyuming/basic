package com.duantuke.basic.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duantuke.basic.esbean.input.MealInputBean;
import com.duantuke.basic.mappers.MealMapper;
import com.duantuke.basic.po.Meal;
import com.duantuke.basic.po.MealExample;
import com.duantuke.basic.po.Meal;
import com.duantuke.basic.po.MealExample;
import com.duantuke.basic.po.MealExample;
import com.duantuke.basic.po.MealExample.Criteria;
import com.duantuke.basic.service.IMealService;

/**
 * @author he
 * 饮食相关接口
 */
@Service
public class MealServiceImpl implements IMealService {
	
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

		MealExample example = new MealExample();
		Criteria criteria =  example.createCriteria();
		criteria.andSupplierIdEqualTo(hotelId);
		return mealMapper.selectByExample(example);
	
	}

	@Override
	public Meal queryMealByMealId(Long mealId) {

		MealExample example = new MealExample();
		Criteria criteria =  example.createCriteria();
		criteria.andSkuIdEqualTo(mealId);
		
		List<Meal> list = mealMapper.selectByExample(example);
		if(CollectionUtils.isNotEmpty(list)){
			return list.get(0);
		}
		return null;
	
	}

	@Override
	public List<Meal> queryMealByMealIds(List<Long> mealIds) {

		List<Meal> allList =new ArrayList<Meal>();
		for (Long mealId : mealIds) {
			MealExample example = new MealExample();
			MealExample.Criteria criteria =  example.createCriteria();
			criteria.andSkuIdEqualTo(mealId);
			
			List<Meal> list = mealMapper.selectByExample(example);
			if(CollectionUtils.isNotEmpty(list)){
				allList.addAll(list);
			}
		}
		return allList;
	
	}

	@Override
	public List<MealInputBean> queryEsInputMeals(Long mealId) {
		return mealMapper.queryEsInputMeals(mealId);
	}
	

}
