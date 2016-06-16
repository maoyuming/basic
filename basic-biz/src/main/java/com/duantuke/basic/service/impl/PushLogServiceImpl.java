package com.duantuke.basic.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duantuke.basic.enums.MessageReadStatusEnum;
import com.duantuke.basic.face.service.PushLogService;
import com.duantuke.basic.mappers.LPushLogMapper;
import com.duantuke.basic.po.LPushLog;
import com.duantuke.basic.po.LPushLogExample;

/**
 * app消息接口
 * @author tankai
 */
@Service
public class PushLogServiceImpl implements PushLogService {
	
	private static Logger logger = LoggerFactory.getLogger(PushLogServiceImpl.class);
	
	@Autowired
	private LPushLogMapper lPushLogMapper;

	@Override
	public List<LPushLog> queryPushLogByMid(Long mid) {

		LPushLogExample example = new LPushLogExample();
		LPushLogExample.Criteria hoCriteria = example.createCriteria();
		hoCriteria.andMidEqualTo(mid);
		example.setOrderByClause("time desc");
		List<LPushLog> models =  lPushLogMapper.selectByExample(example);
		return models;
	
	}

	@Override
	public int updateReadStatus(Long customerId,Long id) {

		LPushLogExample example = new LPushLogExample();
		LPushLogExample.Criteria hoCriteria = example.createCriteria();
		hoCriteria.andMidEqualTo(customerId);
		hoCriteria.andIdEqualTo(id);
		
		LPushLog record = new LPushLog();
		record.setReadstatus(MessageReadStatusEnum.read.getCode()+"");
		return lPushLogMapper.updateByExampleSelective(record,example);
	}


}
