package com.fangbaba.basic.face.service;

import java.util.List;

import com.fangbaba.basic.face.bean.OtaRoomtype;
import com.fangbaba.basic.face.enums.OtaDeployStatusEnum;

public interface OtaRoomtypeService {
	public List<OtaRoomtype> queryOtaRoomtypeByDeploy(OtaDeployStatusEnum deployStatusEnum);
	public Integer 	updateOtaRoomtype(OtaRoomtype otaRoomtype);
}
