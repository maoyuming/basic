package com.duantuke.basic.face.bean;

import java.io.Serializable;
import java.util.List;

import com.duantuke.basic.po.Hotel;

public class HotelInfo extends Hotel implements Serializable{

	private static final long serialVersionUID = 1L;

	private List<RoomTypeInfo> roomTypes;

	public List<RoomTypeInfo> getRoomTypes() {
		return roomTypes;
	}

	public void setRoomTypes(List<RoomTypeInfo> roomTypes) {
		this.roomTypes = roomTypes;
	}
}
