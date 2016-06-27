package com.duantuke.basic.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duantuke.basic.face.service.PersonalTailorService;
import com.duantuke.basic.mappers.PersonalTailorMapper;
import com.duantuke.basic.po.PersonalTailor;

/**
 * @author yuming.mao
 * 私人订制相关接口
 */
@Service
public class PersonalTailorServiceImpl implements PersonalTailorService {
	
	private static Logger logger = LoggerFactory.getLogger(PersonalTailorServiceImpl.class);
	@Autowired
	private PersonalTailorMapper personalTailorMapper;
	
	@Override
	public int addPersonalTailor(PersonalTailor personalTailor) {
		return personalTailorMapper.insert(personalTailor);
	}
	@Override
	public int updatePersonalTailor(PersonalTailor personalTailor) {
		return personalTailorMapper.updateByPrimaryKey(personalTailor);
	}
	@Override
	public int delPersonalTailorById(Long id) {
		return personalTailorMapper.deleteByPrimaryKey(id);
	}

	@Override
	public PersonalTailor queryPersonalTailorById(Long id) {
		return personalTailorMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public List<PersonalTailor> queryPersonalTailors(PersonalTailor personalTailor) {
		// TODO Auto-generated method stub
		return null;
	}
	

	

}
