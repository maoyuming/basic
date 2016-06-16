package com.duantuke.basic.face.service;

import java.util.List;

import com.duantuke.basic.po.Hotel;

/**
 * @author he
 * 酒店相关接口
 */
public interface CustomerLikeHotelService {
	public List<Hotel> queryHotels(Long customerId);
}
