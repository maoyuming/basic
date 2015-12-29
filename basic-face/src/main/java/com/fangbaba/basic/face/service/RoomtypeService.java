package com.fangbaba.basic.face.service;


import java.math.BigDecimal;
import java.util.List;

import com.fangbaba.basic.face.bean.HotelModel;
import com.fangbaba.basic.face.bean.RoomtypeModel;
import com.fangbaba.basic.face.bean.jsonbean.PmsRoomtypeJsonBean;

public interface RoomtypeService {
	/**
	 * @param id
	 * 通过房型查门市价
	 */
	BigDecimal queryPriceByRoomTypeId(Long id);
	/**
	 * @param hotelid
	 * 通过酒店id查询房型列表
	 */
	List<RoomtypeModel> queryByHotelId(Long hotelid);
	/**
	 * @param pms
	 * 通过pms号查询
	 */
	RoomtypeModel queryByPms(String pms);
	/**
	 * 同步房型信息
	 * @param json
	 */
	void syncRoomtypeInfo(Long hotelid,List<PmsRoomtypeJsonBean> roomtypes);
}
