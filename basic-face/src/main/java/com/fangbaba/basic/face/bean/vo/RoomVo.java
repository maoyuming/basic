package com.fangbaba.basic.face.bean.vo;

import java.io.Serializable;

/**
 * 房间信息返回前端
 */
public class RoomVo implements Serializable{
	private static final long serialVersionUID = -2104359978731667641L;

	private Long id;

    private Long roomtypeid;

    private String roomno;

    private String roompms;

    private String tel;

    private String remark;
    
    private boolean islock;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRoomtypeid() {
		return roomtypeid;
	}

	public void setRoomtypeid(Long roomtypeid) {
		this.roomtypeid = roomtypeid;
	}

	public String getRoomno() {
		return roomno;
	}

	public void setRoomno(String roomno) {
		this.roomno = roomno;
	}

	public String getRoompms() {
		return roompms;
	}

	public void setRoompms(String roompms) {
		this.roompms = roompms;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public boolean isIslock() {
		return islock;
	}

	public void setIslock(boolean islock) {
		this.islock = islock;
	}
	
	
	
}
