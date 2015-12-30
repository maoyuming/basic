package com.fangbaba.basic.face.bean.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;


/**
 * 房型信息返回前端
 */
public class RoomtypeVo implements Serializable{
	private static final long serialVersionUID = -912659080739064097L;

	private Long id;

     private Long hotelid;

     private String name;

     private String roomtypepms;

     private Integer roomnum;

     private BigDecimal cost;
     
     private List<RoomVo> rooms;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getHotelid() {
		return hotelid;
	}

	public void setHotelid(Long hotelid) {
		this.hotelid = hotelid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRoomtypepms() {
		return roomtypepms;
	}

	public void setRoomtypepms(String roomtypepms) {
		this.roomtypepms = roomtypepms;
	}

	public Integer getRoomnum() {
		return roomnum;
	}

	public void setRoomnum(Integer roomnum) {
		this.roomnum = roomnum;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public List<RoomVo> getRooms() {
		return rooms;
	}

	public void setRooms(List<RoomVo> rooms) {
		this.rooms = rooms;
	}
}
