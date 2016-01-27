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
import com.fangbaba.basic.po.RoomModelExample.Criteria;
import com.fangbaba.basic.service.RoomService;

/**
 * @author he 房间相关接口
 */
@Service
public class RoomServiceImpl implements RoomService {

	private static Logger logger = LoggerFactory.getLogger(RoomServiceImpl.class);

	@Autowired
	private RoomModelMapper roomModelMapper;

	@Override
	public List<RoomModel> queryByRoomTypeId(Long roomtypeid) {
		RoomServiceImpl.logger.info(RoomServiceImpl.class.getName() + ":queryByRoomTypeId begin");
		try {
			RoomModelExample example = new RoomModelExample();
			RoomModelExample.Criteria criteria = example.createCriteria();
			criteria.andRoomtypeidEqualTo(roomtypeid);
			return this.roomModelMapper.selectByExample(example);
		} catch (Exception e) {
			RoomServiceImpl.logger.error(RoomServiceImpl.class.getName() + ":queryByRoomTypeId error", e);
			throw e;
		}
	}

	@Override
	public RoomModel queryByPms(String pms) {
		RoomServiceImpl.logger.info(RoomServiceImpl.class.getName() + ":queryByPms begin");
		try {
			RoomModelExample example = new RoomModelExample();
			example.createCriteria().andRoompmsEqualTo(pms);
			List<RoomModel> list = this.roomModelMapper.selectByExample(example);
			if (CollectionUtils.isNotEmpty(list)) {
				return list.get(0);
			} else {
				return null;
			}
		} catch (Exception e) {
			RoomServiceImpl.logger.error(RoomServiceImpl.class.getName() + ":queryByPms error", e);
			throw e;
		}
	}

	@Override
	public RoomModel queryById(Long id) {
		RoomServiceImpl.logger.info(RoomServiceImpl.class.getName() + ":queryById begin");
		try {
			return this.roomModelMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			RoomServiceImpl.logger.error(RoomServiceImpl.class.getName() + ":queryById error", e);
			throw e;
		}
	}

	@Override
	public void syncRoomInfo(Long roomtypeid, List<PmsRoomJsonBean> rooms) {
		RoomServiceImpl.logger.info(RoomServiceImpl.class.getName() + ":syncRoomInfo begin");
		try {
			// 找出房型下所有房间
			List<RoomModel> roomlist = this.queryByRoomTypeId(roomtypeid);
			// 更新的房间pms号
			List<String> updateidlist = new ArrayList<String>();
			for (RoomModel roomModel : roomlist) {
				String roompms = roomModel.getRoompms();
				boolean isexits = false;
				for (PmsRoomJsonBean pmsRoomJsonBean : rooms) {
					if (pmsRoomJsonBean.getId().equals(roompms)) {
						// update
						roomModel.setRoomno(pmsRoomJsonBean.getRoomno());
						this.updateById(roomModel);
						updateidlist.add(pmsRoomJsonBean.getId());
						isexits = true;
						break;
					}
				}
				if (!isexits) {
					// delete
					this.delRoomById(roomModel.getId());
				}
			}
			for (PmsRoomJsonBean pmsRoomJsonBean : rooms) {
				boolean isexits = false;
				for (String pmsno : updateidlist) {
					if (pmsno.equals(pmsRoomJsonBean.getId())) {
						isexits = true;
						break;
					}
				}
				if (!isexits) {
					// add
					RoomModel roomModel = new RoomModel();
					roomModel.setRoompms(pmsRoomJsonBean.getId());
					roomModel.setRoomno(pmsRoomJsonBean.getRoomno());
					roomModel.setRoomtypeid(roomtypeid);
					this.addRoom(roomModel);
				}
			}
		} catch (Exception e) {
			RoomServiceImpl.logger.error(RoomServiceImpl.class.getName() + ":syncRoomInfo error", e);
			throw e;
		}
	}

	private void updateById(RoomModel roomModel) {
		this.roomModelMapper.updateByPrimaryKeySelective(roomModel);
	}

	private void addRoom(RoomModel roomModel) {
		this.roomModelMapper.insertSelective(roomModel);
	}

	private void delRoomById(Long roomid) {
		this.roomModelMapper.deleteByPrimaryKey(roomid);
	}

	@Override
	public void delRoomByRoomtypeid(Long roomtypeid) {
		RoomServiceImpl.logger.info(RoomServiceImpl.class.getName() + ":delRoomByRoomtypeid begin");
		try {
			RoomModelExample example = new RoomModelExample();
			example.createCriteria().andRoomtypeidEqualTo(roomtypeid);
			this.roomModelMapper.deleteByExample(example);
		} catch (Exception e) {
			RoomServiceImpl.logger.error(RoomServiceImpl.class.getName() + ":delRoomByRoomtypeid error", e);
			throw e;
		}
	}

	@Override
	public RoomModel getRoomByRoomTypeidAndRoomNo(Long roomtypeid, String roomno) {
		RoomModelExample example = new RoomModelExample();
		Criteria criteria = example.createCriteria();
		criteria.andRoomtypeidEqualTo(roomtypeid);
		criteria.andRoomnoEqualTo(roomno);
		List<RoomModel> list = this.roomModelMapper.selectByExample(example);
		if (CollectionUtils.isNotEmpty(list)) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public boolean syncRoomForHMS(List<RoomModel> roomModels) {
		if (CollectionUtils.isNotEmpty(roomModels)) {
			for (RoomModel roomModel : roomModels) {
				RoomModel roomModel2 = this.queryById(roomModel.getId());
				if (null != roomModel2) {
					this.delRoomById(roomModel.getId());
					this.addRoom(roomModel);
				} else {
					RoomServiceImpl.logger.info("can't find room with id:{}", roomModel.getId());
				}
			}
			return true;
		} else {
			RoomServiceImpl.logger.info("syncRoomForHMS received nothing.");
		}
		return false;
	}
}
