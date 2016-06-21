package com.duantuke.basic.face;


/**
 * 系统类型，
 * @author tankai
 *
 */
public enum SystemTypeEnum {
	C(1,"c"),
	B(2,"b"),
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
	private SystemTypeEnum(Short id, String name) {
		this.id = id;
		this.name = name;
	}
	private SystemTypeEnum(Integer id, String name) {
		this.id = Short.valueOf(id+"");
		this.name = name;
	}
	
}
