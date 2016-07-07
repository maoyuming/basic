package com.duantuke.basic.face.bean;

import java.io.Serializable;
import java.math.BigDecimal;

public class PriceInfo implements Serializable{
    private String date;
    private BigDecimal price;

	private BigDecimal originalPrice;//原价
    private BigDecimal promotionPrice;//优惠金额
    
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getPromotionPrice() {
		return promotionPrice;
	}
	public void setPromotionPrice(BigDecimal promotionPrice) {
		this.promotionPrice = promotionPrice;
	}
	public BigDecimal getOriginalPrice() {
		return originalPrice;
	}
	public void setOriginalPrice(BigDecimal originalPrice) {
		this.originalPrice = originalPrice;
	}
    
    
}
