package com.duantuke.basic.face.service;

import java.util.List;

import com.duantuke.basic.po.Journey;
import com.duantuke.basic.po.JourneyRHotel;
import com.duantuke.basic.po.JourneyRSight;

/**
 * @author he
 * 游记相关接口
 */
public interface JourneyService {
	public int addJourney(Journey journey);
	public int updateJourney(Journey journey);
	public int delJourneyById(Long id);
	public List<Journey> queryJourneys(Journey journey);
	public Journey queryJourneyById(Long id);
	public List<JourneyRHotel> queryHotelIdsByJourneyId(Long journeyId);
	public List<JourneyRSight> queryHotelIdsBySightId(Long journeyId);
}
