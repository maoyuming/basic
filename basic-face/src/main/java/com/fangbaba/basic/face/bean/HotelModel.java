package com.fangbaba.basic.face.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class HotelModel implements Serializable{
	private static final long serialVersionUID = -4229485247567019702L;

	private Long id;

    private String hotelname;

    private String hotelcontactname;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date regtime;

    private String detailaddr;

    private BigDecimal longitude;

    private BigDecimal latitude;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date opentime;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date repairtime;

    private Integer roomnum;

    private String businesslicensefront;

    private String businesslicenseback;

    private String hotelpms;

    private String isvisible;

    private String isonline;

    private String idcardfront;

    private String idcardback;

    private String retentiontime;

    private String defaultleavetime;

    private String hotelphone;

    private Integer hoteltype;

    private Integer discode;

    private String qtphone;

    private Integer citycode;

    private Integer provcode;

    private String pmstype;

    private String introduction;
    
    private String provincename;//省名称
    private String cityname;//市
    private String districtname;//县
    private Double range=5000d;//搜索范围，默认5000m
    
    public Double getRange() {
		return range;
	}

	public void setRange(Double range) {
		this.range = range;
	}

	public String getProvincename() {
		return provincename;
	}

	public void setProvincename(String provincename) {
		this.provincename = provincename;
	}

	public String getCityname() {
		return cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	public String getDistrictname() {
		return districtname;
	}

	public void setDistrictname(String districtname) {
		this.districtname = districtname;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHotelname() {
        return hotelname;
    }

    public void setHotelname(String hotelname) {
        this.hotelname = hotelname == null ? null : hotelname.trim();
    }

    public String getHotelcontactname() {
        return hotelcontactname;
    }

    public void setHotelcontactname(String hotelcontactname) {
        this.hotelcontactname = hotelcontactname == null ? null : hotelcontactname.trim();
    }

    public Date getRegtime() {
        return regtime;
    }

    public void setRegtime(Date regtime) {
        this.regtime = regtime;
    }

    public String getDetailaddr() {
        return detailaddr;
    }

    public void setDetailaddr(String detailaddr) {
        this.detailaddr = detailaddr == null ? null : detailaddr.trim();
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

    public Date getOpentime() {
        return opentime;
    }

    public void setOpentime(Date opentime) {
        this.opentime = opentime;
    }

    public Date getRepairtime() {
        return repairtime;
    }

    public void setRepairtime(Date repairtime) {
        this.repairtime = repairtime;
    }

    public Integer getRoomnum() {
        return roomnum;
    }

    public void setRoomnum(Integer roomnum) {
        this.roomnum = roomnum;
    }

    public String getBusinesslicensefront() {
        return businesslicensefront;
    }

    public void setBusinesslicensefront(String businesslicensefront) {
        this.businesslicensefront = businesslicensefront == null ? null : businesslicensefront.trim();
    }

    public String getBusinesslicenseback() {
        return businesslicenseback;
    }

    public void setBusinesslicenseback(String businesslicenseback) {
        this.businesslicenseback = businesslicenseback == null ? null : businesslicenseback.trim();
    }

    public String getHotelpms() {
        return hotelpms;
    }

    public void setHotelpms(String hotelpms) {
        this.hotelpms = hotelpms == null ? null : hotelpms.trim();
    }

    public String getIsvisible() {
        return isvisible;
    }

    public void setIsvisible(String isvisible) {
        this.isvisible = isvisible == null ? null : isvisible.trim();
    }

    public String getIsonline() {
        return isonline;
    }

    public void setIsonline(String isonline) {
        this.isonline = isonline == null ? null : isonline.trim();
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

    public String getRetentiontime() {
        return retentiontime;
    }

    public void setRetentiontime(String retentiontime) {
        this.retentiontime = retentiontime == null ? null : retentiontime.trim();
    }

    public String getDefaultleavetime() {
        return defaultleavetime;
    }

    public void setDefaultleavetime(String defaultleavetime) {
        this.defaultleavetime = defaultleavetime == null ? null : defaultleavetime.trim();
    }

    public String getHotelphone() {
        return hotelphone;
    }

    public void setHotelphone(String hotelphone) {
        this.hotelphone = hotelphone == null ? null : hotelphone.trim();
    }

    public Integer getHoteltype() {
        return hoteltype;
    }

    public void setHoteltype(Integer hoteltype) {
        this.hoteltype = hoteltype;
    }

    public Integer getDiscode() {
        return discode;
    }

    public void setDiscode(Integer discode) {
        this.discode = discode;
    }

    public String getQtphone() {
        return qtphone;
    }

    public void setQtphone(String qtphone) {
        this.qtphone = qtphone == null ? null : qtphone.trim();
    }

    public Integer getCitycode() {
        return citycode;
    }

    public void setCitycode(Integer citycode) {
        this.citycode = citycode;
    }

    public Integer getProvcode() {
        return provcode;
    }

    public void setProvcode(Integer provcode) {
        this.provcode = provcode;
    }

    public String getPmstype() {
        return pmstype;
    }

    public void setPmstype(String pmstype) {
        this.pmstype = pmstype == null ? null : pmstype.trim();
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }
}