package com.fangbaba.basic.face.service;

import java.util.List;

import com.fangbaba.basic.face.bean.OtaHotel;
import com.fangbaba.basic.face.enums.OtaDeployStatusEnum;

public interface OtaHotelService {
	public List<OtaHotel> queryOtaHotelByDeploy(OtaDeployStatusEnum deployStatusEnum);
	public Integer 	updateOtaHotel(OtaHotel otaHotel);
}
