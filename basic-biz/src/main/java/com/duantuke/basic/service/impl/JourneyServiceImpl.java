package com.duantuke.basic.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.duantuke.basic.face.service.JourneyService;
import com.duantuke.basic.po.Journey;

/**
 * @author he
 * 游记相关接口
 */
@Service
public class JourneyServiceImpl implements JourneyService {
	
	private static Logger logger = LoggerFactory.getLogger(JourneyServiceImpl.class);

	@Override
	public int addJourney(Journey journey) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateJourney(Journey journey) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delJourneyById(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Journey> queryJourneys(Journey journey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Journey queryJourneyById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
