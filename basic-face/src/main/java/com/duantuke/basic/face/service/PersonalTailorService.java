package com.duantuke.basic.face.service;

import java.util.List;

import com.duantuke.basic.po.PersonalTailor;

/**
 * @author yuming.mao
 * 私人订制相关接口
 */
public interface PersonalTailorService {
	public int addPersonalTailor(PersonalTailor personalTailor);
	public int updatePersonalTailor(PersonalTailor personalTailor);
	public int delPersonalTailorById(Long id);
	public List<PersonalTailor> queryPersonalTailors(PersonalTailor personalTailor,Integer pageNo,Integer pageSize);
	public List<PersonalTailor> queryPersonalTailorsBycustomerId(Long customerId);
	public PersonalTailor queryPersonalTailorById(Long id);
}
