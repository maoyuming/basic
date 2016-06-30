package com.duantuke.basic.face.esbean.output;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author he
 * 农家院搜索结果输出bean
 */
public class HotelOutputBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long hotelId;

    private String hotelName;

    private String hotelContactName;

    private String regTime;

    private String detailAddr;

    private BigDecimal longitude;

    private BigDecimal latitude;

    private String openTime;

    private String repairTime;

    private String businessLicenseFront;

    private String businessLicenseBack;

    private String isvisible;

    private String idcardfront;

    private String idcardback;

    private String retentionTime;

    private String defaultLeaveTime;

    private String hotelPhone;

    private String qtPhone;

    private Integer provinceCode;

    private Integer cityCode;

    private Integer districtCode;

    private String hotelFax;
    private String readonly;

    private Integer state;

    private String pics;

    private String introduction;

    private String createtime;
    
    private Long hotelRankId;//农家院评级id
    private Integer rank;//评级
    private Integer follow;//关注数
    private Integer roomnight;//间夜数
    private Integer comment;//评论数
    private Integer travel;//游记数
    
    private Integer like;//收藏数量
    
    
	public String getReadonly() {
		return readonly;
	}
	public void setReadonly(String readonly) {
		this.readonly = readonly;
	}
	public Long getHotelId() {
		return hotelId;
	}
	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getHotelContactName() {
		return hotelContactName;
	}
	public void setHotelContactName(String hotelContactName) {
		this.hotelContactName = hotelContactName;
	}
	public String getRegTime() {
		return regTime;
	}
	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}
	public String getDetailAddr() {
		return detailAddr;
	}
	public void setDetailAddr(String detailAddr) {
		this.detailAddr = detailAddr;
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
		this.openTime = openTime;
	}
	public String getRepairTime() {
		return repairTime;
	}
	public void setRepairTime(String repairTime) {
		this.repairTime = repairTime;
	}
	public String getBusinessLicenseFront() {
		return businessLicenseFront;
	}
	public void setBusinessLicenseFront(String businessLicenseFront) {
		this.businessLicenseFront = businessLicenseFront;
	}
	public String getBusinessLicenseBack() {
		return businessLicenseBack;
	}
	public void setBusinessLicenseBack(String businessLicenseBack) {
		this.businessLicenseBack = businessLicenseBack;
	}
	public String getIsvisible() {
		return isvisible;
	}
	public void setIsvisible(String isvisible) {
		this.isvisible = isvisible;
	}
	public String getIdcardfront() {
		return idcardfront;
	}
	public void setIdcardfront(String idcardfront) {
		this.idcardfront = idcardfront;
	}
	public String getIdcardback() {
		return idcardback;
	}
	public void setIdcardback(String idcardback) {
		this.idcardback = idcardback;
	}
	public String getRetentionTime() {
		return retentionTime;
	}
	public void setRetentionTime(String retentionTime) {
		this.retentionTime = retentionTime;
	}
	public String getDefaultLeaveTime() {
		return defaultLeaveTime;
	}
	public void setDefaultLeaveTime(String defaultLeaveTime) {
		this.defaultLeaveTime = defaultLeaveTime;
	}
	public String getHotelPhone() {
		return hotelPhone;
	}
	public void setHotelPhone(String hotelPhone) {
		this.hotelPhone = hotelPhone;
	}
	public String getQtPhone() {
		return qtPhone;
	}
	public void setQtPhone(String qtPhone) {
		this.qtPhone = qtPhone;
	}
	public Integer getProvinceCode() {
		return provinceCode;
	}
	public void setProvinceCode(Integer provinceCode) {
		this.provinceCode = provinceCode;
	}
	public Integer getCityCode() {
		return cityCode;
	}
	public void setCityCode(Integer cityCode) {
		this.cityCode = cityCode;
	}
	public Integer getDistrictCode() {
		return districtCode;
	}
	public void setDistrictCode(Integer districtCode) {
		this.districtCode = districtCode;
	}
	public String getHotelFax() {
		return hotelFax;
	}
	public void setHotelFax(String hotelFax) {
		this.hotelFax = hotelFax;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getPics() {
		return pics;
	}
	public void setPics(String pics) {
		this.pics = pics;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public Long getHotelRankId() {
		return hotelRankId;
	}
	public void setHotelRankId(Long hotelRankId) {
		this.hotelRankId = hotelRankId;
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
	public Integer getLike() {
		return like;
	}
	public void setLike(Integer like) {
		this.like = like;
	}

}
