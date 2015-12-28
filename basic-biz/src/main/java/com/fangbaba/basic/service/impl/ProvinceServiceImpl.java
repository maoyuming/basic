package com.fangbaba.basic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fangbaba.basic.mappers.ProvinceModelMapper;
import com.fangbaba.basic.po.ProvinceModel;
import com.fangbaba.basic.service.ProvinceService;

/**
 * @author he
 * 省相关接口
 */
@Service
public class ProvinceServiceImpl implements ProvinceService {
	
	@Autowired
	private ProvinceModelMapper provinceModelMapper;

	@Override
	public List<ProvinceModel> queryAllProvinces() {
		// TODO Auto-generated method stub
		return provinceModelMapper.selectByExample(null);
	}

}
