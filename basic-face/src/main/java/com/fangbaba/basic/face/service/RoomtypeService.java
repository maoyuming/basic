package com.fangbaba.basic.face.service;


import java.math.BigDecimal;
import java.util.List;

import com.fangbaba.basic.face.bean.RoomtypeModel;

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
}
