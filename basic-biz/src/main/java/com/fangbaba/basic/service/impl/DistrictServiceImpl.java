package com.fangbaba.basic.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fangbaba.basic.face.bean.DistrictModel;
import com.fangbaba.basic.face.service.DistrictService;
import com.fangbaba.basic.mappers.DistrictModelMapper;

/**
 * @author he
 * 区域相关接口
 */
@Service
public class DistrictServiceImpl implements DistrictService {
	
	private static Logger logger = LoggerFactory.getLogger(DistrictServiceImpl.class);
	
	@Autowired
	private DistrictModelMapper districtModelMapper;

	@Override
	public List<DistrictModel> queryAllDistricts() {
		logger.info(DistrictServiceImpl.class.getName()+":queryAllDistricts begin");
		try {
			return districtModelMapper.selectByExample(null);
		} catch (Exception e) {
			logger.error(DistrictServiceImpl.class.getName()+":queryAllDistricts error",e);
			throw e;
		}
	}

}
