package com.duantuke.basic.po;

import java.io.Serializable;
import java.util.Date;

public class DuantukeComment implements Serializable{
	private static final long serialVersionUID = 1L;
    private Long duantukeCommentId;

    private Long fid;

    private Long hotelId;

    private Long customerId;

    private Integer duantukeComment;

    private Short businessType;

    private Date createtime;

    private String createuser;

    private Date updatetime;

    private String updateuser;

    public Long getDuantukeCommentId() {
        return duantukeCommentId;
    }

    public void setDuantukeCommentId(Long duantukeCommentId) {
        this.duantukeCommentId = duantukeCommentId;
    }

    public Long getFid() {
        return fid;
    }

    public void setFid(Long fid) {
        this.fid = fid;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Integer getDuantukeComment() {
        return duantukeComment;
    }

    public void setDuantukeComment(Integer duantukeComment) {
        this.duantukeComment = duantukeComment;
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