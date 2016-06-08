package com.duantuke.basic.face.service;

import java.util.List;

import com.duantuke.basic.po.Hotel;

/**
 * @author he
 * 酒店相关接口
 */
public interface HotelService {
	public int addHotel(Hotel hotel);
	public int updateHotel(Hotel hotel);
	public int delHotelById(Long id);
	public List<Hotel> queryHotels(Hotel hotel);
	public Hotel queryHotelById(Long id);
}
