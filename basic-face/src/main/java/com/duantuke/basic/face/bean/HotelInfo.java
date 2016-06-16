package com.duantuke.basic.face.bean;

import java.io.Serializable;
import java.util.List;

import com.duantuke.basic.po.Hotel;
import com.duantuke.basic.po.RoomType;

public class HotelInfo extends Hotel implements Serializable{

	private static final long serialVersionUID = 1L;

	private List<RoomType> roomTypes;

	public List<RoomType> getRoomTypes() {
		return roomTypes;
	}

	public void setRoomTypes(List<RoomType> roomTypes) {
		this.roomTypes = roomTypes;
	}
}
