package com.fangbaba.basic.service;

public interface HotelService extends com.fangbaba.basic.face.service.HotelService {
	/**
	 * 同步酒店信息
	 * @param json
	 */
	void syncHotelInfo(String json);
}
