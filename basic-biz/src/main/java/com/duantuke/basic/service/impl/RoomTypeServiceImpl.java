package com.duantuke.basic.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
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
public class RoomTypeServiceImpl implements RoomTypeService {
	
	private static Logger logger = LoggerFactory.getLogger(RoomTypeServiceImpl.class);
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
		RoomTypeServiceImpl.logger.info(RoomTypeServiceImpl.class.getName() + ":queryByHotelId begin");
		try {
			RoomTypeExample roomTypeExample = new RoomTypeExample();
			Criteria criteria =  roomTypeExample.createCriteria();
			criteria.andSkuIdEqualTo(roomType.getSkuId());
			return roomTypeMapper.selectByExample(roomTypeExample);
		} catch (Exception e) {
			RoomTypeServiceImpl.logger.error(RoomTypeServiceImpl.class.getName() + ":queryByHotelId error", e);
			throw e;
		}
	}
	@Override
	public List<RoomType> queryRoomtypeByHotleId(Long hotelId) {
		RoomTypeExample roomTypeExample = new RoomTypeExample();
		Criteria criteria =  roomTypeExample.createCriteria();
		criteria.andSupplierIdEqualTo(hotelId);
		List<RoomType> list = roomTypeMapper.selectByExample(roomTypeExample);
		return list;
	}

	@Override
	public RoomType queryRoomtypeByRoomtypeId(Long roomtypeId) {
		RoomTypeExample roomTypeExample = new RoomTypeExample();
		Criteria criteria =  roomTypeExample.createCriteria();
		criteria.andSkuIdEqualTo(roomtypeId);
		
		List<RoomType> list = roomTypeMapper.selectByExample(roomTypeExample);
		if(CollectionUtils.isNotEmpty(list)){
			return list.get(0);
		}
		return null;
	}

	@Override
	public List<RoomType> queryRoomtypeByRoomtypeIds(List<Long> roomtypeIds) {
		List<RoomType> allList =new ArrayList<RoomType>();
		for (Long roomtypeId : roomtypeIds) {
			RoomTypeExample roomTypeExample = new RoomTypeExample();
			Criteria criteria =  roomTypeExample.createCriteria();
			criteria.andSkuIdEqualTo(roomtypeId);
			
			List<RoomType> list = roomTypeMapper.selectByExample(roomTypeExample);
			if(CollectionUtils.isNotEmpty(list)){
				allList.addAll(list);
			}
		}
		return allList;
	}
	

}
