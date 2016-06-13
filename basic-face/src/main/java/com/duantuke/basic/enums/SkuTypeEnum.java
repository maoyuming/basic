package com.duantuke.basic.enums;

public enum SkuTypeEnum {

    roomtype(1,"房型"),
    meal(2,"餐饮"),
    
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
	private SkuTypeEnum(Integer code, String name) {
		this.code = code;
		this.name = name;
	}
	
	
	public static SkuTypeEnum getSkuTypeEnumByCode(Integer code){
		if(code==null){
			return null;
		}
		for (SkuTypeEnum skuTypeEnum : SkuTypeEnum.values()) {
			if(skuTypeEnum.getCode().equals(code)){
				return skuTypeEnum;
			}
		}
		return null;
	}
    
    
    

}
