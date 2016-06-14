package com.duantuke.basic.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class RoomType implements Serializable{
	private static final long serialVersionUID = 1L;
    private Long skuId;

    private Integer roomNum;

    private Integer type;

    private Integer bedtype;

    private Integer bedsize;

    private BigDecimal area;

    private Date createTime;

    private String createBy;

    private Date updateTime;

    private String updateBy;

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

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
}