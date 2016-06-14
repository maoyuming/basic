package com.duantuke.basic.face.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * sku查询入参
 * @author tankai
 *
 */
public class CopyOfSkuInfo implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//	private Long skuId;//skuid  包括房型id，餐饮id等,如果不传，返回hotelid下所有房型、套餐
	private Long supplierId;//暂时只有酒店id,
	private String supplierName;//暂时只有酒店id,
//	private Integer type;//sku类型，1房型，2餐饮
//	private String skuName;//商品名称
	private BigDecimal totalPrice;//订单总价
	private List<RoomTypeInfo> roomTypeInfos;
	private List<MealInfo> mealInfos;
	
	
	
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
	public List<RoomTypeInfo> getRoomTypeInfos() {
		return roomTypeInfos;
	}
	public void setRoomTypeInfos(List<RoomTypeInfo> roomTypeInfos) {
		this.roomTypeInfos = roomTypeInfos;
	}
	public List<MealInfo> getMealInfos() {
		return mealInfos;
	}
	public void setMealInfos(List<MealInfo> mealInfos) {
		this.mealInfos = mealInfos;
	}
	
	
	
	
}
