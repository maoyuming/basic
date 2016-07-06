package com.duantuke.basic.face.esbean.query;

import java.io.Serializable;

/**
 * @author he
 *  团体sku搜索bean
 */
public class TeamSkuQueryBean implements Serializable{

	private static final long serialVersionUID = 1L;

    private String name;
    private String description;
    
    private Integer page;//当前页
    private Integer pagesize;//每页分页数
    
    private String sortby;//排序字段
    private String sortorder; //默认升序
    private Double range;// 搜索范围，默认5000m
    
    //人数区间
    private Integer queryMinPeopleNum;
    private Integer queryMaxPeopleNum;
    
    
    /** 搜索默认页码 */
    public final static Integer SEARCH_PAGE_DEFAULT = 1;
    
    /** 搜索默认条数 */
    public final static Integer SEARCH_LIMIT_DEFAULT = 10;
    
    /** 搜索默认搜索半径（单位: 米） */
    public final static Integer SEARCH_RANGE_DEFAULT = 5000;
    
    

	public Integer getQueryMinPeopleNum() {
		return queryMinPeopleNum;
	}

	public void setQueryMinPeopleNum(Integer queryMinPeopleNum) {
		this.queryMinPeopleNum = queryMinPeopleNum;
	}

	public Integer getQueryMaxPeopleNum() {
		return queryMaxPeopleNum;
	}

	public void setQueryMaxPeopleNum(Integer queryMaxPeopleNum) {
		this.queryMaxPeopleNum = queryMaxPeopleNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
    
}
