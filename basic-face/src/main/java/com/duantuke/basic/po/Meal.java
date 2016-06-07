package com.duantuke.basic.po;

import java.io.Serializable;
import java.util.Date;

public class Meal implements Serializable{
	private static final long serialVersionUID = 1L;
    private Long id;

    private String meatVegetable;

    private Integer peopleNumber;

    private Date createTime;

    private String createBy;

    private Date updateTime;

    private String updateBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMeatVegetable() {
        return meatVegetable;
    }

    public void setMeatVegetable(String meatVegetable) {
        this.meatVegetable = meatVegetable == null ? null : meatVegetable.trim();
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
}