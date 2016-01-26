package com.fangbaba.basic.face.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class HotelModel implements Serializable {
	private static final long serialVersionUID = -4229485247567019702L;

	private Long id;

	private String hotelname;

	private String hotelcontactname;

	private Date regtime;

	private String detailaddr;

	private BigDecimal longitude;

	private BigDecimal latitude;

	private Date opentime;

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

	private String provincename;// 省名称
	private String cityname;// 市
	private String districtname;// 县
	private Double range = 5000d;// 搜索范围，默认5000m
	private BigDecimal minprice;
	private BigDecimal maxprice;
	private String hotelpic;

	public String getHotelpic() {
		return this.hotelpic;
	}

	public void setHotelpic(String hotelpic) {
		this.hotelpic = hotelpic;
	}

	public BigDecimal getMinprice() {
		return this.minprice;
	}

	public void setMinprice(BigDecimal minprice) {
		this.minprice = minprice;
	}

	public BigDecimal getMaxprice() {
		return this.maxprice;
	}

	public void setMaxprice(BigDecimal maxprice) {
		this.maxprice = maxprice;
	}

	public Double getRange() {
		return this.range;
	}

	public void setRange(Double range) {
		this.range = range;
	}

	public String getProvincename() {
		return this.provincename;
	}

	public void setProvincename(String provincename) {
		this.provincename = provincename;
	}

	public String getCityname() {
		return this.cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	public String getDistrictname() {
		return this.districtname;
	}

	public void setDistrictname(String districtname) {
		this.districtname = districtname;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHotelname() {
		return this.hotelname;
	}

	public void setHotelname(String hotelname) {
		this.hotelname = hotelname == null ? null : hotelname.trim();
	}

	public String getHotelcontactname() {
		return this.hotelcontactname;
	}

	public void setHotelcontactname(String hotelcontactname) {
		this.hotelcontactname = hotelcontactname == null ? null : hotelcontactname.trim();
	}

	public Date getRegtime() {
		return this.regtime;
	}

	public void setRegtime(Date regtime) {
		this.regtime = regtime;
	}

	public String getDetailaddr() {
		return this.detailaddr;
	}

	public void setDetailaddr(String detailaddr) {
		this.detailaddr = detailaddr == null ? null : detailaddr.trim();
	}

	public BigDecimal getLongitude() {
		return this.longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	public BigDecimal getLatitude() {
		return this.latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public Date getOpentime() {
		return this.opentime;
	}

	public void setOpentime(Date opentime) {
		this.opentime = opentime;
	}

	public Date getRepairtime() {
		return this.repairtime;
	}

	public void setRepairtime(Date repairtime) {
		this.repairtime = repairtime;
	}

	public Integer getRoomnum() {
		return this.roomnum;
	}

	public void setRoomnum(Integer roomnum) {
		this.roomnum = roomnum;
	}

	public String getBusinesslicensefront() {
		return this.businesslicensefront;
	}

	public void setBusinesslicensefront(String businesslicensefront) {
		this.businesslicensefront = businesslicensefront == null ? null : businesslicensefront.trim();
	}

	public String getBusinesslicenseback() {
		return this.businesslicenseback;
	}

	public void setBusinesslicenseback(String businesslicenseback) {
		this.businesslicenseback = businesslicenseback == null ? null : businesslicenseback.trim();
	}

	public String getHotelpms() {
		return this.hotelpms;
	}

	public void setHotelpms(String hotelpms) {
		this.hotelpms = hotelpms == null ? null : hotelpms.trim();
	}

	public String getIsvisible() {
		return this.isvisible;
	}

	public void setIsvisible(String isvisible) {
		this.isvisible = isvisible == null ? null : isvisible.trim();
	}

	public String getIsonline() {
		return this.isonline;
	}

	public void setIsonline(String isonline) {
		this.isonline = isonline == null ? null : isonline.trim();
	}

	public String getIdcardfront() {
		return this.idcardfront;
	}

	public void setIdcardfront(String idcardfront) {
		this.idcardfront = idcardfront == null ? null : idcardfront.trim();
	}

	public String getIdcardback() {
		return this.idcardback;
	}

	public void setIdcardback(String idcardback) {
		this.idcardback = idcardback == null ? null : idcardback.trim();
	}

	public String getRetentiontime() {
		return this.retentiontime;
	}

	public void setRetentiontime(String retentiontime) {
		this.retentiontime = retentiontime == null ? null : retentiontime.trim();
	}

	public String getDefaultleavetime() {
		return this.defaultleavetime;
	}

	public void setDefaultleavetime(String defaultleavetime) {
		this.defaultleavetime = defaultleavetime == null ? null : defaultleavetime.trim();
	}

	public String getHotelphone() {
		return this.hotelphone;
	}

	public void setHotelphone(String hotelphone) {
		this.hotelphone = hotelphone == null ? null : hotelphone.trim();
	}

	public Integer getHoteltype() {
		return this.hoteltype;
	}

	public void setHoteltype(Integer hoteltype) {
		this.hoteltype = hoteltype;
	}

	public Integer getDiscode() {
		return this.discode;
	}

	public void setDiscode(Integer discode) {
		this.discode = discode;
	}

	public String getQtphone() {
		return this.qtphone;
	}

	public void setQtphone(String qtphone) {
		this.qtphone = qtphone == null ? null : qtphone.trim();
	}

	public Integer getCitycode() {
		return this.citycode;
	}

	public void setCitycode(Integer citycode) {
		this.citycode = citycode;
	}

	public Integer getProvcode() {
		return this.provcode;
	}

	public void setProvcode(Integer provcode) {
		this.provcode = provcode;
	}

	public String getPmstype() {
		return this.pmstype;
	}

	public void setPmstype(String pmstype) {
		this.pmstype = pmstype == null ? null : pmstype.trim();
	}

	public String getIntroduction() {
		return this.introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction == null ? null : introduction.trim();
	}
}