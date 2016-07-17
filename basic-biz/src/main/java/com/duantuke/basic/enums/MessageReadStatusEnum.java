package com.duantuke.basic.enums;

/**
 * 消息状态:F未读；T已读
 * @author tankai
 *
 */
public enum MessageReadStatusEnum {
     unread("F","未读"),
     read("T","已读"),
     
     ;
     private String code;
     private String name;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private MessageReadStatusEnum(String code, String name) {
		this.code = code;
		this.name = name;
	}
     
     
     
}
