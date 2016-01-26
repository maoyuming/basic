package com.fangbaba.basic.face.service;

import java.util.List;

import com.fangbaba.basic.face.bean.RoomModel;

public interface RoomService {
	/**
	 * @param roomtypeid
	 *            根据房型id查询房间列表
	 */
	List<RoomModel> queryByRoomTypeId(Long roomtypeid);

	/**
	 * @param pms
	 *            通过pms号查询
	 */
	RoomModel queryByPms(String pms);

	/**
	 * @param id
	 *            通过id查询
	 */
	RoomModel queryById(Long id);

	/**
	 * 根据房型id和房间号返回房间信息
	 * 
	 * @param roomtypeid
	 * @param roomnoLong
	 * @return
	 */
	RoomModel getRoomByRoomTypeidAndRoomNo(Long roomtypeid, String roomnoLong);
}
