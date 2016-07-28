package com.duantuke.basic.enums;

/**
 * 标记是否有效，推荐位
 * '0:待审核 1:审核通过 2:审核拒绝 3:发布中 4:已过期'
 * @author tankai
 *
 */
public enum RecommendItemStateEnum {
     wait(0,"待审核"),
     pass(1,"审核通过"),
     nopass(2,"审核不通过"),
     ing(3,"发布中"),
     expire(4,"已过期"),
     
     ;
     private Integer code;
     private String name;
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private RecommendItemStateEnum(Integer code, String name) {
		this.code = code;
		this.name = name;
	}
     
     
     
}
