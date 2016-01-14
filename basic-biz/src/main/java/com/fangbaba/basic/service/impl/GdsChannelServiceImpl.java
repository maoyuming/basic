package com.fangbaba.basic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.fangbaba.basic.face.bean.GdsChannel;
import com.fangbaba.basic.mappers.GdsChannelMapper;
import com.fangbaba.basic.service.IGdsChannelService;

public class GdsChannelServiceImpl implements IGdsChannelService{

	
	@Autowired
	private GdsChannelMapper gdsChannelMapper;
	
	
	/**
	 * 保存数据
	 */
	@Override
	public int save(GdsChannel record) {
		return gdsChannelMapper.insertSelective(record);
	}

}
