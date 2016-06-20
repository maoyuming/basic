package com.duantuke.basic.face.bean;

import java.io.Serializable;

import com.duantuke.basic.po.Sku;

/**
 * sku查询入参
 * @author tankai
 *
 */
public class SkuInfo<T>  implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long skuId;//skuid  包括房型id，餐饮id等,如果不传，返回hotelid下所有房型、套餐
	private Integer type;//sku类型，1房型，2餐饮
	private String skuName;//商品名称
	private Long supplierId;//暂时只有酒店id,
	private String supplierName;//暂时只有酒店id,
    private String pics;//图片
    private String descrition;//描述
    private String memo;//
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
	public String getPics() {
		return pics;
	}
	public void setPics(String pics) {
		this.pics = pics;
	}
	public String getDescrition() {
		return descrition;
	}
	public void setDescrition(String descrition) {
		this.descrition = descrition;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	
	
	
	
}
