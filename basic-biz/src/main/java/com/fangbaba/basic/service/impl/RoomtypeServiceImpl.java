package com.fangbaba.basic.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fangbaba.basic.face.bean.RoomtypeModel;
import com.fangbaba.basic.face.service.RoomtypeService;
import com.fangbaba.basic.mappers.RoomtypeModelMapper;
import com.fangbaba.basic.po.RoomtypeModelExample;

/**
 * @author he
 * 房型相关接口
 */
@Service
public class RoomtypeServiceImpl implements RoomtypeService {

	@Autowired
	private RoomtypeModelMapper roomtypeModelMapper;
	
	@Override
	public BigDecimal queryPriceByRoomTypeId(Long id) {
		RoomtypeModel bean =  roomtypeModelMapper.selectByPrimaryKey(id);
		if(bean==null){
			return null;
		}
		return bean.getCost();
	}

	@Override
	public List<RoomtypeModel> queryByHotelId(Long hotelid) {
		RoomtypeModelExample example = new RoomtypeModelExample();
		RoomtypeModelExample.Criteria criteria = example.createCriteria();
		criteria.andHotelidEqualTo(hotelid);
		return roomtypeModelMapper.selectByExample(example);
	}
	
	
}
