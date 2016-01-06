package com.fangbaba.basic.face.enums;


/**
 * Ota平台发布状态
 * @author tankai
 *
 */
public enum OtaDeployStatusEnum {
     un(1,"未发布"),
     ing(2,"未发布中"),
     success(3,"发布成功"),
     fail(4,"发布失败"),
     refuse(5,"审核拒绝"),
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
	private OtaDeployStatusEnum(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
     
     
}
