package com.fangbaba.basic.face.bean.jsonbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PmsRoomtypeJsonBean implements Serializable {

	private static final long serialVersionUID = -5464208274174886784L;
	private String id;  //房型pmsid
	private String name;  //房型名称
	private String price;  //门市价
	private List<PmsRoomJsonBean> room = new ArrayList<PmsRoomJsonBean>();
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public List<PmsRoomJsonBean> getRoom() {
		return room;
	}
	public void setRoom(List<PmsRoomJsonBean> room) {
		this.room = room;
	}
	
}
