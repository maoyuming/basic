package com.duantuke.basic.face.esbean.query;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author he
 * 农家院搜索bean
 */
public class HotelQueryBean implements Serializable{

	private static final long serialVersionUID = 1L;

    private String hotelName;

    private BigDecimal longitude;

    private BigDecimal latitude;

    private String isvisible;
    
    private String hotelPhone;

    private String qtPhone;

    private Integer provinceCode;

    private Integer cityCode;
    

    private Integer districtCode;
    
    private Integer page;//当前页
    private Integer pagesize;//每页分页数
    
    private String sortby;//排序字段
    private String sortorder; //默认升序
    private Double range;// 搜索范围，默认5000m
    
    private String readonly;
    
    private String businessType;//业务类型 meal:饮食 journey:游记 sight:景点 hotel:农家院
    
    private String tagJson;//tag搜索条件   {"taggroup_2":["商务会议","温泉度假"],"taggroup_1":["旅游景区"]}
    
    /** 搜索默认页码 */
    public final static Integer SEARCH_PAGE_DEFAULT = 1;
    
    /** 搜索默认条数 */
    public final static Integer SEARCH_LIMIT_DEFAULT = 10;
    
    /** 搜索默认搜索半径（单位: 米） */
    public final static Integer SEARCH_RANGE_DEFAULT = 5000;
    
    
    public String getTagJson() {
		return tagJson;
	}
	public void setTagJson(String tagJson) {
		this.tagJson = tagJson;
	}
	public String getBusinessType() {
		return businessType;
	}
	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
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

	public String getIsvisible() {
		return isvisible;
	}

	public void setIsvisible(String isvisible) {
		this.isvisible = isvisible;
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

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPagesize() {
		return pagesize;
	}

	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}

	public String getSortby() {
		return sortby;
	}

	public void setSortby(String sortby) {
		this.sortby = sortby;
	}

	public String getSortorder() {
		return sortorder;
	}

	public void setSortorder(String sortorder) {
		this.sortorder = sortorder;
	}

	public Double getRange() {
		return range;
	}

	public void setRange(Double range) {
		this.range = range;
	}

	public String getReadonly() {
		return readonly;
	}

	public void setReadonly(String readonly) {
		this.readonly = readonly;
	}
	
	
}
