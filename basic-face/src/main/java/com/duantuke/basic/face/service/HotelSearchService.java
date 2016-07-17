package com.duantuke.basic.face.service;

import java.util.List;

import com.duantuke.basic.face.esbean.output.HotelOutputBean;
import com.duantuke.basic.face.esbean.query.HotelQueryBean;
import com.duantuke.basic.face.esbean.query.MealQueryBean;
import com.duantuke.basic.face.esbean.query.TeamSkuQueryBean;

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
	List<HotelOutputBean> searchHotelsFromEs(HotelQueryBean hotelQueryBean,MealQueryBean mealQueryBean,TeamSkuQueryBean teamSkuQueryBean);
	List<HotelOutputBean> searchHotelsFromEsByTeam(HotelQueryBean hotelQueryBean,TeamSkuQueryBean teamSkuQueryBean);
	List<HotelOutputBean> searchHotelsFromEsByMeal(HotelQueryBean hotelQueryBean,MealQueryBean mealQueryBean);
	
	/**
	 * @param hotelId 不传则刷全部
	 * 初始化es 
	 */
	void initEs(Long hotelId);
	/**
	 * @param hotelId 不传则刷全部
	 * 刷价格 
	 */
	void refreshesprice(Long hotelId) throws Exception;
	/**
	 * @param hotelId 不传则刷全部
	 * 刷tag 
	 */
	void refreshestag(Long hotelId) throws Exception;
	/**
	 * @param hotelId 不传则刷全部
	 * 刷meal 
	 */
	void refreshesmeal(Long hotelId) throws Exception;
	/**
	 * @param hotelId 不传则刷全部
	 * 刷teamsku 
	 */
	void refreshesteamsku(Long hotelId) throws Exception;
	
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
