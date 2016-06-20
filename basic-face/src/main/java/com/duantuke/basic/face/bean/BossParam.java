package com.duantuke.basic.face.bean;

import java.math.BigDecimal;

import com.duantuke.basic.po.Boss;

public class BossParam extends Boss{

    /**
     * 销售电话
     */
    private String salePhone;
    
    private String hotelName;
    
    private Long hotelId;
    

    private BigDecimal longitude;

    private BigDecimal latitude;
    
    

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public Long getHotelId() {
		return hotelId;
	}

	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}

	public String getSalePhone() {
		return salePhone;
	}

	public void setSalePhone(String salePhone) {
		this.salePhone = salePhone;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}
    
    
}
