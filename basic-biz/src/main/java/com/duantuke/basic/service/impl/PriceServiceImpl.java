package com.duantuke.basic.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.duantuke.basic.face.service.PriceService;

@Service
public class PriceServiceImpl implements PriceService{

	@Override
	public Map<Long, Map<String, BigDecimal>> queryHotelPrices(Long hotelId,
			Date begintime, Date endtime, Long roomtypeId) {
		// TODO Auto-generated method stub
		return null;
	}

}
