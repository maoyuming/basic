package com.duantuke.basic.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


import com.alibaba.fastjson.annotation.JSONField;

public class RoomType extends Sku implements Serializable{
	private static final long serialVersionUID = 1L;
	

    private Integer roomNum;
    private Integer orderNum;

    @JSONField(name = "roomtypeType")
    private  Integer type;

    private Integer bedtype;

    private Integer bedsize;

    private BigDecimal area;

    @JSONField(name = "roomtypeCreateTime")
    private Date createTime;

    @JSONField(name = "roomtypeCreateBy")
    private String createBy;

    @JSONField(name = "roomtypeUpdateTime")
    private Date updateTime;

    @JSONField(name = "roomtypeUpdateBy")
    private String updateBy;


    public Integer getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(Integer roomNum) {
        this.roomNum = roomNum;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getBedtype() {
        return bedtype;
    }

    public void setBedtype(Integer bedtype) {
        this.bedtype = bedtype;
    }

    public Integer getBedsize() {
        return bedsize;
    }

    public void setBedsize(Integer bedsize) {
        this.bedsize = bedsize;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

	public Integer getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}
    
}