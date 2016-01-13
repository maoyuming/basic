package com.fangbaba.basic.face.service;

import java.util.List;

import com.fangbaba.basic.face.bean.OtaRoomtype;
import com.fangbaba.basic.face.enums.OtaDeployStatusEnum;

public interface OtaRoomtypeService {
	public Integer initOtaRoomtype(Long hotelid,Integer salenum);
	public List<OtaRoomtype> queryOtaRoomtypeByDeploy(OtaDeployStatusEnum deployStatusEnum);
	public Integer 	updateOtaRoomtype(OtaRoomtype otaRoomtype);
	
	/**
	 * 更新特定ota的酒店房型下的房间数量
	 * @param hotelid
	 * @param roomtypeid
	 * @param otatype
	 * @param roomno
	 * @return
	 */
	public Integer updateOtaRoomNo(Long hotelid,Long roomtypeid,Integer otatype,Integer roomno);
	
	/**
	 * 根据条件返回otaRoomType信息
	 * @param hotelid
	 * @param roomtypeid
	 * @param otatype
	 * @return
	 */
	public OtaRoomtype getOtaRoomtypeByOtaRoomtype(Long hotelid, Long roomtypeid,Integer otatype);
}
