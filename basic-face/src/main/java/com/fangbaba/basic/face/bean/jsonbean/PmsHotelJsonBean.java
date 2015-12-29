package com.fangbaba.basic.face.bean.jsonbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/*{
    pmstypeid:””//酒店厂商
    hotelid:’’,  //酒店id
    phone: ‘’, //电话
    roomtypes:[{
      id:’’,  //房型id
      name:’’,  //房型名称
      price:’’, //门市价
      rooms:[{
        id:’’,  //房间id
        roomno:’’,  //房间号
      }],//房间
    }],//房型
  }*/

public class PmsHotelJsonBean implements Serializable {
	
	private static final long serialVersionUID = -5040604925248255082L;
	private String pmstypeid;//酒店厂商
	private String hotelid;//酒店pmsid
	private String phone;//电话
	private List<PmsRoomtypeJsonBean> roomtypes = new ArrayList<PmsRoomtypeJsonBean>();//房型列表
	
	public List<PmsRoomtypeJsonBean> getRoomtypes() {
		return roomtypes;
	}
	public void setRoomtypes(List<PmsRoomtypeJsonBean> roomtypes) {
		this.roomtypes = roomtypes;
	}
	public String getPmstypeid() {
		return pmstypeid;
	}
	public void setPmstypeid(String pmstypeid) {
		this.pmstypeid = pmstypeid;
	}
	public String getHotelid() {
		return hotelid;
	}
	public void setHotelid(String hotelid) {
		this.hotelid = hotelid;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
