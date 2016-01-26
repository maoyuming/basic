package com.fangbaba.basic.face.service;

import java.util.List;

import com.fangbaba.basic.face.bean.CityModel;

public interface CityService {
	List<CityModel> queryAllCitys();
	List<CityModel> queryAllCitysByProvinceCode(Integer proid);
}
