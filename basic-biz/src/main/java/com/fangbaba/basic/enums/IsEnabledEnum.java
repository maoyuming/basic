package com.fangbaba.basic.enums;


/**
 * @author tankai
 * 
 */
public enum IsEnabledEnum {
	use("T","启用"),
	unuse("F","不启用"),
	;
	
	private final String id;
	private final String name;
	
	private IsEnabledEnum(String id,String name){
		this.id=id;
		this.name=name;
	}
	
	public String getId() {
		return id;
	}




	public String getName() {
		return name;
	}




	public static IsEnabledEnum findByCode(String code){
		for (IsEnabledEnum value : IsEnabledEnum.values()) {
			if(value.id.equalsIgnoreCase(code)){
				return value;
			}
		}
		return null;
	}
}
