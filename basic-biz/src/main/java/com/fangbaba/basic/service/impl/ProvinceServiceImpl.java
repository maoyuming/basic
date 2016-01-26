package com.fangbaba.basic.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fangbaba.basic.face.bean.ProvinceModel;
import com.fangbaba.basic.face.service.ProvinceService;
import com.fangbaba.basic.mappers.ProvinceModelMapper;
import com.fangbaba.basic.po.ProvinceModelExample;

/**
 * @author he
 * 省相关接口
 */
@Service
public class ProvinceServiceImpl implements ProvinceService {
	
	private static Logger logger = LoggerFactory.getLogger(ProvinceServiceImpl.class);
	
	@Autowired
	private ProvinceModelMapper provinceModelMapper;

	@Override
	public List<ProvinceModel> queryAllProvinces() {
		logger.info(ProvinceServiceImpl.class.getName()+":queryAllProvinces begin");
		try {
			ProvinceModelExample example = new ProvinceModelExample();
			example.setOrderByClause("sort asc");
			return provinceModelMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error(ProvinceServiceImpl.class.getName()+":queryAllProvinces error",e);
			throw e;
		}
	}

}
