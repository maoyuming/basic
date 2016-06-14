package com.duantuke.basic.esbean.input;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.elasticsearch.common.geo.GeoPoint;

import com.duantuke.basic.po.Tag;

public class HotelInputBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long hotelId;

    private String hotelName;

    private String hotelContactName;

    private Date regTime;

    private String detailAddr;

    private BigDecimal longitude;

    private BigDecimal latitude;

    private Date openTime;

    private Date repairTime;

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

    private Integer state;

    private String pics;

    private String introduction;
    private String readonly;

    private String createtime;
    
    private Long hotelRankId;//农家院评级id
    private Integer rank;//评级
    private Integer follow;//关注数
    private Integer roomnight;//间夜数
    private Integer comment;//评论数
    private Integer travel;//游记数
    private GeoPoint pin;// 坐标
    private List<Tag> taggroup_1 = new ArrayList<Tag>();
    private List<Tag> taggroup_2 = new ArrayList<Tag>();
    private List<Tag> taggroup_3 = new ArrayList<Tag>();
    private List<Tag> taggroup_4 = new ArrayList<Tag>();
    
    
    
	public String getReadonly() {
		return readonly;
	}
	public void setReadonly(String readonly) {
		this.readonly = readonly;
	}
	public List<Tag> getTaggroup_1() {
		return taggroup_1;
	}
	public void setTaggroup_1(List<Tag> taggroup_1) {
		this.taggroup_1 = taggroup_1;
	}
	public List<Tag> getTaggroup_2() {
		return taggroup_2;
	}
	public void setTaggroup_2(List<Tag> taggroup_2) {
		this.taggroup_2 = taggroup_2;
	}
	public List<Tag> getTaggroup_3() {
		return taggroup_3;
	}
	public void setTaggroup_3(List<Tag> taggroup_3) {
		this.taggroup_3 = taggroup_3;
	}
	public List<Tag> getTaggroup_4() {
		return taggroup_4;
	}
	public void setTaggroup_4(List<Tag> taggroup_4) {
		this.taggroup_4 = taggroup_4;
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
	public Date getRegTime() {
		return regTime;
	}
	public void setRegTime(Date regTime) {
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
	public Date getOpenTime() {
		return openTime;
	}
	public void setOpenTime(Date openTime) {
		this.openTime = openTime;
	}
	public Date getRepairTime() {
		return repairTime;
	}
	public void setRepairTime(Date repairTime) {
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
	public GeoPoint getPin() {
		return pin;
	}
	public void setPin(GeoPoint pin) {
		this.pin = pin;
	}

}
