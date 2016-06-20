package com.duantuke.basic.enums;


/**
 * 推荐位置信息
 * @author tankai
 *
 */
public enum PositionTypeEnum {

    index_banner(1,"首页轮换图"),
    navigation(2,"导航"),
    tags(3,"标签"),
    activity(4,"活动"),
    
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
	private PositionTypeEnum(Integer code, String name) {
		this.code = code;
		this.name = name;
	}
	
	
	public static PositionTypeEnum getBusinessTypeEnumByCode(Short code){
		if(code==null){
			return null;
		}
		for (PositionTypeEnum skuTypeEnum : PositionTypeEnum.values()) {
			if(Integer.valueOf(skuTypeEnum.getCode()).equals(code)){
				return skuTypeEnum;
			}
		}
		return null;
	}
    
    
    

}
