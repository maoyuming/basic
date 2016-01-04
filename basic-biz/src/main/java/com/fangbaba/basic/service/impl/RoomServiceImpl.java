package com.fangbaba.basic.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fangbaba.basic.face.bean.RoomModel;
import com.fangbaba.basic.face.bean.jsonbean.PmsRoomJsonBean;
import com.fangbaba.basic.mappers.RoomModelMapper;
import com.fangbaba.basic.po.RoomModelExample;
import com.fangbaba.basic.service.RoomService;

/**
 * @author he
 * 房间相关接口
 */
@Service
public class RoomServiceImpl implements RoomService {
	
	private static Logger logger = LoggerFactory.getLogger(RoomServiceImpl.class);
	
	@Autowired
	private RoomModelMapper roomModelMapper;

	@Override
	public List<RoomModel> queryByRoomTypeId(Long roomtypeid) {
		logger.info(RoomServiceImpl.class.getName()+":queryByRoomTypeId begin");
		try {
			RoomModelExample example = new RoomModelExample();
			RoomModelExample.Criteria criteria = example.createCriteria();
			criteria.andRoomtypeidEqualTo(roomtypeid);
			return roomModelMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error(RoomServiceImpl.class.getName()+":queryByRoomTypeId error",e);
			throw e;
		}
	}

	@Override
	public RoomModel queryByPms(String pms) {
		logger.info(RoomServiceImpl.class.getName()+":queryByPms begin");
		try {
			RoomModelExample example = new RoomModelExample();
			example.createCriteria().andRoompmsEqualTo(pms);
			List<RoomModel> list = roomModelMapper.selectByExample(example);
			if(CollectionUtils.isNotEmpty(list)){
				return list.get(0);
			}else{
				return null;
			}
		} catch (Exception e) {
			logger.error(RoomServiceImpl.class.getName()+":queryByPms error",e);
			throw e;
		}
	}
	@Override
	public RoomModel queryById(Long id) {
		logger.info(RoomServiceImpl.class.getName()+":queryById begin");
		try {
			return roomModelMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			logger.error(RoomServiceImpl.class.getName()+":queryById error",e);
			throw e;
		}
	}

	@Override
	public void syncRoomInfo(Long roomtypeid,List<PmsRoomJsonBean> rooms) {
		logger.info(RoomServiceImpl.class.getName()+":syncRoomInfo begin");
		try {
			//找出房型下所有房间
			List<RoomModel> roomlist = queryByRoomTypeId(roomtypeid);
			//更新的房间pms号
		    List<String> updateidlist = new ArrayList<String>();
		    for (RoomModel roomModel:roomlist) {
				String roompms = roomModel.getRoompms();
				boolean isexits = false;
				for (PmsRoomJsonBean pmsRoomJsonBean:rooms) {
					if(pmsRoomJsonBean.getId().equals(roompms)){
						//update
						roomModel.setRoomno(pmsRoomJsonBean.getRoomno());
						updateById(roomModel);
						updateidlist.add(pmsRoomJsonBean.getId());
						isexits = true;
						break;
					}
				}
				if(!isexits){
					//delete
					delRoomById(roomModel.getId());
				}
			}
		    for (PmsRoomJsonBean pmsRoomJsonBean:rooms) {
				boolean isexits = false;
				for (String pmsno:updateidlist) {
					if(pmsno.equals(pmsRoomJsonBean.getId())){
						isexits = true;
						break;
					}
				}
				if(!isexits){
					//add
					RoomModel roomModel = new RoomModel();
					roomModel.setRoompms(pmsRoomJsonBean.getId());
					roomModel.setRoomno(pmsRoomJsonBean.getRoomno());
					roomModel.setRoomtypeid(roomtypeid);
					addRoom(roomModel);
				}
			}
		} catch (Exception e) {
			logger.error(RoomServiceImpl.class.getName()+":syncRoomInfo error",e);
			throw e;
		}
	}
	private void updateById(RoomModel roomModel){
		roomModelMapper.updateByPrimaryKeySelective(roomModel);
	}
	private void addRoom(RoomModel roomModel){
		roomModelMapper.insertSelective(roomModel);
	}
	private void delRoomById(Long roomid){
		roomModelMapper.deleteByPrimaryKey(roomid);
	}

	@Override
	public void delRoomByRoomtypeid(Long roomtypeid) {
		logger.info(RoomServiceImpl.class.getName()+":delRoomByRoomtypeid begin");
		try {
			RoomModelExample example = new RoomModelExample();
			example.createCriteria().andRoomtypeidEqualTo(roomtypeid);
			roomModelMapper.deleteByExample(example);
		} catch (Exception e) {
			logger.error(RoomServiceImpl.class.getName()+":delRoomByRoomtypeid error",e);
			throw e;
		}
	}

}
