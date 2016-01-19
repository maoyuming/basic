package com.fangbaba.basic.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fangbaba.basic.face.bean.GdsType;
import com.fangbaba.basic.face.bean.OtaRoomtype;
import com.fangbaba.basic.face.bean.RoomModel;
import com.fangbaba.basic.face.bean.RoomtypeModel;
import com.fangbaba.basic.face.enums.OtaDeployStatusEnum;
import com.fangbaba.basic.face.service.GdsTypeService;
//import com.fangbaba.basic.face.enums.OtaTypeEnum;
import com.fangbaba.basic.face.service.RoomService;
import com.fangbaba.basic.face.service.RoomtypeService;
import com.fangbaba.basic.mappers.OtaRoomtypeMapper;
import com.fangbaba.basic.po.OtaRoomtypeExample;
import com.fangbaba.basic.po.OtaRoomtypeExample.Criteria;
import com.fangbaba.basic.service.OtaRoomtypeService;
import com.fangbaba.basic.util.Config;
import com.fangbaba.basic.util.MathUtil;

@Service
public class OtaRoomtypeServiceImpl implements OtaRoomtypeService {

	private static Logger logger = LoggerFactory.getLogger(OtaRoomtypeServiceImpl.class);

	@Autowired
	private OtaRoomtypeMapper otaRoomtypeMapper;

	@Autowired
	private Mapper dozerMapper;

	@Autowired
	private RoomService roomService;
	@Autowired
	private RoomtypeService roomtypeService;
	@Autowired
	private GdsTypeService gdsTypeService;

	/**
	 * 查询待发布房型
	 * 
	 * @return
	 */
	public List<OtaRoomtype> queryOtaRoomtypeByDeploy(OtaDeployStatusEnum deployStatusEnum) {

		OtaRoomtypeExample example = new OtaRoomtypeExample();

		Criteria criteria = example.createCriteria();
		criteria.andIsdeployEqualTo(1);
		criteria.andOtatypeEqualTo(1);

		List<OtaRoomtype> newList = new ArrayList<OtaRoomtype>();
		List<com.fangbaba.basic.po.OtaRoomtype> list = otaRoomtypeMapper.selectByExample(example);

		if (CollectionUtils.isNotEmpty(list)) {
			for (com.fangbaba.basic.po.OtaRoomtype otaRoomtype : list) {
				OtaRoomtype otaRoomtype2 = dozerMapper.map(otaRoomtype, OtaRoomtype.class);
				newList.add(otaRoomtype2);
			}
		}

		return newList;
	}

	/**
	 * 更新状态
	 * 
	 * @return
	 */
	public Integer updateOtaRoomtype(OtaRoomtype otaRoomtype) {

		com.fangbaba.basic.po.OtaRoomtype record = dozerMapper.map(otaRoomtype,
				com.fangbaba.basic.po.OtaRoomtype.class);
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
	 * 
	 * @param hotelid
	 * @param roomtypeid
	 * @param otatype
	 * @return
	 */
	public com.fangbaba.basic.po.OtaRoomtype getOtaRoomtypeByRoomtype(Long hotelid, Long roomtypeid, Integer otatype) {
		com.fangbaba.basic.po.OtaRoomtype otaRoomtype = null;
		OtaRoomtypeExample example = new OtaRoomtypeExample();
		Criteria criteria = example.createCriteria();
		criteria.andOtatypeEqualTo(otatype);
		criteria.andHotelidEqualTo(hotelid);
		criteria.andRoomtypeidEqualTo(roomtypeid);
		List<com.fangbaba.basic.po.OtaRoomtype> list = otaRoomtypeMapper.selectByExample(example);
		if (CollectionUtils.isNotEmpty(list)) {
			otaRoomtype = list.get(0);
		}
		return otaRoomtype;
	}

	/*
	 * (non-Javadoc) 更新特定ota的酒店房型下的房间数量
	 * 
	 * @see
	 * com.fangbaba.basic.face.service.OtaRoomtypeService#updateOtaRoomNo(java.
	 * lang.Long, java.lang.Long, java.lang.Integer, java.lang.Integer)
	 */
	@SuppressWarnings("null")
	@Override
	public Integer updateOtaRoomNo(Long hotelid, Long roomtypeid, Integer otatype, Integer roomno) {
		Integer result = 0;
		List<RoomModel> roomModels = roomService.queryByRoomTypeId(roomtypeid);
		com.fangbaba.basic.po.OtaRoomtype otaRoomtype = getOtaRoomtypeByRoomtype(hotelid, roomtypeid, otatype);
		if (CollectionUtils.isNotEmpty(roomModels)) {
			// 当前房型下房间数应大于设定数
			if (roomno > roomModels.size()) {
				logger.info("roomno is bigger than all room count.roomno:{},roomcount:{}", roomno, roomModels.size());
			} else {
				// 判断当前酒店房型是否发布过
				if (null == otaRoomtype || null == otaRoomtype.getId()) {
					otaRoomtype = new com.fangbaba.basic.po.OtaRoomtype();
					otaRoomtype.setNum(roomno);
					otaRoomtype.setOtatype(otatype);
					otaRoomtype.setRoomtypeid(roomtypeid);
					otaRoomtype.setHotelid(hotelid);
					otaRoomtype.setIsdeploy(OtaDeployStatusEnum.un.getId());
					otaRoomtype.setCreatetime(new Date());
					result = otaRoomtypeMapper.insertSelective(otaRoomtype);
				} else {
					otaRoomtype.setNum(roomno);
					otaRoomtype.setOtatype(otatype);
					otaRoomtype.setRoomtypeid(roomtypeid);
					otaRoomtype.setHotelid(hotelid);
					otaRoomtype.setUpdatetime(new Date());
					result = otaRoomtypeMapper.updateByPrimaryKey(otaRoomtype);
				}

				logger.info("update otaroomtype info success.");
			}
		} else {
			logger.info("roomtypeid:{} doesn't have any room.", roomtypeid);
		}
		return result;
	}

	@Override
	public OtaRoomtype getOtaRoomtypeByOtaRoomtype(Long hotelid, Long roomtypeid, Integer otatype) {
		com.fangbaba.basic.po.OtaRoomtype otaRoomtype = getOtaRoomtypeByRoomtype(hotelid, roomtypeid, otatype);
		if(otaRoomtype!=null){
    		OtaRoomtype oRoomtype = dozerMapper.map(otaRoomtype, OtaRoomtype.class);
    		return oRoomtype;
		}else{
		    return null;
		}
	}
	
	public int saveRecord(com.fangbaba.basic.po.OtaRoomtype otaRoomtype){
		return otaRoomtypeMapper.insertSelective(otaRoomtype);
	}

	/**
	 * 初始化数据
	 */
	@Override
	public Integer initOtaRoomtype(Long hotelid, Integer salenum) {
		try {
			if (hotelid != null && salenum != null) {
				// 删除该酒店下数据
				OtaRoomtypeExample example = new OtaRoomtypeExample();
				Criteria criteria = example.createCriteria();
				criteria.andHotelidEqualTo(hotelid);
				otaRoomtypeMapper.deleteByExample(example);
				
				// 查询各个房型所占比例
				List<RoomtypeModel> roomtypelist = roomtypeService.queryByHotelId(hotelid);
				Map<Long, Integer> roomtypeMap = new HashMap<Long, Integer>();
				Map<Long, Integer> roomtypeconfigMap = new HashMap<Long, Integer>();
				int roomsum = 0;
				for (RoomtypeModel roomtypeModel : roomtypelist) {
					roomsum = roomsum + roomtypeModel.getRoomnum();
					roomtypeMap.put(roomtypeModel.getId(), roomtypeModel.getRoomnum());
				}
				if(salenum>roomsum){
					salenum = roomsum;
				}
				for (Long roomtypeid : roomtypeMap.keySet()) {
					Integer roomnum = roomtypeMap.get(roomtypeid);
					double percent = MathUtil.div(roomnum, roomsum, 2);
					double roomsalenum = MathUtil.mul(percent, salenum);
					int value = (int)Math.round(roomsalenum);
					
					if(value!=0)
						roomtypeconfigMap.put(roomtypeid, value);
				}
				int result = 0;
				//插入ota_roomtype
				for (Long roomtypeid : roomtypeconfigMap.keySet()) {
					Integer roomnum = roomtypeconfigMap.get(roomtypeid);
					
					String[] channels = Config.getValue("hotel.channelid").split(";");
					for (String channelid : channels) {
						List<GdsType> list = gdsTypeService.queryGdsTypeByChannelid(Integer.valueOf(channelid));
						for (GdsType gdsType : list) {

							int otatype = gdsType.getOtatype();
							com.fangbaba.basic.po.OtaRoomtype otaRoomtype = new com.fangbaba.basic.po.OtaRoomtype();
							otaRoomtype.setCreatetime(new Date());
							otaRoomtype.setCreateuser("");
							otaRoomtype.setHotelid(hotelid);
							otaRoomtype.setRoomtypeid(roomtypeid);
							otaRoomtype.setIsdeploy(OtaDeployStatusEnum.un.getId());
							otaRoomtype.setOtatype(otatype);
							otaRoomtype.setNum(roomnum);
							result = result+saveRecord(otaRoomtype);
						
						}
					}
					//查询所有的gdstype
				}
				return result;
			}else{
				return 0;
			}
		}catch (Exception e) {
			logger.error(OtaRoomtypeServiceImpl.class.getName()+":initOtaRoomtype error",e);
			throw e;
		}
	}
}
