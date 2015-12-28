package com.fangbaba.basic.service;

import java.util.List;

import com.fangbaba.basic.po.HotelModel;

public interface HotelSearchService {
	/**
	 * 初始化所有酒店到es
	 * @return
	 */
	void initHotelsToEs();
	
	
	
	/**
	 * 更新ES酒店信息
	 * @param hotelModel
	 */
	boolean updateES(HotelModel hotelModel);
	
	/**
	 * 酒店信息插入ES
	 * @param hotelModel
	 * @return
	 */
	boolean insertES(HotelModel hotelModel);
	
	/**
	 * 删除ES酒店信息
	 * @param hotelModel
	 * @return
	 */
	boolean delES(HotelModel hotelModel);
	
	/**
	 * ota搜索接口，返回符合条件的酒店列表
	 * @param hotelModel
	 * @return
	 */
	List<HotelModel> searchHotelFromES(HotelModel hotelModel,int page,int size);
}
