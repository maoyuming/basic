package com.fangbaba.basic.face.bean;

import java.io.Serializable;

public class HotelExtension implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = -1901990507043544916L;

	private Long id;

	private Long hotelid;

	private String hotelpic;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getHotelid() {
		return this.hotelid;
	}

	public void setHotelid(Long hotelid) {
		this.hotelid = hotelid;
	}

	public String getHotelpic() {
		return this.hotelpic;
	}

	public void setHotelpic(String hotelpic) {
		this.hotelpic = hotelpic == null ? null : hotelpic.trim();
	}
}