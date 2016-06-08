package com.duantuke.basic.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.duantuke.basic.face.service.RoomTypeService;
import com.duantuke.basic.po.RoomType;

/**
 * @author he
 * 房型相关接口
 */
@Service
public class RoomtypeServiceImpl implements RoomTypeService {
	
	private static Logger logger = LoggerFactory.getLogger(RoomtypeServiceImpl.class);

	@Override
	public int addRoomType(RoomType roomType) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateRoomType(RoomType roomType) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delRoomTypeById(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<RoomType> queryRoomTypes(RoomType roomType) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
