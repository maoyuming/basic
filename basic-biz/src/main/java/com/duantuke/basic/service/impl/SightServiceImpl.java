package com.duantuke.basic.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.duantuke.basic.face.service.SightService;
import com.duantuke.basic.po.Sight;

/**
 * @author he
 * 景点相关接口
 */
@Service
public class SightServiceImpl implements SightService {
	
	private static Logger logger = LoggerFactory.getLogger(SightServiceImpl.class);

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
	

}
