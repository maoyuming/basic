package com.fangbaba.basic.face.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 酒店查询入参
 * @author tankai
 *
 */
public class HotelPriceQueryIn implements Serializable{
	/**
	 * 酒店id
	 */
	private Long hotelid;

	/**
	 * 房型id
	 */
    private Long roomtypeid;

    /**
     * 订单预定入住时间
     */
    private Date begintime;

    /**
     * 订单预定离店时间
     */
    private Date endtime;


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

	public Date getBegintime() {
		return begintime;
	}

	public void setBegintime(Date begintime) {
		this.begintime = begintime;
	}

	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	

}
