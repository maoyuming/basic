package com.duantuke.basic.face.service;

import java.util.List;

import com.duantuke.basic.po.Sale;
import com.duantuke.basic.po.SalesRHotel;

public interface SaleService {
	

	/**
	 * 根据手机号码查询销售消息
	 */
	public Sale querySaleByPhone(String phone);
	
	/**
	 * 根据销售id查询销售信息
	 * @param saleId
	 * @return
	 */
	public Sale querySaleById(Long saleId) ;

	/**
	 * 根据酒店id查询销售信息
	 * @param hotelId
	 * @return
	 */
	public Sale querySaleByHotelId(Long hotelId) ;
	
	
	/**
	 * 根据酒店id或者销售id查询关系
	 * @param hotelId
	 * @param saleId
	 * @return
	 */
	public List<SalesRHotel> querySalesRHotel(Long hotelId,Long saleId);
	
}
