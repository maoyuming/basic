package com.duantuke.basic.service;

import java.util.List;

import com.duantuke.basic.esbean.input.HotelInputBean;
import com.duantuke.basic.face.service.HotelService;

public interface IHotelService extends HotelService {
	public List<HotelInputBean> queryEsInputHotels(Long hotelId);
}
