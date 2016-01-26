package com.fangbaba.basic.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fangbaba.basic.face.bean.HotelModel;
import com.fangbaba.basic.face.bean.RoomModel;
import com.fangbaba.basic.face.bean.RoomtypeModel;
import com.fangbaba.basic.face.bean.jsonbean.PmsHotelJsonBean;
import com.fangbaba.basic.face.bean.jsonbean.PmsRoomtypeJsonBean;
import com.fangbaba.basic.face.bean.vo.HotelVo;
import com.fangbaba.basic.face.bean.vo.RoomVo;
import com.fangbaba.basic.face.bean.vo.RoomtypeVo;
import com.fangbaba.basic.face.service.RoomService;
import com.fangbaba.basic.mappers.HotelModelMapper;
import com.fangbaba.basic.po.HotelModelExample;
import com.fangbaba.basic.service.HotelService;
import com.fangbaba.basic.service.RoomtypeService;
import com.google.gson.Gson;

/**
 * @author he 酒店相关接口
 */
@Service
public class HotelServiceImpl implements HotelService {

	private static Logger logger = LoggerFactory.getLogger(HotelServiceImpl.class);
	@Autowired
	private HotelModelMapper hotelModelMapper;
	@Autowired
	private RoomtypeService roomtypeService;
	@Autowired
	private RoomService roomService;
	private Gson gson = new Gson();

	@Override
	public List<HotelModel> queryAllHotels() {
		HotelServiceImpl.logger.info(HotelServiceImpl.class.getName() + ":queryAllHotels begin");
		try {
			// return hotelModelMapper.selectByExampleWithBLOBs(null);
			return this.hotelModelMapper.selectAll(null);
		} catch (Exception e) {
			HotelServiceImpl.logger.error(HotelServiceImpl.class.getName() + ":queryAllHotels error", e);
			throw e;
		}
	}

	@Override
	public HotelModel queryById(Long id) {
		HotelServiceImpl.logger.info(HotelServiceImpl.class.getName() + ":queryById begin");
		try {
			return this.hotelModelMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			HotelServiceImpl.logger.error(HotelServiceImpl.class.getName() + ":queryById error", e);
			throw e;
		}
	}

	@Override
	public HotelModel queryByPms(String pms) {
		HotelServiceImpl.logger.info(HotelServiceImpl.class.getName() + ":queryByPms begin");
		try {
			HotelModelExample example = new HotelModelExample();
			example.createCriteria().andHotelpmsEqualTo(pms);
			List<HotelModel> list = this.hotelModelMapper.selectByExample(example);
			if (CollectionUtils.isNotEmpty(list)) {
				return list.get(0);
			} else {
				return null;
			}
		} catch (Exception e) {
			HotelServiceImpl.logger.error(HotelServiceImpl.class.getName() + ":queryByPms error", e);
			throw e;
		}
	}

	@Override
	public void syncHotelInfo(String json) {
		HotelServiceImpl.logger.info(HotelServiceImpl.class.getName() + ":syncHotelInfo begin");
		try {
			PmsHotelJsonBean pmsHotelJsonBean = this.gson.fromJson(json, PmsHotelJsonBean.class);
			List<PmsRoomtypeJsonBean> roomtypes = pmsHotelJsonBean.getRoomtype();
			HotelModel hotelModel = this.queryByPms(pmsHotelJsonBean.getHotelid());
			// 同步酒店信息
			if (hotelModel != null) {
				// 已存在
				hotelModel.setRoomnum(this.countRoomNum(roomtypes));
				hotelModel.setHotelphone(pmsHotelJsonBean.getPhone());
				hotelModel.setPmstype(pmsHotelJsonBean.getPmstypeid());
				this.updateById(hotelModel);
			} else {
				// 不存在
				hotelModel = new HotelModel();
				hotelModel.setRoomnum(this.countRoomNum(roomtypes));
				hotelModel.setHotelphone(pmsHotelJsonBean.getPhone());
				hotelModel.setPmstype(pmsHotelJsonBean.getPmstypeid());
				hotelModel.setHotelpms(pmsHotelJsonBean.getHotelid());
				this.addHotel(hotelModel);
			}
			// 同步房型房间信息
			this.roomtypeService.syncRoomtypeInfo(hotelModel.getId(), roomtypes);
		} catch (Exception e) {
			HotelServiceImpl.logger.error(HotelServiceImpl.class.getName() + ":syncHotelInfo error", e);
			throw e;
		}
	}

	private int countRoomNum(List<PmsRoomtypeJsonBean> roomtypes) {
		int roomNum = 0;
		for (PmsRoomtypeJsonBean pmsRoomtypeJsonBean : roomtypes) {
			roomNum += pmsRoomtypeJsonBean.getRoom().size();
		}
		return roomNum;
	}

	private void updateById(HotelModel hotelModel) {
		this.hotelModelMapper.updateByPrimaryKeySelective(hotelModel);
	}

	private int addHotel(HotelModel hotelModel) {
		return this.hotelModelMapper.insertSelective(hotelModel);
	}

	/**
	 * 查询酒店详情
	 */
	@Override
	public HotelVo queryDetail(Long id, String begintime, String endtime) {
		HotelServiceImpl.logger.info(HotelServiceImpl.class.getName() + ":queryDetail begin");
		try {
			HotelModel hotelModel = this.queryById(id);
			HotelVo hotelVo = new HotelVo();
			hotelVo.setId(hotelModel.getId());
			hotelVo.setHotelname(hotelModel.getHotelname());
			hotelVo.setHotelcontactname(hotelModel.getHotelcontactname());
			hotelVo.setDetailaddr(hotelModel.getDetailaddr());
			hotelVo.setLongitude(hotelModel.getLongitude());
			hotelVo.setLatitude(hotelModel.getLatitude());
			hotelVo.setRoomnum(hotelModel.getRoomnum());
			hotelVo.setIsvisible(hotelModel.getIsvisible());
			hotelVo.setIsonline(hotelModel.getIsonline());
			hotelVo.setRetentiontime(hotelModel.getRetentiontime());
			hotelVo.setDefaultleavetime(hotelModel.getDefaultleavetime());
			hotelVo.setHotelphone(hotelModel.getHotelphone());
			hotelVo.setHoteltype(hotelModel.getHoteltype());
			hotelVo.setDiscode(hotelModel.getDiscode());
			hotelVo.setQtphone(hotelModel.getQtphone());
			hotelVo.setCitycode(hotelModel.getCitycode());
			hotelVo.setProvcode(hotelModel.getProvcode());
			hotelVo.setIntroduction(hotelModel.getIntroduction());
			hotelVo.setProvincename(hotelModel.getProvincename());
			hotelVo.setCityname(hotelModel.getCityname());
			hotelVo.setDistrictname(hotelModel.getDistrictname());
			List<RoomtypeModel> roomtypemodels = this.roomtypeService.queryByHotelId(id);
			List<RoomtypeVo> roomtypes = new ArrayList<RoomtypeVo>();
			for (RoomtypeModel roomtypeModel : roomtypemodels) {
				RoomtypeVo roomtypeVo = new RoomtypeVo();
				roomtypeVo.setId(roomtypeModel.getId());
				roomtypeVo.setHotelid(roomtypeModel.getHotelid());
				// need 封装价格
				roomtypeVo.setCost(roomtypeModel.getCost());
				roomtypeVo.setName(roomtypeModel.getName());
				// need 可用房间数
				roomtypeVo.setRoomnum(roomtypeModel.getRoomnum());
				roomtypeVo.setRoomtypepms(roomtypeModel.getRoomtypepms());
				List<RoomModel> roommodels = this.roomService.queryByRoomTypeId(roomtypeModel.getId());
				List<RoomVo> rooms = new ArrayList<RoomVo>();
				// TODO:是否返回具体房间
				for (RoomModel roomModel : roommodels) {
					RoomVo roomVo = new RoomVo();
					roomVo.setId(roomModel.getId());
					roomVo.setRemark(roomModel.getRemark());
					roomVo.setRoomno(roomModel.getRoomno());
					roomVo.setRoompms(roomModel.getRoompms());
					roomVo.setRoomtypeid(roomModel.getRoomtypeid());
					roomVo.setTel(roomModel.getTel());
					rooms.add(roomVo);
				}
				roomtypeVo.setRooms(rooms);
				roomtypes.add(roomtypeVo);
			}
			hotelVo.setRoomtypes(roomtypes);
			return hotelVo;
		} catch (Exception e) {
			HotelServiceImpl.logger.error(HotelServiceImpl.class.getName() + ":queryDetail error", e);
			throw e;
		}
	}

	@Override
	public HotelModel getPrice(HotelModel hotelModel) {
		/*
		 * HotelModelExample example = new HotelModelExample();
		 * com.fangbaba.basic.po.HotelModelExample.Criteria criteria =
		 * example.createCriteria(); criteria.andIdEqualTo(hotelModel.getId());
		 * List<HotelModel> list = this.hotelModelMapper.selectAll(example); if
		 * (CollectionUtils.isNotEmpty(list)) { return list.get(0); } else {
		 * return null; }
		 */
		return this.hotelModelMapper.getPrice(hotelModel);
	}

}
