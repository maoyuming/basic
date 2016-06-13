package com.duantuke.basic.face.esbean.query;

import java.io.Serializable;

/**
 * @author he
 * 游记搜索bean
 */
public class JourneyQueryBean implements Serializable{

	private static final long serialVersionUID = 1L;

    private String title;
    private String author;
    private String content;
    
    private Integer page;//当前页
    private Integer pagesize;//每页分页数
    
    private String sortby;//排序字段
    private String sortorder; //默认升序
    private Double range;// 搜索范围，默认5000m
    
    
    /** 搜索默认页码 */
    public final static Integer SEARCH_PAGE_DEFAULT = 1;
    
    /** 搜索默认条数 */
    public final static Integer SEARCH_LIMIT_DEFAULT = 10;
    
    /** 搜索默认搜索半径（单位: 米） */
    public final static Integer SEARCH_RANGE_DEFAULT = 5000;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
