package com.fangbaba.basic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fangbaba.basic.face.bean.ProvinceModel;
import com.fangbaba.basic.face.service.ProvinceService;
import com.fangbaba.basic.mappers.ProvinceModelMapper;

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
		return provinceModelMapper.selectByExample(null);
	}

}
