package com.fangbaba.basic.face.service;

import com.fangbaba.basic.face.bean.HotelExtension;

public interface HotelExtensionService {
	/**
	 * 根据hotelid返回酒店扩展信息
	 *
	 * @param hotelid
	 * @return
	 */
	public HotelExtension getHotelExtension(Long hotelid);

	Integer saveHotelExtension(HotelExtension hotelExtension);

	Integer updateHotelExtension(HotelExtension hotelExtension);

	Integer delHotelExtension(Long id);
}
