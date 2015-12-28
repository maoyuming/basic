package com.fangbaba.basic.service;

import java.util.List;

import com.fangbaba.basic.po.RoomModel;

public interface RoomService {
	/**
	 * @param roomtypeid
	 * 根据房型id查询房间列表
	 */
	List<RoomModel> queryByRoomTypeId(Long roomtypeid);
}
