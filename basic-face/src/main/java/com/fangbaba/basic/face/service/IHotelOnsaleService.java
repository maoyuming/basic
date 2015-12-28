package com.fangbaba.basic.face.service;

import com.fangbaba.basic.face.base.RetInfo;
import com.fangbaba.basic.face.bean.GdsPrice;
import com.fangbaba.basic.face.bean.HotelPriceQueryIn;

/**
 * 查询酒店价格服务
 * @author tankai
 *
 */
public interface IHotelOnsaleService {
	/**
	 * 查询gds价格：销售价格和酒店结算价格
	 * @param HotelPriceQueryIn  根据酒店id，房型id，订单时间，计算需要查询的价格 
	 * @return
	 */
	public RetInfo<GdsPrice> queryGdsPrice(HotelPriceQueryIn hotelPriceQueryIn);
}
