package com.fangbaba.basic.face.bean;

import java.io.Serializable;
import java.util.Date;

public class OtaRoomtype implements Serializable{
    private Long id;

    private Long hotelid;

    private Long roomtypeid;

    private Integer isdeploy;

    private Integer otatype;

    private Integer num;

    private Date createtime;

    private String createuser;

    private Date updatetime;

    private String updateuser;

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

    public Long getRoomtypeid() {
        return roomtypeid;
    }

    public void setRoomtypeid(Long roomtypeid) {
        this.roomtypeid = roomtypeid;
    }

    public Integer getIsdeploy() {
        return isdeploy;
    }

    public void setIsdeploy(Integer isdeploy) {
        this.isdeploy = isdeploy;
    }

    public Integer getOtatype() {
        return otatype;
    }

    public void setOtatype(Integer otatype) {
        this.otatype = otatype;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getCreateuser() {
        return createuser;
    }

    public void setCreateuser(String createuser) {
        this.createuser = createuser == null ? null : createuser.trim();
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getUpdateuser() {
        return updateuser;
    }

    public void setUpdateuser(String updateuser) {
        this.updateuser = updateuser == null ? null : updateuser.trim();
    }
}