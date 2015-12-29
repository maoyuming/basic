package com.fangbaba.basic.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fangbaba.basic.face.bean.HotelModel;
import com.fangbaba.basic.face.bean.jsonbean.PmsHotelJsonBean;
import com.fangbaba.basic.face.bean.jsonbean.PmsRoomJsonBean;
import com.fangbaba.basic.face.bean.jsonbean.PmsRoomtypeJsonBean;
import com.fangbaba.basic.face.service.HotelService;
import com.fangbaba.basic.face.service.RoomService;
import com.fangbaba.basic.face.service.RoomtypeService;
import com.fangbaba.basic.mappers.HotelModelMapper;
import com.fangbaba.basic.po.HotelModelExample;
import com.google.gson.Gson;

/**
 * @author he
 * 酒店相关接口
 */
@Service
public class HotelServiceImpl implements HotelService {
	
	@Autowired
	private HotelModelMapper hotelModelMapper;
	@Autowired
	private RoomtypeService roomtypeService;
	@Autowired
	private RoomService roomService;
	@Autowired
	private Gson gson;

	@Override
	public List<HotelModel> queryAllHotels() {
		return hotelModelMapper.selectByExampleWithBLOBs(null);
	}

	@Override
	public HotelModel queryById(Long id) {
		return hotelModelMapper.selectByPrimaryKey(id);
	}

	@Override
	public HotelModel queryByPms(String pms) {
		HotelModelExample example = new HotelModelExample();
		example.createCriteria().andHotelpmsEqualTo(pms);
		return hotelModelMapper.selectByExample(example).size()>0?hotelModelMapper.selectByExample(example).get(0):null;
	}
	
	@Override
	public void syncHotelInfo(String json) {
		PmsHotelJsonBean pmsHotelJsonBean = gson.fromJson(json, PmsHotelJsonBean.class);
		List<PmsRoomtypeJsonBean> roomtypes = pmsHotelJsonBean.getRoomtypes();
		HotelModel hotelModel = queryByPms(pmsHotelJsonBean.getHotelid());
		//同步酒店信息
		if(hotelModel!=null){
			//已存在
			hotelModel.setRoomnum(countRoomNum(roomtypes));
			hotelModel.setHotelphone(pmsHotelJsonBean.getPhone());
			hotelModel.setPmstype(pmsHotelJsonBean.getPmstypeid());
			updateById(hotelModel);
		}else{
			//不存在
			hotelModel = new HotelModel();
			hotelModel.setRoomnum(countRoomNum(roomtypes));
			hotelModel.setHotelphone(pmsHotelJsonBean.getPhone());
			hotelModel.setPmstype(pmsHotelJsonBean.getPmstypeid());
			addHotel(hotelModel);
		}
		//同步房型房间信息
		roomtypeService.syncRoomtypeInfo(hotelModel.getId(),roomtypes);
	}
	private int countRoomNum(List<PmsRoomtypeJsonBean> roomtypes){
		int roomNum = 0;
		for (PmsRoomtypeJsonBean pmsRoomtypeJsonBean: roomtypes){
			roomNum += pmsRoomtypeJsonBean.getRooms().size();
		}
		return roomNum;
	}
	private void updateById(HotelModel hotelModel){
		hotelModelMapper.updateByPrimaryKeySelective(hotelModel);
	}
	private void addHotel(HotelModel hotelModel){
		hotelModelMapper.insertSelective(hotelModel);
	}
	

}
