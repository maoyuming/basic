package com.fangbaba.basic.service;

import java.util.List;

import com.fangbaba.basic.face.bean.jsonbean.PmsRoomJsonBean;

public interface RoomService extends com.fangbaba.basic.face.service.RoomService {
	/**
	 * 同步房间信息
	 * @param json
	 */
	void syncRoomInfo(Long roomtypeid,List<PmsRoomJsonBean> rooms);
	/**
	 * 根据房型删除房间
	 */
	void delRoomByRoomtypeid(Long roomtypeid);
}
