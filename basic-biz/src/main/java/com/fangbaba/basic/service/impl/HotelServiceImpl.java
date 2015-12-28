package com.fangbaba.basic.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fangbaba.basic.mappers.HotelModelMapper;
import com.fangbaba.basic.po.HotelModel;
import com.fangbaba.basic.po.RoomModel;
import com.fangbaba.basic.po.RoomtypeModel;
import com.fangbaba.basic.service.HotelService;
import com.fangbaba.basic.service.RoomService;
import com.fangbaba.basic.service.RoomtypeService;

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
