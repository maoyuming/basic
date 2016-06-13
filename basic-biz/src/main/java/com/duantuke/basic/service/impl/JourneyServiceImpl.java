package com.duantuke.basic.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duantuke.basic.esbean.input.JourneyInputBean;
import com.duantuke.basic.mappers.JourneyMapper;
import com.duantuke.basic.mappers.JourneyRHotelMapper;
import com.duantuke.basic.mappers.JourneyRSightMapper;
import com.duantuke.basic.po.Journey;
import com.duantuke.basic.po.JourneyRHotel;
import com.duantuke.basic.po.JourneyRHotelExample;
import com.duantuke.basic.po.JourneyRSight;
import com.duantuke.basic.po.JourneyRSightExample;
import com.duantuke.basic.service.IJourneyService;

/**
 * @author he
 * 游记相关接口
 */
@Service
public class JourneyServiceImpl implements IJourneyService {
	
	private static Logger logger = LoggerFactory.getLogger(JourneyServiceImpl.class);
	@Autowired
	private  JourneyMapper  journeyMapper;
	@Autowired
	private  JourneyRHotelMapper  journeyRHotelMapper;
	@Autowired
	private  JourneyRSightMapper  journeyRSightMapper;
	
	@Override
	public int addJourney(Journey journey) {
		return journeyMapper.insertSelective(journey);
	}

	@Override
	public int updateJourney(Journey journey) {
		return journeyMapper.updateByPrimaryKeySelective(journey);
	}

	@Override
	public int delJourneyById(Long id) {
		return journeyMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<Journey> queryJourneys(Journey journey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Journey queryJourneyById(Long id) {
		return journeyMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<JourneyRHotel> queryHotelIdsByJourneyId(Long journeyId) {
		JourneyRHotelExample example = new JourneyRHotelExample();
		JourneyRHotelExample.Criteria criteria = example.createCriteria();
		criteria.andJourneyIdEqualTo(journeyId);
		return journeyRHotelMapper.selectByExample(example);
	}

	@Override
	public List<JourneyRSight> queryHotelIdsBySightId(Long journeyId) {
		JourneyRSightExample example = new JourneyRSightExample();
		JourneyRSightExample.Criteria criteria = example.createCriteria();
		criteria.andJourneyIdEqualTo(journeyId);
		return journeyRSightMapper.selectByExample(example);
	}

	@Override
	public List<JourneyInputBean> queryEsInputJourneys(Long journeyId) {
		return journeyMapper.queryEsInputJourneys(journeyId);
	}
	
}
