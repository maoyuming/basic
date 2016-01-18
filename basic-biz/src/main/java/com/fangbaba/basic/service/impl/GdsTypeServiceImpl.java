package com.fangbaba.basic.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fangbaba.basic.face.bean.GdsType;
import com.fangbaba.basic.mappers.GdsTypeMapper;
import com.fangbaba.basic.po.GdsTypeExample;
import com.fangbaba.basic.po.GdsTypeExample.Criteria;
import com.fangbaba.basic.service.IGdsTypeService;

@Service
public class GdsTypeServiceImpl implements IGdsTypeService {
	
	@Autowired
	private GdsTypeMapper gdsTypeMapper;
	
	
	/**
	 * 保存数据
	 */
	@Override
	public int save(GdsType record) {
		return gdsTypeMapper.insertSelective(record);
	}


	
	/**
	 * 根据分销商类型查询分销商配置信息
	 */
	@Override
	public GdsType queryGdsTypeByOtatype(Integer otatype) {
		GdsTypeExample example = new GdsTypeExample();
		Criteria criteria = 	example.createCriteria();
		criteria.andOtatypeEqualTo(otatype);
		List<GdsType> list = gdsTypeMapper.selectByExample(example);
		if(CollectionUtils.isNotEmpty(list)){
			return list.get(0);
		}
		return null;
	}



	@Override
	public List<GdsType> queryGdsTypeByChannelid(Integer channelid) {

		GdsTypeExample example = new GdsTypeExample();
		Criteria criteria = 	example.createCriteria();
		criteria.andChannelidEqualTo(channelid);
		List<GdsType> list = gdsTypeMapper.selectByExample(example);
		return list;
	}

	
	
	
}
