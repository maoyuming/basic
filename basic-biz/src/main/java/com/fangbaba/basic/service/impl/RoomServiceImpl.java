package com.fangbaba.basic.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
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
	
	@Autowired
	private RoomModelMapper roomModelMapper;

	@Override
	public List<RoomModel> queryByRoomTypeId(Long roomtypeid) {
		RoomModelExample example = new RoomModelExample();
		RoomModelExample.Criteria criteria = example.createCriteria();
		criteria.andRoomtypeidEqualTo(roomtypeid);
		return roomModelMapper.selectByExample(example);
	}

	@Override
	public RoomModel queryByPms(String pms) {
		RoomModelExample example = new RoomModelExample();
		example.createCriteria().andRoompmsEqualTo(pms);
		List<RoomModel> list = roomModelMapper.selectByExample(example);
		if(CollectionUtils.isNotEmpty(list)){
			return list.get(0);
		}else{
			return null;
		}
	}
	@Override
	public RoomModel queryById(Long id) {
		return roomModelMapper.selectByPrimaryKey(id);
	}

	@Override
	public void syncRoomInfo(Long roomtypeid,List<PmsRoomJsonBean> rooms) {
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
		RoomModelExample example = new RoomModelExample();
		example.createCriteria().andRoomtypeidEqualTo(roomtypeid);
		roomModelMapper.deleteByExample(example);
	}

}
