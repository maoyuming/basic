package com.duantuke.basic.po;

import java.util.Date;

public class HotelPriceConfig {
    private Long hotelPriceConfigId;

    private Long hotelId;

    private Double rack;

    private Double daily;

    private Double weekend;

    private Short rackType;

    private Short dailyType;

    private Short weekendType;

    private Date createtime;

    private String createuser;

    private Date updatetime;

    private String updateuser;

    public Long getHotelPriceConfigId() {
        return hotelPriceConfigId;
    }

    public void setHotelPriceConfigId(Long hotelPriceConfigId) {
        this.hotelPriceConfigId = hotelPriceConfigId;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public Double getRack() {
        return rack;
    }

    public void setRack(Double rack) {
        this.rack = rack;
    }

    public Double getDaily() {
        return daily;
    }

    public void setDaily(Double daily) {
        this.daily = daily;
    }

    public Double getWeekend() {
        return weekend;
    }

    public void setWeekend(Double weekend) {
        this.weekend = weekend;
    }

    public Short getRackType() {
        return rackType;
    }

    public void setRackType(Short rackType) {
        this.rackType = rackType;
    }

    public Short getDailyType() {
        return dailyType;
    }

    public void setDailyType(Short dailyType) {
        this.dailyType = dailyType;
    }

    public Short getWeekendType() {
        return weekendType;
    }

    public void setWeekendType(Short weekendType) {
        this.weekendType = weekendType;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getCreateuser() {
        return createuser;
    }

    public void setCreateuser(String createuser) {
        this.createuser = createuser == null ? null : createuser.trim();
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getUpdateuser() {
        return updateuser;
    }

    public void setUpdateuser(String updateuser) {
        this.updateuser = updateuser == null ? null : updateuser.trim();
    }
}