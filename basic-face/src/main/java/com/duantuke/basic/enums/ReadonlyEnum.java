package com.duantuke.basic.enums;

/**
 * 标记是否只读，
 * T只读，F可写
 * @author tankai
 *
 */
public enum ReadonlyEnum {
     yes("T","只读"),
     no("F","可写"),
     ;
     private String code;
     private String name;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private ReadonlyEnum(String code, String name) {
		this.code = code;
		this.name = name;
	}
     
}
