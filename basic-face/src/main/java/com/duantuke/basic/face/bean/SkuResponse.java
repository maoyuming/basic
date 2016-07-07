package com.duantuke.basic.face.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class SkuResponse implements Serializable{
	private BigDecimal totalPrice;//优惠后订单总价
	private BigDecimal originalPrice;//原订单总价

    private BigDecimal promotionPrice;//优惠金额
	
	private List<SkuInfo> list;//sku集合

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<SkuInfo> getList() {
		return list;
	}

	public void setList(List<SkuInfo> list) {
		this.list = list;
	}

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
