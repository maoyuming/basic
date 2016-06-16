package com.duantuke.basic.face.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class SkuResponse implements Serializable{
	private BigDecimal totalPrice;//订单总价
	
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
	
	
	
	
	
}
