/**
 * 2015年12月29日

 * zhangyajun
 */
package com.fangbaba.basic.face.enums;

/**
 * 库存类型
 */
public enum StockLogStatusEnum {
	
	lock(1, "锁库存"),
	unlock(2, "解锁库存"),;

	private final Integer id;
	private final String name;

	private StockLogStatusEnum(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static StockLogStatusEnum getByID(Integer id) {
		for (StockLogStatusEnum temp : StockLogStatusEnum.values()) {
			if (temp.getId().equals(id)) {
				return temp;
			}
		}
		throw MyErrorEnum.errorParm.getMyException("枚举ID错误");
	}
}