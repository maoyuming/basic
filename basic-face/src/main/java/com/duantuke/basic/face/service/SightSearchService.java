package com.duantuke.basic.face.service;

import java.util.List;
import java.util.Map;

import com.duantuke.basic.face.esbean.output.SightOutputBean;
import com.duantuke.basic.face.esbean.query.SightQueryBean;

/**
 * @author he
 * sight es搜索相关接口
 */
public interface SightSearchService {
	/**
	 * @param sightQueryBean
	 * @param tags
	 * 搜索es
	 */
	List<SightOutputBean> searchSightsFromEs(SightQueryBean sightQueryBean,Map<String, String> tags);
	
	/**
	 * @param sightId 不传则刷全部
	 * 初始化es 
	 */
	void initEs(Long sightId);
	
	/**
	 * @param sightId
	 * 删除es
	 */
	boolean delEsBySightId(Long sightId);
	
	/**
	 * @param sightId
	 * 更新es
	 */
	void updateEsBySightId(Long sightId);
}
