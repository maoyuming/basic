/**
 * 2015年12月25日下午3:42:47
 * zhaochuanbin
 */
package com.fangbaba.basic.face.enums;

/**
 * 库存类型
 */
public enum StockTypeEnum {
	
	pmsdorder(1, "客单"),
	repair(2, "维修"),;

	private final Integer id;
	private final String name;

	private StockTypeEnum(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static StockTypeEnum getByID(Integer id) {
		for (StockTypeEnum temp : StockTypeEnum.values()) {
			if (temp.getId().equals(id)) {
				return temp;
			}
		}
		throw MyErrorEnum.errorParm.getMyException("枚举ID错误");
	}
}