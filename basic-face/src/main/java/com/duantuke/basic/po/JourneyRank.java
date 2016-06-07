package com.duantuke.basic.po;

import java.io.Serializable;
import java.util.Date;

public class JourneyRank implements Serializable{
	private static final long serialVersionUID = 1L;
    private Long journeyRankId;

    private Long journeyId;

    private Integer rank;

    private Integer follow;

    private Integer roomnight;

    private Integer comment;

    private Integer travel;

    private Integer view;

    private Integer journeyLike;

    private Integer share;

    private Date createtime;

    private String createuser;

    private Date updatetime;

    private String updateuser;

    public Long getJourneyRankId() {
        return journeyRankId;
    }

    public void setJourneyRankId(Long journeyRankId) {
        this.journeyRankId = journeyRankId;
    }

    public Long getJourneyId() {
        return journeyId;
    }

    public void setJourneyId(Long journeyId) {
        this.journeyId = journeyId;
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

    public Integer getRoomnight() {
        return roomnight;
    }

    public void setRoomnight(Integer roomnight) {
        this.roomnight = roomnight;
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

    public Integer getView() {
        return view;
    }

    public void setView(Integer view) {
        this.view = view;
    }

    public Integer getJourneyLike() {
        return journeyLike;
    }

    public void setJourneyLike(Integer journeyLike) {
        this.journeyLike = journeyLike;
    }

    public Integer getShare() {
        return share;
    }

    public void setShare(Integer share) {
        this.share = share;
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