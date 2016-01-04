package com.fangbaba.basic.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static Logger logger = LoggerFactory.getLogger(CityServiceImpl.class);
	
	@Autowired
	private CityModelMapper cityModelMapper;

	@Override
	public List<CityModel> queryAllCitys() {
		logger.info(CityServiceImpl.class.getName()+":queryAllCitys begin");
		try {
			return cityModelMapper.selectByExample(null);
		} catch (Exception e) {
			logger.error(CityServiceImpl.class.getName()+":queryAllCitys error",e);
			throw e;
		}
	}

}
