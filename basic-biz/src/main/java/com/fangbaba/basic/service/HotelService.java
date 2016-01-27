package com.fangbaba.basic.service;

import java.util.List;
import java.util.Map;

import com.fangbaba.basic.face.bean.HotelModel;

public interface HotelService extends com.fangbaba.basic.face.service.HotelService {
	/**
	 * 同步酒店信息
	 *
	 * @param json
	 */
	void syncHotelInfo(String json);
	
	Map<String,Object> queryByConditions(HotelModel hotelModel,Integer pageNo,Integer pageSize);

}
