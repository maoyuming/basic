package com.duantuke.basic.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duantuke.basic.face.base.RetInfo;
import com.duantuke.basic.face.service.CityService;
import com.duantuke.basic.mappers.CityMapper;
import com.duantuke.basic.po.City;
import com.duantuke.basic.po.CityExample;

/**
 * @author he
 * 城市相关接口
 */
@Service
public class CityServiceImpl implements CityService {
	
	private static Logger logger = LoggerFactory.getLogger(CityServiceImpl.class);
	
	@Autowired
	private CityMapper cityMapper;

	@Override
	public List<City> queryAllCitys() {
		logger.info(CityServiceImpl.class.getName()+":queryAllCitys begin");
		try {

			CityExample example = new CityExample();

			example.setOrderByClause("sort asc");
			return cityMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error(CityServiceImpl.class.getName()+":queryAllCitys error",e);
			throw e;
		}
	}

	@Override
	public List<City> queryAllCitysByProvinceCode(Integer proid) {
		CityExample example = new CityExample();
		example.createCriteria().andProidEqualTo(proid);
		example.setOrderByClause("sort asc");
		return cityMapper.selectByExample(example);
	}

	@Override
	public RetInfo<City> queryByCode(String citycode) {
		RetInfo<City> retInfo = new RetInfo<City>();
		if(StringUtils.isBlank(citycode)){
			logger.info("所传参数 citycode为空");
			retInfo.setResult(false);
			retInfo.setMsg("所传参数citycode为空");
			return retInfo;
		}
		CityExample example = new CityExample();
		CityExample.Criteria hoCriteria = example.createCriteria();
		hoCriteria.andCodeEqualTo(Long.valueOf(citycode));
		example.setOrderByClause("sort asc");
		List<City> models =  cityMapper.selectByExample( example);
		if( models != null && models.size() > 0){
			retInfo.setObj(models.get(0));
			retInfo.setResult(true);
		}else {
			retInfo.setResult(false);
			retInfo.setMsg("未找到"+ citycode + " 省市");
		}
		return retInfo;
	}


}
