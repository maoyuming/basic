package com.duantuke.basic.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duantuke.basic.face.base.RetInfo;
import com.duantuke.basic.face.service.ProvinceService;
import com.duantuke.basic.mappers.ProvinceMapper;
import com.duantuke.basic.po.Province;
import com.duantuke.basic.po.ProvinceExample;

/**
 * @author he
 * 省相关接口
 */
@Service
public class ProvinceServiceImpl implements ProvinceService {
	
	private static Logger logger = LoggerFactory.getLogger(ProvinceServiceImpl.class);
	
	@Autowired
	private ProvinceMapper provinceMapper;

	@Override
	public List<Province> queryAllProvinces() {
		logger.info(ProvinceServiceImpl.class.getName()+":queryAllProvinces begin");
		try {
			ProvinceExample example = new ProvinceExample();
			example.setOrderByClause("sort asc");
			return provinceMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error(ProvinceServiceImpl.class.getName()+":queryAllProvinces error",e);
			throw e;
		}
	}

	@Override
	public RetInfo<Province> queryByCode(String provCode) {
		RetInfo<Province> retInfo = new RetInfo<Province>();
		if(StringUtils.isBlank(provCode)){
			logger.info("所传参数 provCode 为空");
			retInfo.setResult(false);
			retInfo.setMsg("所传参数provCode为空");
			return retInfo;
		}
		ProvinceExample example = new ProvinceExample();
		ProvinceExample.Criteria hoCriteria = example.createCriteria();
		hoCriteria.andCodeEqualTo(provCode);
		List<Province> models =  provinceMapper.selectByExample( example);
		if( models != null && models.size() > 0){
			retInfo.setObj(models.get(0));
			retInfo.setResult(true);
		}else {
			retInfo.setResult(false);
			retInfo.setMsg("未找到"+ provCode + " 省市");
		}
		return retInfo;
	}

}
