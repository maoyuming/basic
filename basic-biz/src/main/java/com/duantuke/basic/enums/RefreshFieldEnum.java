package com.duantuke.basic.enums;

/**
 * 刷新es指定属性
 * @author jianghe
 *
 */
public enum RefreshFieldEnum {
     price(0,"价格"),
     tag(1,"标签"),
     meal(2,"餐饮"),
     teamsku(3,"团体"),
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
	private RefreshFieldEnum(Integer code, String name) {
		this.code = code;
		this.name = name;
	}
	public static RefreshFieldEnum findByCode(Integer code){
		for (RefreshFieldEnum value : RefreshFieldEnum.values()) {
			if(value.getCode().equals(code)){
				return value;
			}
		}
		return null;
	}
}
