package com.fangbaba.basic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fangbaba.basic.mappers.DistrictModelMapper;
import com.fangbaba.basic.po.DistrictModel;
import com.fangbaba.basic.service.DistrictService;

/**
 * @author he
 * 区域相关接口
 */
@Service
public class DistrictServiceImpl implements DistrictService {
	
	@Autowired
	private DistrictModelMapper districtModelMapper;

	@Override
	public List<DistrictModel> queryAllDistricts() {
		// TODO Auto-generated method stub
		return districtModelMapper.selectByExample(null);
	}

}
