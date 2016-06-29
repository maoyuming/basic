package com.duantuke.basic.face.bean;

import java.io.Serializable;
import java.util.List;

import com.duantuke.basic.po.Hotel;

public class HotelInfo extends Hotel implements Serializable{

	private static final long serialVersionUID = 1L;

	private List<RoomTypeInfo> roomTypes;
	private List<MealInfo> meals;
	private List<TeamSkuInfo> teamSkus;

	public List<RoomTypeInfo> getRoomTypes() {
		return roomTypes;
	}

	public void setRoomTypes(List<RoomTypeInfo> roomTypes) {
		this.roomTypes = roomTypes;
	}

	public List<MealInfo> getMeals() {
		return meals;
	}

	public void setMeals(List<MealInfo> meals) {
		this.meals = meals;
	}

	public List<TeamSkuInfo> getTeamSkus() {
		return teamSkus;
	}

	public void setTeamSkus(List<TeamSkuInfo> teamSkus) {
		this.teamSkus = teamSkus;
	}
	
	
}
