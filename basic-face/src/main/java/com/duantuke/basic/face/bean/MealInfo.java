package com.duantuke.basic.face.bean;

import java.io.Serializable;
import java.math.BigDecimal;

import com.duantuke.basic.po.Meal;

public class MealInfo extends Meal implements Serializable{
	private static final long serialVersionUID = 1L;

	private BigDecimal originalPrice;//原价
    private BigDecimal promotionPrice;//优惠金额
	public BigDecimal getOriginalPrice() {
		return originalPrice;
	}
	public void setOriginalPrice(BigDecimal originalPrice) {
		this.originalPrice = originalPrice;
	}
	public BigDecimal getPromotionPrice() {
		return promotionPrice;
	}
	public void setPromotionPrice(BigDecimal promotionPrice) {
		this.promotionPrice = promotionPrice;
	}
    
    
}