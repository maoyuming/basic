package com.duantuke.basic.face.bean;

import java.math.BigDecimal;
import java.util.List;

public class SkuResponse {
	private Long supplierId;//暂时只有酒店id,
	private String supplierName;//暂时只有酒店id,
	private BigDecimal totalPrice;//订单总价
	
	private List<SkuInfo> list;//sku集合

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

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
