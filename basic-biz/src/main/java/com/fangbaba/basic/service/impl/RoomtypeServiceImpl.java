package com.fangbaba.basic.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fangbaba.basic.face.bean.RoomtypeModel;
import com.fangbaba.basic.face.bean.jsonbean.PmsRoomtypeJsonBean;
import com.fangbaba.basic.mappers.RoomtypeModelMapper;
import com.fangbaba.basic.po.RoomtypeModelExample;
import com.fangbaba.basic.service.RoomService;
import com.fangbaba.basic.service.RoomtypeService;

/**
 * @author he
 * 房型相关接口
 */
@Service
public class RoomtypeServiceImpl implements RoomtypeService {

	@Autowired
	private RoomtypeModelMapper roomtypeModelMapper;
	@Autowired
	private RoomService roomService;
	
	@Override
	public BigDecimal queryPriceByRoomTypeId(Long id) {
		RoomtypeModel bean =  roomtypeModelMapper.selectByPrimaryKey(id);
		if(bean==null){
			return null;
		}
		return bean.getCost();
	}
	@Override
	public RoomtypeModel queryById(Long id) {
		return roomtypeModelMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<RoomtypeModel> queryByHotelId(Long hotelid) {
		RoomtypeModelExample example = new RoomtypeModelExample();
		RoomtypeModelExample.Criteria criteria = example.createCriteria();
		criteria.andHotelidEqualTo(hotelid);
		return roomtypeModelMapper.selectByExample(example);
	}

	@Override
	public RoomtypeModel queryByPms(String pms) {
		RoomtypeModelExample example = new RoomtypeModelExample();
		example.createCriteria().andRoomtypepmsEqualTo(pms);
		List<RoomtypeModel> list = roomtypeModelMapper.selectByExample(example);
		if(CollectionUtils.isNotEmpty(list)){
			return list.get(0);
		}else{
			return null;
		}
	}

	@Override
	public void syncRoomtypeInfo(Long hotelid,List<PmsRoomtypeJsonBean> roomtypes) {
		//找出酒店下所有房型
		List<RoomtypeModel> roomtypelist = queryByHotelId(hotelid);
		//更新的房型pms号
	    List<String> updateidlist = new ArrayList<String>();
	    for (RoomtypeModel roomtypeModel:roomtypelist) {
			String roomtypepms = roomtypeModel.getRoomtypepms();
			boolean isexits = false;
			for (PmsRoomtypeJsonBean pmsRoomtypeJsonBean:roomtypes) {
				if(pmsRoomtypeJsonBean.getId().equals(roomtypepms)){
					//update
					roomtypeModel.setCost(new BigDecimal(pmsRoomtypeJsonBean.getPrice()));
					roomtypeModel.setName(pmsRoomtypeJsonBean.getName());
					roomtypeModel.setRoomnum(pmsRoomtypeJsonBean.getRoom().size());
					updateById(roomtypeModel);
					roomService.syncRoomInfo(roomtypeModel.getId(), pmsRoomtypeJsonBean.getRoom());
					updateidlist.add(pmsRoomtypeJsonBean.getId());
					isexits = true;
					break;
				}
			}
			if(!isexits){
				//delete
				delRoomtypeById(roomtypeModel.getId());
				//delete room
				roomService.delRoomByRoomtypeid(roomtypeModel.getId());
			}
		}
	    for (PmsRoomtypeJsonBean pmsRoomtypeJsonBean:roomtypes) {
			boolean isexits = false;
			for (String pmsno:updateidlist) {
				if(pmsno.equals(pmsRoomtypeJsonBean.getId())){
					isexits = true;
					break;
				}
			}
			if(!isexits){
				//add
				RoomtypeModel roomtypeModel = new RoomtypeModel();
				roomtypeModel.setRoomtypepms(pmsRoomtypeJsonBean.getId());
				roomtypeModel.setCost(new BigDecimal(pmsRoomtypeJsonBean.getPrice()));
				roomtypeModel.setName(pmsRoomtypeJsonBean.getName());
				roomtypeModel.setRoomnum(pmsRoomtypeJsonBean.getRoom().size());
				roomtypeModel.setHotelid(hotelid);
				addRoomtype(roomtypeModel);
				roomService.syncRoomInfo(roomtypeModel.getId(), pmsRoomtypeJsonBean.getRoom());
			}
		}
		
	}
	private void updateById(RoomtypeModel roomtypeModel){
		roomtypeModelMapper.updateByPrimaryKeySelective(roomtypeModel);
	}
	private void addRoomtype(RoomtypeModel roomtypeModel){
		roomtypeModelMapper.insertSelective(roomtypeModel);
	}
	private void delRoomtypeById(Long roomtypeid){
		roomtypeModelMapper.deleteByPrimaryKey(roomtypeid);
	}
	
	
}
