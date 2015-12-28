package com.fangbaba.basic.face.bean;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 价格实体
 * @author tankai
 *
 */
public class GdsPrice implements Serializable{
	/**
	 * 前端销售价格
	 */
    private BigDecimal salePrice;
    /**
     * 酒店价格
     */
    private BigDecimal hotelPrice;
	public BigDecimal getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}
	public BigDecimal getHotelPrice() {
		return hotelPrice;
	}
	public void setHotelPrice(BigDecimal hotelPrice) {
		this.hotelPrice = hotelPrice;
	}
    
    
} 
