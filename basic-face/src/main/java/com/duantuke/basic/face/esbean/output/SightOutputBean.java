package com.duantuke.basic.face.esbean.output;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author he
 * 景点搜索结果输出bean
 */
public class SightOutputBean implements Serializable{

	private static final long serialVersionUID = 1L;
    private Long sightId;

    private String sightName;

    private BigDecimal longitude;

    private BigDecimal latitude;

    private String openTime;

    private String phone;

    private String traffic;

    private String price;

    private String pics;

    private String memo;

    private Integer provcode;

    private Integer citycode;

    private Integer discode;

    private Long sightRankId;//景点评级id
    private Integer rank;//评级
    private Integer follow;//关注数
    private Integer comment;//评论数
    private Integer travel;//游记数
    
    public Long getSightId() {
        return sightId;
    }

    public void setSightId(Long sightId) {
        this.sightId = sightId;
    }

    public String getSightName() {
        return sightName;
    }

    public void setSightName(String sightName) {
        this.sightName = sightName == null ? null : sightName.trim();
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime == null ? null : openTime.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getTraffic() {
        return traffic;
    }

    public void setTraffic(String traffic) {
        this.traffic = traffic == null ? null : traffic.trim();
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    public String getPics() {
        return pics;
    }

    public void setPics(String pics) {
        this.pics = pics == null ? null : pics.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
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

	public Long getSightRankId() {
		return sightRankId;
	}

	public void setSightRankId(Long sightRankId) {
		this.sightRankId = sightRankId;
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


}
