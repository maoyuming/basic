package com.duantuke.basic.face.esbean.query;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author he
 * 景点搜索bean
 */
public class SightQueryBean implements Serializable{

	private static final long serialVersionUID = 1L;

    private String sightName;

    private BigDecimal longitude;

    private BigDecimal latitude;

    private String phone;

    private String traffic;

    private String memo;

    private Integer provcode;

    private Integer citycode;

    private Integer discode;
    
    private Integer page=1;//当前页 默认为1
    private Integer pagesize=10;//每页分页数 默认为10
    
    private String sortby;//排序字段
    private String sortorder = "ASC"; //默认升序
    private Double range = 5000d;// 搜索范围，默认5000m
    
    

	public Double getRange() {
		return range;
	}

	public void setRange(Double range) {
		this.range = range;
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

	public String getSightName() {
		return sightName;
	}

	public void setSightName(String sightName) {
		this.sightName = sightName;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTraffic() {
		return traffic;
	}

	public void setTraffic(String traffic) {
		this.traffic = traffic;
	}


	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
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

    

}
