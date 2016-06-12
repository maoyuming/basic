package com.duantuke.basic.face.service;

import java.util.List;
import java.util.Map;

import com.duantuke.basic.face.esbean.output.HotelOutputBean;
import com.duantuke.basic.face.esbean.query.HotelQueryBean;

/**
 * @author he
 * hotel es搜索相关接口
 */
public interface HotelSearchService {
	/**
	 * @param hotelQueryBean
	 * @param tags
	 * 搜索es
	 */
	List<HotelOutputBean> searchHotelsFromEs(HotelQueryBean hotelQueryBean,Map<String,String> tags);
	
	/**
	 * @param hotelId 不传则刷全部
	 * 初始化es 
	 */
	void initEs(Long hotelId);
	
	/**
	 * @param hotelId
	 * 通过hotelid删除es
	 */
	boolean delEsByHotelId(Long hotelId);
	
	/**
	 * 删除es
	 */
	void delEs();
}
