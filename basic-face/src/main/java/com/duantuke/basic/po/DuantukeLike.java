package com.duantuke.basic.po;

import java.io.Serializable;
import java.util.Date;

public class DuantukeLike implements Serializable{
	private static final long serialVersionUID = 1L;
    private Long duantukeLikeId;

    private Long fid;

    private Long customerId;

    private Integer duantukeLike;

    private Integer follow;

    private Short optType;

    private Short businessType;

    private Date createtime;

    private String createuser;

    private Date updatetime;

    private String updateuser;

    public Long getDuantukeLikeId() {
        return duantukeLikeId;
    }

    public void setDuantukeLikeId(Long duantukeLikeId) {
        this.duantukeLikeId = duantukeLikeId;
    }

    public Long getFid() {
        return fid;
    }

    public void setFid(Long fid) {
        this.fid = fid;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Integer getDuantukeLike() {
        return duantukeLike;
    }

    public void setDuantukeLike(Integer duantukeLike) {
        this.duantukeLike = duantukeLike;
    }

    public Integer getFollow() {
        return follow;
    }

    public void setFollow(Integer follow) {
        this.follow = follow;
    }

    public Short getOptType() {
        return optType;
    }

    public void setOptType(Short optType) {
        this.optType = optType;
    }

    public Short getBusinessType() {
        return businessType;
    }

    public void setBusinessType(Short businessType) {
        this.businessType = businessType;
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