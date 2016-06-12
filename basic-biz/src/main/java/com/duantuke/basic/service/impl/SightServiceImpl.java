package com.duantuke.basic.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duantuke.basic.esbean.input.SightInputBean;
import com.duantuke.basic.mappers.SightMapper;
import com.duantuke.basic.po.Sight;
import com.duantuke.basic.service.ISightService;

/**
 * @author he
 * 景点相关接口
 */
@Service
public class SightServiceImpl implements ISightService {
	
	private static Logger logger = LoggerFactory.getLogger(SightServiceImpl.class);
	
	@Autowired
	private SightMapper sightMapper;

	@Override
	public int addSight(Sight sight) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateSight(Sight sight) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delSightById(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Sight> querySights(Sight sight) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SightInputBean> queryEsInputSights(Long sightId) {
		return sightMapper.queryEsInputSights(sightId);
	}
}
