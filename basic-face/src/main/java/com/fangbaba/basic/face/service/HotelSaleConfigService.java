package com.fangbaba.basic.face.service;

import com.fangbaba.basic.face.bean.HotelSaleConfig;

public interface HotelSaleConfigService {
	void saveConfig(Long hotelid,Integer salenum);
	HotelSaleConfig queryByHotelId(Long hotelid);
}
