package com.duantuke.basic.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duantuke.basic.esbean.input.HotelInputBean;
import com.duantuke.basic.mappers.HotelMapper;
import com.duantuke.basic.po.Hotel;
import com.duantuke.basic.po.HotelExample;
import com.duantuke.basic.service.IHotelService;

/**
 * @author he
 * 酒店相关接口
 */
@Service
public class HotelServiceImpl implements IHotelService {
	
	private static Logger logger = LoggerFactory.getLogger(HotelServiceImpl.class);
	
	@Autowired
	private HotelMapper hotelmapper;

	@Override
	public int addHotel(Hotel hotel) {
		return hotelmapper.insertSelective(hotel);
	}

	@Override
	public int updateHotel(Hotel hotel) {
		return hotelmapper.updateByPrimaryKeySelective(hotel);
	}

	@Override
	public int delHotelById(Long id) {
		return hotelmapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<Hotel> queryHotels(Hotel hotel) {
		HotelExample example = new HotelExample();
		HotelExample.Criteria criteria = example.createCriteria();
		if(hotel.getHotelName()!=null){
			criteria.andHotelNameLike("%"+hotel.getHotelName()+"%");
		}
		if(hotel.getIsvisible()!=null){
			criteria.andIsvisibleEqualTo(hotel.getIsvisible());
		}
		if(hotel.getHotelPhone()!=null){
			criteria.andHotelPhoneEqualTo(hotel.getHotelPhone());
		}
		if(hotel.getProvinceCode()!=null){
			criteria.andProvinceCodeEqualTo(hotel.getProvinceCode());
		}
		if(hotel.getCityCode()!=null){
			criteria.andCityCodeEqualTo(hotel.getCityCode());
		}
		if(hotel.getDistrictCode()!=null){
			criteria.andDistrictCodeEqualTo(hotel.getDistrictCode());
		}
		return hotelmapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public Hotel queryHotelById(Long id) {
		return hotelmapper.selectByPrimaryKey(id);
	}

	@Override
	public List<HotelInputBean> queryEsInputHotels(Long hotelId) {
		return hotelmapper.queryEsInputHotels(hotelId);
	}

}
