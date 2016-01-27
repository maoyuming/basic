package com.fangbaba.basic.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fangbaba.basic.face.bean.RoomtypeModel;
import com.fangbaba.basic.face.bean.jsonbean.PmsRoomtypeJsonBean;
import com.fangbaba.basic.face.bean.jsonbean.RoomtypeJsonBean;
import com.fangbaba.basic.mappers.RoomtypeModelMapper;
import com.fangbaba.basic.po.RoomtypeModelExample;
import com.fangbaba.basic.service.RoomService;
import com.fangbaba.basic.service.RoomtypeService;

/**
 * @author he 房型相关接口
 */
@Service
public class RoomtypeServiceImpl implements RoomtypeService {

	private static Logger logger = LoggerFactory.getLogger(RoomtypeServiceImpl.class);

	@Autowired
	private RoomtypeModelMapper roomtypeModelMapper;
	@Autowired
	private RoomService roomService;

	@Override
	public BigDecimal queryPriceByRoomTypeId(Long id) {
		RoomtypeServiceImpl.logger.info(RoomtypeServiceImpl.class.getName() + ":queryPriceByRoomTypeId begin");
		try {
			RoomtypeModel bean = this.roomtypeModelMapper.selectByPrimaryKey(id);
			if (bean == null) {
				return null;
			}
			return bean.getCost();
		} catch (Exception e) {
			RoomtypeServiceImpl.logger.error(RoomtypeServiceImpl.class.getName() + ":queryPriceByRoomTypeId error", e);
			throw e;
		}
	}

	@Override
	public RoomtypeModel queryById(Long id) {
		RoomtypeServiceImpl.logger.info(RoomtypeServiceImpl.class.getName() + ":queryById begin");
		try {
			return this.roomtypeModelMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			RoomtypeServiceImpl.logger.error(RoomtypeServiceImpl.class.getName() + ":queryById error", e);
			throw e;
		}
	}

	@Override
	public List<RoomtypeModel> queryByHotelId(Long hotelid) {
		RoomtypeServiceImpl.logger.info(RoomtypeServiceImpl.class.getName() + ":queryByHotelId begin");
		try {
			RoomtypeModelExample example = new RoomtypeModelExample();
			RoomtypeModelExample.Criteria criteria = example.createCriteria();
			criteria.andHotelidEqualTo(hotelid);
			return this.roomtypeModelMapper.selectByExample(example);
		} catch (Exception e) {
			RoomtypeServiceImpl.logger.error(RoomtypeServiceImpl.class.getName() + ":queryByHotelId error", e);
			throw e;
		}
	}

	@Override
	public RoomtypeModel queryByPms(String pms) {
		RoomtypeServiceImpl.logger.info(RoomtypeServiceImpl.class.getName() + ":queryByPms begin");
		try {
			RoomtypeModelExample example = new RoomtypeModelExample();
			example.createCriteria().andRoomtypepmsEqualTo(pms);
			List<RoomtypeModel> list = this.roomtypeModelMapper.selectByExample(example);
			if (CollectionUtils.isNotEmpty(list)) {
				return list.get(0);
			} else {
				return null;
			}
		} catch (Exception e) {
			RoomtypeServiceImpl.logger.error(RoomtypeServiceImpl.class.getName() + ":queryByPms error", e);
			throw e;
		}
	}

	@Override
	public void syncRoomtypeInfo(Long hotelid, List<PmsRoomtypeJsonBean> roomtypes) {
		RoomtypeServiceImpl.logger.info(RoomtypeServiceImpl.class.getName() + ":syncRoomtypeInfo begin");
		try {
			// 找出酒店下所有房型
			List<RoomtypeModel> roomtypelist = this.queryByHotelId(hotelid);
			// 更新的房型pms号
			List<String> updateidlist = new ArrayList<String>();
			for (RoomtypeModel roomtypeModel : roomtypelist) {
				String roomtypepms = roomtypeModel.getRoomtypepms();
				boolean isexits = false;
				for (PmsRoomtypeJsonBean pmsRoomtypeJsonBean : roomtypes) {
					if (pmsRoomtypeJsonBean.getId().equals(roomtypepms)) {
						// update
						roomtypeModel.setCost(new BigDecimal(pmsRoomtypeJsonBean.getPrice()));
						roomtypeModel.setName(pmsRoomtypeJsonBean.getName());
						roomtypeModel.setRoomnum(pmsRoomtypeJsonBean.getRoom().size());
						this.updateById(roomtypeModel);
						this.roomService.syncRoomInfo(roomtypeModel.getId(), pmsRoomtypeJsonBean.getRoom());
						updateidlist.add(pmsRoomtypeJsonBean.getId());
						isexits = true;
						break;
					}
				}
				if (!isexits) {
					// delete
					this.delRoomtypeById(roomtypeModel.getId());
					// delete room
					this.roomService.delRoomByRoomtypeid(roomtypeModel.getId());
				}
			}
			for (PmsRoomtypeJsonBean pmsRoomtypeJsonBean : roomtypes) {
				boolean isexits = false;
				for (String pmsno : updateidlist) {
					if (pmsno.equals(pmsRoomtypeJsonBean.getId())) {
						isexits = true;
						break;
					}
				}
				if (!isexits) {
					// add
					RoomtypeModel roomtypeModel = new RoomtypeModel();
					roomtypeModel.setRoomtypepms(pmsRoomtypeJsonBean.getId());
					roomtypeModel.setCost(new BigDecimal(pmsRoomtypeJsonBean.getPrice()));
					roomtypeModel.setName(pmsRoomtypeJsonBean.getName());
					roomtypeModel.setRoomnum(pmsRoomtypeJsonBean.getRoom().size());
					roomtypeModel.setHotelid(hotelid);
					this.addRoomtype(roomtypeModel);
					this.roomService.syncRoomInfo(roomtypeModel.getId(), pmsRoomtypeJsonBean.getRoom());
				}
			}
		} catch (Exception e) {
			RoomtypeServiceImpl.logger.error(RoomtypeServiceImpl.class.getName() + ":syncRoomtypeInfo error", e);
			throw e;
		}
	}

	private void updateById(RoomtypeModel roomtypeModel) {
		this.roomtypeModelMapper.updateByPrimaryKeySelective(roomtypeModel);
	}

	@Override
	public void addRoomtype(RoomtypeModel roomtypeModel) {
		this.roomtypeModelMapper.insertSelective(roomtypeModel);
	}

	private void delRoomtypeById(Long roomtypeid) {
		this.roomtypeModelMapper.deleteByPrimaryKey(roomtypeid);
	}

	public void setRoomtypeModelMapper(RoomtypeModelMapper roomtypeModelMapper) {
		this.roomtypeModelMapper = roomtypeModelMapper;
	}

	@Override
	public boolean syncRoomtypeForHMS(List<RoomtypeJsonBean> roomtypeModels) {
		if (CollectionUtils.isNotEmpty(roomtypeModels)) {
			for (RoomtypeJsonBean roomtypeJsonBean : roomtypeModels) {
				if (null != roomtypeJsonBean.getRoomtypeModel()) {
					RoomtypeModel roomtypeModel2 = this.queryById(roomtypeJsonBean.getRoomtypeModel().getId());
					if (null != roomtypeModel2) {
						this.delRoomtypeById(roomtypeJsonBean.getRoomtypeModel().getId());
						try {
							throw new Exception();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						this.addRoomtype(roomtypeJsonBean.getRoomtypeModel());
						if (CollectionUtils.isNotEmpty(roomtypeJsonBean.getRoomModels())) {
							this.roomService.syncRoomForHMS(roomtypeJsonBean.getRoomModels());
						} else {
							RoomtypeServiceImpl.logger.info("roomtype id:{} with 0 room.", roomtypeJsonBean.getRoomtypeModel().getId());
						}
					} else {
						RoomtypeServiceImpl.logger.info("cann't find roomtype data with id:{}", roomtypeJsonBean.getRoomtypeModel().getId());
					}
				} else {
					RoomtypeServiceImpl.logger.info("syncRoomtypeForHMS roomtype is null.");
				}
			}
		} else {
			RoomtypeServiceImpl.logger.info("syncRoomtypeForHMS received nothing.");
		}
		return false;
	}

}
