package com.duantuke.basic.face.bean;

import java.io.Serializable;

public class PageItem implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 3180295093038615233L;
	public final static int DEFAULT_PAGESIZE = 8;
    public final static int MIN_PAGE_COUNT   = 1;
    // 总条数
    private int totalItem;

    // 是否有上一页
    private boolean previousPageAvailable;

    // 上一页
    private int previousPage;

    // 当前页
    private int index =1 ;

    // 总页数
    private int totalPage;

    // 是否有下一页
    private boolean nextPageAvailable;

    // 下一页
    private int nextPage;

    private int begin;

    private int end;

    private String actionUrl;
    private int pageSize = DEFAULT_PAGESIZE;
    
    //排序字段
    private String orderBy;
    //排序方式 desc asc
    private String orderByType;
    /**
     * 数据源
     */
    private Integer sysId;

    public int getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(int totalItem) {
        this.totalItem = totalItem;
        totalPage = (totalItem + pageSize - 1) / pageSize;
        if (index > 1) {
            previousPageAvailable = true;
            previousPage = index - 1;
        } else {
            previousPageAvailable = false;
        }

        if (index < totalPage) {
            nextPageAvailable = true;
            nextPage = index + 1;
        } else {
            nextPageAvailable = false;
        }
        index = index == 0 ? MIN_PAGE_COUNT : index;
        begin = (index - 1) * pageSize;
        end = pageSize;

    }

    public boolean isPreviousPageAvailable() {
        return previousPageAvailable;
    }

    public void setPreviousPageAvailable(boolean previousPageAvailable) {
        this.previousPageAvailable = previousPageAvailable;
    }

    public int getPreviousPage() {
        return previousPage;
    }

    public void setPreviousPage(int previousPage) {
        this.previousPage = previousPage;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public boolean isNextPageAvailable() {
        return nextPageAvailable;
    }

    public void setNextPageAvailable(boolean nextPageAvailable) {
        this.nextPageAvailable = nextPageAvailable;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public int getBegin() {
        return begin;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public String getActionUrl() {
        return actionUrl;
    }

    public void setActionUrl(String actionUrl) {
        this.actionUrl = actionUrl;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    
    
    public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public String getOrderByType() {
		return orderByType;
	}

	public void setOrderByType(String orderByType) {
		this.orderByType = orderByType;
	}

	public static void main(String[] args) {
    	PageItem pageItem = new PageItem();
    	pageItem.setPageSize(9);
    	pageItem.setIndex(5);
    	pageItem.setTotalItem(191);
    	System.out.println(pageItem.getBegin());
    	System.out.println(pageItem.getEnd());
	}

	public Integer getSysId() {
		return sysId;
	}

	public void setSysId(Integer sysId) {
		this.sysId = sysId;
	}

	
	
	
}
