package com.fangbaba.basic.face.enums;

/**
 * 渠道类型
 * @author he
 */
public enum ChannelidEnum {
	ota(101, "ota渠道"), 
	trip(102, "旅行社");
	
	private final Integer id;
	private final String name;

	private ChannelidEnum(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static ChannelidEnum getByID(Integer id) {
		for (ChannelidEnum temp : ChannelidEnum.values()) {
			if (temp.getId().equals(id)) {
				return temp;
			}
		}
		throw MyErrorEnum.errorParm.getMyException("枚举ID错误");
	}
}