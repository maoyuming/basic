package com.duantuke.basic.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class RackRate implements Serializable{
	private static final long serialVersionUID = 1L;
    private Long rackRateId;

    private Long hotelId;

    private Long roomtypeId;

    private BigDecimal price;

    private BigDecimal suggestPrice;

    private Date createtime;

    private String createuser;

    private Date updatetime;

    private String updateuser;

    public Long getRackRateId() {
        return rackRateId;
    }

    public void setRackRateId(Long rackRateId) {
        this.rackRateId = rackRateId;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public Long getRoomtypeId() {
        return roomtypeId;
    }

    public void setRoomtypeId(Long roomtypeId) {
        this.roomtypeId = roomtypeId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getSuggestPrice() {
        return suggestPrice;
    }

    public void setSuggestPrice(BigDecimal suggestPrice) {
        this.suggestPrice = suggestPrice;
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