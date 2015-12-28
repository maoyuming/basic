package com.fangbaba.basic.service;

import java.util.List;

import com.fangbaba.basic.po.HotelModel;

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
