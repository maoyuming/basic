package com.fangbaba.basic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fangbaba.basic.face.bean.RoomModel;
import com.fangbaba.basic.face.service.RoomService;
import com.fangbaba.basic.mappers.RoomModelMapper;
import com.fangbaba.basic.po.RoomModelExample;

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

}
