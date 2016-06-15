package com.duantuke.basic.po;

import java.io.Serializable;
import java.util.Date;

public class HotWord implements Serializable{
	private static final long serialVersionUID = 1L;
	
    private Long id;

    private Integer provcode;

    private Integer citycode;

    private Integer discode;

    private Date createtime;

    private String createuser;

    private Date updatetime;

    private String updateuser;

    private String businessType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getProvcode() {
        return provcode;
    }

    public void setProvcode(Integer provcode) {
        this.provcode = provcode;
    }

    public Integer getCitycode() {
        return citycode;
    }

    public void setCitycode(Integer citycode) {
        this.citycode = citycode;
    }

    public Integer getDiscode() {
        return discode;
    }

    public void setDiscode(Integer discode) {
        this.discode = discode;
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

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType == null ? null : businessType.trim();
    }
}