package com.fangbaba.basic.po;

import java.io.Serializable;

public class RoomModel implements Serializable{
	private static final long serialVersionUID = -5183985737197386300L;

	private Long id;

    private Long roomtypeid;

    private String roomno;

    private String roompms;

    private String tel;

    private String remark;

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
        this.roomno = roomno == null ? null : roomno.trim();
    }

    public String getRoompms() {
        return roompms;
    }

    public void setRoompms(String roompms) {
        this.roompms = roompms == null ? null : roompms.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}