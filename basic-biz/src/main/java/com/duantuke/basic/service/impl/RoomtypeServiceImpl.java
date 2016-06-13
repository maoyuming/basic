package com.duantuke.basic.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duantuke.basic.face.service.RoomTypeService;
import com.duantuke.basic.mappers.RoomTypeMapper;
import com.duantuke.basic.po.RoomType;
import com.duantuke.basic.po.RoomTypeExample;
import com.duantuke.basic.po.RoomTypeExample.Criteria;

/**
 * @author he
 * 房型相关接口
 */
@Service
public class RoomtypeServiceImpl implements RoomTypeService {
	
	private static Logger logger = LoggerFactory.getLogger(RoomtypeServiceImpl.class);
	@Autowired
	private RoomTypeMapper roomTypeMapper;
	
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
		RoomtypeServiceImpl.logger.info(RoomtypeServiceImpl.class.getName() + ":queryByHotelId begin");
		try {
			RoomTypeExample roomTypeExample = new RoomTypeExample();
			Criteria criteria =  roomTypeExample.createCriteria();
			criteria.andIdEqualTo(roomType.getId());
			return roomTypeMapper.selectByExample(roomTypeExample);
		} catch (Exception e) {
			RoomtypeServiceImpl.logger.error(RoomtypeServiceImpl.class.getName() + ":queryByHotelId error", e);
			throw e;
		}
	}
}
