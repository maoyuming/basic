package com.fangbaba.basic.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fangbaba.basic.face.bean.OtaRoomtype;
import com.fangbaba.basic.face.bean.RoomModel;
import com.fangbaba.basic.face.enums.OtaDeployStatusEnum;
import com.fangbaba.basic.face.service.RoomService;
import com.fangbaba.basic.face.service.RoomtypeService;
import com.fangbaba.basic.mappers.OtaRoomtypeMapper;
import com.fangbaba.basic.po.OtaRoomtypeExample;
import com.fangbaba.basic.po.OtaRoomtypeExample.Criteria;
import com.fangbaba.basic.service.OtaRoomtypeService;

@Service
public class OtaRoomtypeServiceImpl implements OtaRoomtypeService{

	private static Logger logger = LoggerFactory.getLogger(OtaRoomtypeServiceImpl.class);
	
	@Autowired
	private OtaRoomtypeMapper otaRoomtypeMapper;
	

	@Autowired
	private Mapper dozerMapper;
	
	@Autowired
	private RoomService roomService;
	
	@Autowired
	private RoomtypeService roomtypeService;
	/**
	 * 查询待发布房型
	 * @return
	 */
	public List<OtaRoomtype> queryOtaRoomtypeByDeploy(OtaDeployStatusEnum deployStatusEnum){

		OtaRoomtypeExample example = new OtaRoomtypeExample();

		Criteria criteria = example.createCriteria();
		criteria.andIsdeployEqualTo(1);
		criteria.andOtatypeEqualTo(1);
		

		List<OtaRoomtype> newList = new ArrayList<OtaRoomtype>();
		List<com.fangbaba.basic.po.OtaRoomtype> list = otaRoomtypeMapper.selectByExample(example);
		
		if(CollectionUtils.isNotEmpty(list)){
			for (com.fangbaba.basic.po.OtaRoomtype otaRoomtype : list) {
				OtaRoomtype otaRoomtype2 = dozerMapper.map(otaRoomtype, OtaRoomtype.class);
				newList.add(otaRoomtype2);
			}
		}
		
		return newList;
	}
	
	
	
	
	/**
	 * 更新状态
	 * @return
	 */
	public Integer 	updateOtaRoomtype(OtaRoomtype otaRoomtype){
		
		com.fangbaba.basic.po.OtaRoomtype record =  dozerMapper.map(otaRoomtype, com.fangbaba.basic.po.OtaRoomtype.class);
		record.setOtatype(1);
		OtaRoomtypeExample example = new OtaRoomtypeExample();

		Criteria criteria = example.createCriteria();
		criteria.andOtatypeEqualTo(1);
		criteria.andHotelidEqualTo(otaRoomtype.getHotelid());
		criteria.andRoomtypeidEqualTo(otaRoomtype.getRoomtypeid());
		
		return otaRoomtypeMapper.updateByExampleSelective(record, example);
	}
	
	/**
	 * 查询特定ota对应的宾馆房型下的设定信息
	 * @param hotelid
	 * @param roomtypeid
	 * @param otatype
	 * @return
	 */
	public com.fangbaba.basic.po.OtaRoomtype getOtaRoomtypeByRoomtype(Long hotelid, Long roomtypeid,
			Integer otatype) {
		com.fangbaba.basic.po.OtaRoomtype otaRoomtype=new com.fangbaba.basic.po.OtaRoomtype();
		OtaRoomtypeExample example = new OtaRoomtypeExample();
		Criteria criteria = example.createCriteria();
		criteria.andOtatypeEqualTo(otatype);
		criteria.andHotelidEqualTo(hotelid);
		criteria.andRoomtypeidEqualTo(roomtypeid);
		List<com.fangbaba.basic.po.OtaRoomtype> list=otaRoomtypeMapper.selectByExample(example);
		if (CollectionUtils.isNotEmpty(list)) {
			otaRoomtype=list.get(0);
		}
		return otaRoomtype;
	}

	/* (non-Javadoc)
	 * 更新特定ota的酒店房型下的房间数量
	 * @see com.fangbaba.basic.face.service.OtaRoomtypeService#updateOtaRoomNo(java.lang.Long, java.lang.Long, java.lang.Integer, java.lang.Integer)
	 */
	@SuppressWarnings("null")
	@Override
	public Integer updateOtaRoomNo(Long hotelid, Long roomtypeid,
			Integer otatype, Integer roomno) {
		Integer result=0;
		List<RoomModel> roomModels=roomService.queryByRoomTypeId(roomtypeid);
		com.fangbaba.basic.po.OtaRoomtype otaRoomtype=getOtaRoomtypeByRoomtype(hotelid,roomtypeid,otatype);
		if (CollectionUtils.isNotEmpty(roomModels)) {
			//当前房型下房间数应大于设定数
			if (roomno> roomModels.size()) {
				logger.info("roomno is bigger than all room count.roomno:{},roomcount:{}",roomno,roomModels.size());
			}else {
				//判断当前酒店房型是否发布过
				if (null==otaRoomtype) {
					otaRoomtype.setNum(roomno);
					otaRoomtype.setOtatype(otatype);
					otaRoomtype.setRoomtypeid(roomtypeid);
					otaRoomtype.setHotelid(hotelid);
					otaRoomtype.setIsdeploy(OtaDeployStatusEnum.un.getId());
					otaRoomtype.setCreatetime(new Date());
					result=otaRoomtypeMapper.insertSelective(otaRoomtype);
				}else {
					otaRoomtype.setNum(roomno);
					otaRoomtype.setOtatype(otatype);
					otaRoomtype.setRoomtypeid(roomtypeid);
					otaRoomtype.setHotelid(hotelid);
					otaRoomtype.setUpdatetime(new Date());
					result=otaRoomtypeMapper.updateByPrimaryKey(otaRoomtype);
				}
				
				logger.info("update otaroomtype info success.");
			}
		}else {
			logger.info("roomtypeid:{} doesn't have any room.",roomtypeid);
		}
		return result;
	}
	
}
