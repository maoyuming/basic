package com.duantuke.basic.face.service;

import java.util.List;
import java.util.Map;

import com.duantuke.basic.face.esbean.output.JourneyOutputBean;
import com.duantuke.basic.face.esbean.query.JourneyQueryBean;

/**
 * @author he
 * journey es搜索相关接口
 */
public interface JourneySearchService {
	/**
	 * @param journeyQueryBean
	 * 搜索es
	 */
	List<JourneyOutputBean> searchJourneysFromEs(JourneyQueryBean journeyQueryBean,Map<String,List<String>> hotelIds,Map<String,List<String>> sightIds);
	
	/**
	 * @param journeyId 不传则刷全部
	 * 初始化es 
	 */
	void initEs(Long journeyId);
	
	/**
	 * @param journeyId
	 * 通过journeyid删除es
	 */
	boolean delEsByJourneyId(Long journeyId);
	
	/**
	 * 删除es
	 */
	void delEs();
}
