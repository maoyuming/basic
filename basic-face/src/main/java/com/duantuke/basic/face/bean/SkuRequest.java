package com.duantuke.basic.face.bean;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * sku查询入参
 * @author tankai
 *
 */
public class SkuRequest implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<Integer, List<Long>> skuMap;//key :sku类型，1房型，2餐饮 ;value:skuid集合  包括房型id，餐饮id等
	private Long hotelId;//酒店id
	private Date beginTime;//入住预抵时间 
	private Date endTime;//入住预离时间 
	private String beginDate;//入住预抵时间 格式 yyyy-MM-dd
	private String endDate;//入住预离时间 格式 yyyy-MM-dd
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
	public List<Long> getPromotionIds() {
		return promotionIds;
	}
	public void setPromotionIds(List<Long> promotionIds) {
		this.promotionIds = promotionIds;
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
	public String getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
		if(beginDate!=null){
			beginTime = strToDate(beginDate, "yyyy-MM-dd");
		}
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
		if(endDate!=null){
			endTime = strToDate(endDate, "yyyy-MM-dd");
		}
	}
	
	public static Date strToDate(String date ,String pattern) {
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		Date d = null;
		try {
			d = format.parse(date);
		} catch (Exception e) {
		}
		return d;
	}
	
	
}
