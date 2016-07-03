package com.duantuke.basic.face.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.duantuke.basic.po.Hotel;

public class HotelInfo extends Hotel implements Serializable{

	private static final long serialVersionUID = 1L;

	private List<RoomTypeInfo> roomTypes;
	private List<MealInfo> meals;
	private List<TeamSkuInfo> teamSkus;
	//标签信息
	private List<Map<String,String>> taggroup_1 = new ArrayList<Map<String,String>>();
    private List<Map<String,String>> taggroup_2 = new ArrayList<Map<String,String>>();
    private List<Map<String,String>> taggroup_3 = new ArrayList<Map<String,String>>();
    private List<Map<String,String>> taggroup_4 = new ArrayList<Map<String,String>>();
    

	public List<Map<String, String>> getTaggroup_1() {
		return taggroup_1;
	}

	public void setTaggroup_1(List<Map<String, String>> taggroup_1) {
		this.taggroup_1 = taggroup_1;
	}

	public List<Map<String, String>> getTaggroup_2() {
		return taggroup_2;
	}

	public void setTaggroup_2(List<Map<String, String>> taggroup_2) {
		this.taggroup_2 = taggroup_2;
	}

	public List<Map<String, String>> getTaggroup_3() {
		return taggroup_3;
	}

	public void setTaggroup_3(List<Map<String, String>> taggroup_3) {
		this.taggroup_3 = taggroup_3;
	}

	public List<Map<String, String>> getTaggroup_4() {
		return taggroup_4;
	}

	public void setTaggroup_4(List<Map<String, String>> taggroup_4) {
		this.taggroup_4 = taggroup_4;
	}

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
