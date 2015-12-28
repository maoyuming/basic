package com.fangbaba.basic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fangbaba.basic.face.bean.CityModel;
import com.fangbaba.basic.face.service.CityService;
import com.fangbaba.basic.mappers.CityModelMapper;

/**
 * @author he
 * 城市相关接口
 */
@Service
public class CityServiceImpl implements CityService {
	
	@Autowired
	private CityModelMapper cityModelMapper;

	@Override
	public List<CityModel> queryAllCitys() {
		// TODO Auto-generated method stub
		return cityModelMapper.selectByExample(null);
	}

}
