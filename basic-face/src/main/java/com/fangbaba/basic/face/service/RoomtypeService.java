package com.fangbaba.basic.face.service;


import java.math.BigDecimal;
import java.util.List;

import com.fangbaba.basic.face.bean.HotelModel;
import com.fangbaba.basic.face.bean.RoomtypeModel;
import com.fangbaba.basic.face.bean.jsonbean.PmsRoomtypeJsonBean;

public interface RoomtypeService {
	/**
	 * @param id
	 * 通过房型id查门市价
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
	 * @param id
	 * 通过房型id查询
	 */
	RoomtypeModel queryById(Long id);
}
