package com.duantuke.basic.enums;

public enum BusinessTypeEnum {

    hotel(1,"住宿"),
    meal(2,"餐饮"),
    sight(3,"景点"),
    journey(4,"游记"),
    
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
	private BusinessTypeEnum(Integer code, String name) {
		this.code = code;
		this.name = name;
	}
	
	
	public static BusinessTypeEnum getBusinessTypeEnumByCode(Short code){
		if(code==null){
			return null;
		}
		for (BusinessTypeEnum skuTypeEnum : BusinessTypeEnum.values()) {
			if(Integer.valueOf(skuTypeEnum.getCode()).equals(code)){
				return skuTypeEnum;
			}
		}
		return null;
	}
    
    
    

}
