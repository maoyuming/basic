package com.fangbaba.basic.face.service;

import java.util.List;

import com.fangbaba.basic.face.bean.RoomModel;

public interface RoomService {
	/**
	 * @param roomtypeid
	 * 根据房型id查询房间列表
	 */
	List<RoomModel> queryByRoomTypeId(Long roomtypeid);
}
