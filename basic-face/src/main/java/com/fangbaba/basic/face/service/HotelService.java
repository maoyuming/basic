package com.fangbaba.basic.face.service;

import java.util.List;

import com.fangbaba.basic.face.bean.HotelModel;

public interface HotelService {
	/**
	 * 查询所有酒店
	 * @return
	 */
	List<HotelModel> queryAllHotels();
	/**
	 * @param id
	 * 通过id查询
	 */
	HotelModel queryById(Long id);
}
