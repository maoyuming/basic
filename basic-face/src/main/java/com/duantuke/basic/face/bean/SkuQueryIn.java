package com.duantuke.basic.face.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * sku查询入参
 * @author tankai
 *
 */
public class SkuQueryIn implements Serializable{
	private Map<Integer, List<Long>> skuMap;//key :sku类型，1房型，2餐饮 ;value:skuid集合  包括房型id，餐饮id等
	private Long hotelId;//酒店id
	private Date beginTime;//入住预抵时间
	private Date endTime;//入住预离时间
	private List<Long> promotionIds;//促销集合
	public Map<Integer, List<Long>> getSkuMap() {
		return skuMap;
	}
	public void setSkuMap(Map<Integer, List<Long>> skuMap) {
		this.skuMap = skuMap;
	}
	public Long getHotelId() {
		return hotelId;
	}
	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
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
