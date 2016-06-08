package com.duantuke.basic.face.service;

import java.util.List;

import com.duantuke.basic.po.Sight;

/**
 * @author he
 * 景点相关接口
 */
public interface SightService {
	public int addSight(Sight sight);
	public int updateSight(Sight sight);
	public int delSightById(Long id);
	public List<Sight> querySights(Sight sight);
}
