package com.duantuke.basic.enums;

public enum UserTypeEnum {

    customer(1,"c端用户"),
    boss(2,"老板"),
    sale(3,"销售"),
    
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
	private UserTypeEnum(Integer code, String name) {
		this.code = code;
		this.name = name;
	}
	
	
	public static UserTypeEnum getSkuTypeEnumByCode(Integer code){
		if(code==null){
			return null;
		}
		for (UserTypeEnum skuTypeEnum : UserTypeEnum.values()) {
			if(skuTypeEnum.getCode().equals(code)){
				return skuTypeEnum;
			}
		}
		return null;
	}
    
    
    

}
