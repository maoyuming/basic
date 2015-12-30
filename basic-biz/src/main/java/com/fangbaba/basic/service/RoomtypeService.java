package com.fangbaba.basic.service;

import java.util.List;

import com.fangbaba.basic.face.bean.jsonbean.PmsRoomtypeJsonBean;

public interface RoomtypeService extends com.fangbaba.basic.face.service.RoomtypeService {
	/**
	 * 同步房型信息
	 * @param json
	 */
	void syncRoomtypeInfo(Long hotelid,List<PmsRoomtypeJsonBean> roomtypes);
}
