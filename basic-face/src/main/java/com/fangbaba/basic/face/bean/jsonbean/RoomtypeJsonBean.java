package com.fangbaba.basic.face.bean.jsonbean;

import java.io.Serializable;
import java.util.List;

import com.fangbaba.basic.face.bean.RoomModel;
import com.fangbaba.basic.face.bean.RoomtypeModel;

public class RoomtypeJsonBean implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 346526515616822464L;

	private RoomtypeModel roomtypeModel;

	private List<RoomModel> roomModels;

	public RoomtypeModel getRoomtypeModel() {
		return this.roomtypeModel;
	}

	public void setRoomtypeModel(RoomtypeModel roomtypeModel) {
		this.roomtypeModel = roomtypeModel;
	}

	public List<RoomModel> getRoomModels() {
		return this.roomModels;
	}

	public void setRoomModels(List<RoomModel> roomModels) {
		this.roomModels = roomModels;
	}

}
