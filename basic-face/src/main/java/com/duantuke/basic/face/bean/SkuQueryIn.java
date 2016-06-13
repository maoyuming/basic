package com.duantuke.basic.face.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * sku查询入参
 * @author tankai
 *
 */
public class SkuQueryIn implements Serializable{
	private Long skuId;//skuid  包括房型id，餐饮id等
	private Long hotelId;//酒店id
	private Integer type;//sku类型，1房型，2餐饮
	private Date beginTime;//入住预抵时间
	private Date endTime;//入住预离时间
	private List<Long> promotionIds;//促销集合
	public Long getSkuId() {
		return skuId;
	}
	public void setSkuId(Long skuId) {
		this.skuId = skuId;
	}
	public Long getHotelId() {
		return hotelId;
	}
	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Date getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public List<Long> getPromotionIds() {
		return promotionIds;
	}
	public void setPromotionIds(List<Long> promotionIds) {
		this.promotionIds = promotionIds;
	}
	
	
	
	
	
	
	
	
}
