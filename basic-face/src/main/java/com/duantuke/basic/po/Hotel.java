package com.duantuke.basic.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Hotel implements Serializable{
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

    private String readonly;

    private Integer state;

    private String pics;

    private Date createtime;

    private String createuser;

    private Date updatetime;

    private String updateuser;

    private String introduction;

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
        this.hotelName = hotelName == null ? null : hotelName.trim();
    }

    public String getHotelContactName() {
        return hotelContactName;
    }

    public void setHotelContactName(String hotelContactName) {
        this.hotelContactName = hotelContactName == null ? null : hotelContactName.trim();
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
        this.detailAddr = detailAddr == null ? null : detailAddr.trim();
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
        this.businessLicenseFront = businessLicenseFront == null ? null : businessLicenseFront.trim();
    }

    public String getBusinessLicenseBack() {
        return businessLicenseBack;
    }

    public void setBusinessLicenseBack(String businessLicenseBack) {
        this.businessLicenseBack = businessLicenseBack == null ? null : businessLicenseBack.trim();
    }

    public String getIsvisible() {
        return isvisible;
    }

    public void setIsvisible(String isvisible) {
        this.isvisible = isvisible == null ? null : isvisible.trim();
    }

    public String getIdcardfront() {
        return idcardfront;
    }

    public void setIdcardfront(String idcardfront) {
        this.idcardfront = idcardfront == null ? null : idcardfront.trim();
    }

    public String getIdcardback() {
        return idcardback;
    }

    public void setIdcardback(String idcardback) {
        this.idcardback = idcardback == null ? null : idcardback.trim();
    }

    public String getRetentionTime() {
        return retentionTime;
    }

    public void setRetentionTime(String retentionTime) {
        this.retentionTime = retentionTime == null ? null : retentionTime.trim();
    }

    public String getDefaultLeaveTime() {
        return defaultLeaveTime;
    }

    public void setDefaultLeaveTime(String defaultLeaveTime) {
        this.defaultLeaveTime = defaultLeaveTime == null ? null : defaultLeaveTime.trim();
    }

    public String getHotelPhone() {
        return hotelPhone;
    }

    public void setHotelPhone(String hotelPhone) {
        this.hotelPhone = hotelPhone == null ? null : hotelPhone.trim();
    }

    public String getQtPhone() {
        return qtPhone;
    }

    public void setQtPhone(String qtPhone) {
        this.qtPhone = qtPhone == null ? null : qtPhone.trim();
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
        this.hotelFax = hotelFax == null ? null : hotelFax.trim();
    }

    public String getReadonly() {
        return readonly;
    }

    public void setReadonly(String readonly) {
        this.readonly = readonly == null ? null : readonly.trim();
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
        this.pics = pics == null ? null : pics.trim();
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

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }
}