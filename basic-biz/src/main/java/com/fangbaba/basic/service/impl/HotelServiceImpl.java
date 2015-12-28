package com.fangbaba.basic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fangbaba.basic.face.bean.HotelModel;
import com.fangbaba.basic.face.service.HotelService;
import com.fangbaba.basic.face.service.RoomService;
import com.fangbaba.basic.face.service.RoomtypeService;
import com.fangbaba.basic.mappers.HotelModelMapper;

/**
 * @author he
 * 酒店相关接口
 */
@Service
public class HotelServiceImpl implements HotelService {
	
	@Autowired
	private HotelModelMapper hotelModelMapper;
	@Autowired
	private RoomtypeService roomtypeService;
	@Autowired
	private RoomService roomService;

	@Override
	public List<HotelModel> queryAllHotels() {
		return hotelModelMapper.selectByExampleWithBLOBs(null);
	}

	@Override
	public HotelModel queryById(Long id) {
		return hotelModelMapper.selectByPrimaryKey(id);
	}

}
