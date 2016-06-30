package com.duantuke.basic.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Meal extends Sku implements Serializable{
    private Long skuId;

    private String meatVegetable;

    private BigDecimal cost;

    private BigDecimal price;

    private BigDecimal suggestPrice;

    private Integer peopleNumber;
    /**
     * 预定数量
     */
    private Integer orderNum;

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

    public String getMeatVegetable() {
        return meatVegetable;
    }

    public void setMeatVegetable(String meatVegetable) {
        this.meatVegetable = meatVegetable == null ? null : meatVegetable.trim();
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
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

    public Integer getPeopleNumber() {
        return peopleNumber;
    }

    public void setPeopleNumber(Integer peopleNumber) {
        this.peopleNumber = peopleNumber;
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