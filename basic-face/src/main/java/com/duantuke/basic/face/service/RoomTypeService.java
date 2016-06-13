package com.duantuke.basic.face.service;

import java.util.List;

import com.duantuke.basic.po.RoomType;

/**
 * @author he
 * 房型相关接口
 */
public interface RoomTypeService {
	public int addRoomType(RoomType roomType);
	public int updateRoomType(RoomType roomType);
	public int delRoomTypeById(Long id);
	public List<RoomType> queryRoomTypes(RoomType roomType);
	
	public List<RoomType> queryRoomtypeByHotleId(Long hotelId);
	public RoomType queryRoomtypeByRoomtypeId(Long roomtypeId);
	public List<RoomType> queryRoomtypeByRoomtypeIds(List<Long> roomtypeIds);
}
