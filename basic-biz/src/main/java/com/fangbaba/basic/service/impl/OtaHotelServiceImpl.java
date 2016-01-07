package com.fangbaba.basic.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fangbaba.basic.face.bean.OtaHotel;
import com.fangbaba.basic.face.enums.OtaDeployStatusEnum;
import com.fangbaba.basic.mappers.OtaHotelMapper;
import com.fangbaba.basic.po.OtaHotelExample;
import com.fangbaba.basic.po.OtaHotelExample.Criteria;
import com.fangbaba.basic.service.OtaHotelService;

@Service
public class OtaHotelServiceImpl implements OtaHotelService{

	@Autowired
	private OtaHotelMapper otaHotelMapper;

	@Autowired
	private Mapper dozerMapper;
	
	/**
	 * 查询待发布酒店
	 * @return
	 */
	public List<OtaHotel> queryOtaHotelByDeploy(OtaDeployStatusEnum deployStatusEnum){

		OtaHotelExample example = new OtaHotelExample();

		Criteria criteria = example.createCriteria();
		criteria.andIsdeployEqualTo(deployStatusEnum.getId());
		criteria.andOtatypeEqualTo(1);
		
		List<OtaHotel> newList = new ArrayList<OtaHotel>();
		List<com.fangbaba.basic.po.OtaHotel> list = otaHotelMapper.selectByExample(example);
		
		
		if(CollectionUtils.isNotEmpty(list)){
			for (com.fangbaba.basic.po.OtaHotel otaHotel : list) {
				OtaHotel otaHotel2 = dozerMapper.map(otaHotel, OtaHotel.class);
				newList.add(otaHotel2);
			}
		}
		
		return newList;
	}
	
	/**
	 * 更新状态
	 * @return
	 */
	public Integer 	updateOtaHotel(OtaHotel otaHotel){
		
		com.fangbaba.basic.po.OtaHotel record =  dozerMapper.map(otaHotel, com.fangbaba.basic.po.OtaHotel.class);
		record.setOtatype(1);
		OtaHotelExample example = new OtaHotelExample();

		Criteria criteria = example.createCriteria();
		criteria.andOtatypeEqualTo(1);
		criteria.andHotelidEqualTo(otaHotel.getHotelid());
		
		return otaHotelMapper.updateByExampleSelective(record, example);
	}
}