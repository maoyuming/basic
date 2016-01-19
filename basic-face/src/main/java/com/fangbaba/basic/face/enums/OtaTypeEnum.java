package com.fangbaba.basic.face.enums;

/**
 * @author he
 * ota_roomtype otatype 枚举
 */
public enum OtaTypeEnum {
	/**
	 * 10000001   眯客
	 */
	imike(10000001, "眯客"), 
	/**
	 * 10000002   阿里旅游
	 */
	alitrip(10000002, "阿里旅游");
	
	private final Integer id;
	private final String name;

	private OtaTypeEnum(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static OtaTypeEnum getByID(Integer id) {
		for (OtaTypeEnum temp : OtaTypeEnum.values()) {
			if (temp.getId().equals(id)) {
				return temp;
			}
		}
		throw MyErrorEnum.errorParm.getMyException("枚举ID错误");
	}
}