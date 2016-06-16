package com.duantuke.basic.enums;

/**
 * 消息状态:1未读；2已读
 * @author tankai
 *
 */
public enum MessageReadStatusEnum {
     unread(1,"未读"),
     read(2,"已读"),
     
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
	private MessageReadStatusEnum(Integer code, String name) {
		this.code = code;
		this.name = name;
	}
     
     
     
}
