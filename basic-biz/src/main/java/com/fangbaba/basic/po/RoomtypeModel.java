package com.fangbaba.basic.po;

import java.math.BigDecimal;

public class RoomtypeModel {
    private Long id;

    private Long hotelid;

    private String name;

    private String roomtypepms;

    private Integer roomnum;

    private BigDecimal cost;

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
        this.name = name == null ? null : name.trim();
    }

    public String getRoomtypepms() {
        return roomtypepms;
    }

    public void setRoomtypepms(String roomtypepms) {
        this.roomtypepms = roomtypepms == null ? null : roomtypepms.trim();
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
}