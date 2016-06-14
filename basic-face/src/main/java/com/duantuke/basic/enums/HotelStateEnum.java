package com.duantuke.basic.enums;

/**
 * 酒店状态
 * 审核状态：10建店，20待审核，21初审，30审核拒绝，40审核通过
 * @author tankai
 *
 */
public enum HotelStateEnum {
     init(10,"建店"),
     wait(20,"待审核"),
     first(21,"初审"),
     refuse(30,"审核拒绝"),
     pass(40,"审核通过"),
     ;
     private Integer id;
     private String name;
     
     
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private HotelStateEnum(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
     
}
