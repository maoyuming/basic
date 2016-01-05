package com.fangbaba.basic.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.lucene.util.CollectionUtil;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fangbaba.basic.face.bean.OtaRoomtype;
import com.fangbaba.basic.mappers.OtaRoomtypeMapper;
import com.fangbaba.basic.po.OtaRoomtypeExample;
import com.fangbaba.basic.po.OtaRoomtypeExample.Criteria;
import com.fangbaba.basic.service.OtaRoomtypeService;

@Service
public class OtaRoomtypeServiceImpl implements OtaRoomtypeService{

	@Autowired
	private OtaRoomtypeMapper otaRoomtypeMapper;
	

	@Autowired
	private Mapper dozerMapper;
	
	/**
	 * 查询待发布房型
	 * @return
	 */
	public List<OtaRoomtype> queryWaitDeploy(){

		OtaRoomtypeExample example = new OtaRoomtypeExample();

		Criteria criteria = example.createCriteria();
		criteria.andIsdeployEqualTo(1);
		criteria.andOtatypeEqualTo(1);
		

		List<OtaRoomtype> newList = new ArrayList<OtaRoomtype>();
		List<com.fangbaba.basic.po.OtaRoomtype> list = otaRoomtypeMapper.selectByExample(example);
		
		if(CollectionUtils.isNotEmpty(list)){
			for (com.fangbaba.basic.po.OtaRoomtype otaRoomtype : list) {
				OtaRoomtype otaRoomtype2 = dozerMapper.map(otaRoomtype, OtaRoomtype.class);
				newList.add(otaRoomtype2);
			}
		}
		
		return newList;
	}
}
