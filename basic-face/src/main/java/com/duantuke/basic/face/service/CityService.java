package com.duantuke.basic.face.service;

import java.util.List;

import com.duantuke.basic.face.base.RetInfo;
import com.duantuke.basic.po.City;

public interface CityService {
	List<City> queryAllCitys();
	List<City> queryAllCitysByProvinceCode(Integer proid);

	/**
	 * 根据city Code 查询 city
	 * @param cityCode
	 * @return
	 */
	RetInfo<City> queryByCode( String citycode);
}
