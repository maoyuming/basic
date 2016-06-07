package com.duantuke.basic.po;

import java.io.Serializable;
import java.util.Date;

public class SightRank implements Serializable{
	private static final long serialVersionUID = 1L;
    private Long sightRankId;

    private Long sightId;

    private Integer rank;

    private Integer follow;

    private Integer comment;

    private Integer travel;

    private Date createtime;

    private String createuser;

    private Date updatetime;

    private String updateuser;

    public Long getSightRankId() {
        return sightRankId;
    }

    public void setSightRankId(Long sightRankId) {
        this.sightRankId = sightRankId;
    }

    public Long getSightId() {
        return sightId;
    }

    public void setSightId(Long sightId) {
        this.sightId = sightId;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Integer getFollow() {
        return follow;
    }

    public void setFollow(Integer follow) {
        this.follow = follow;
    }

    public Integer getComment() {
        return comment;
    }

    public void setComment(Integer comment) {
        this.comment = comment;
    }

    public Integer getTravel() {
        return travel;
    }

    public void setTravel(Integer travel) {
        this.travel = travel;
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