package com.duantuke.basic.face.bean;

import java.io.Serializable;

/**
 * sku查询入参
 * @author tankai
 *
 */
public class SkuInfo<T> implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long skuId;//skuid  包括房型id，餐饮id等,如果不传，返回hotelid下所有房型、套餐
	private Integer type;//sku类型，1房型，2餐饮
	private String skuName;//商品名称
	private T info;
	public Long getSkuId() {
		return skuId;
	}
	public void setSkuId(Long skuId) {
		this.skuId = skuId;
	}
	public String getSkuName() {
		return skuName;
	}
	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}
	public T getInfo() {
		return info;
	}
	public void setInfo(T info) {
		this.info = info;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	
	
	
	
	
}
