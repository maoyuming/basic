package com.fangbaba.basic.face.bean.jsonbean;

import java.io.Serializable;

public class PmsRoomJsonBean implements Serializable {

	private static final long serialVersionUID = 7221660482749686271L;
	
	private String id;  //房间pmsid
	private String roomno;  //房间号
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRoomno() {
		return roomno;
	}
	public void setRoomno(String roomno) {
		this.roomno = roomno;
	}
	
	
}
