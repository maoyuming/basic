package com.duantuke.basic.face;


/**
 * 用户token类型，
 * @author tankai
 *
 */
public enum UserTokenTypeEnum {
	C(1,"c端用户"),
	B(2,"b端用户"),
	;
	private Short id;
	private String name;
	public Short getId() {
		return id;
	}
	public void setId(Short id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private UserTokenTypeEnum(Short id, String name) {
		this.id = id;
		this.name = name;
	}
	private UserTokenTypeEnum(Integer id, String name) {
		this.id = Short.valueOf(id+"");
		this.name = name;
	}
	
}
