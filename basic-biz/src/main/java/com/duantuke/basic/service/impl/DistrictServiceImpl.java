package com.duantuke.basic.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duantuke.basic.face.base.RetInfo;
import com.duantuke.basic.face.service.DistrictService;
import com.duantuke.basic.mappers.DistrictMapper;
import com.duantuke.basic.po.District;
import com.duantuke.basic.po.DistrictExample;

/**
 * @author he
 * 区域相关接口
 */
@Service
public class DistrictServiceImpl implements DistrictService {
	
	private static Logger logger = LoggerFactory.getLogger(DistrictServiceImpl.class);
	
	@Autowired
	private DistrictMapper districtMapper;

	@Override
	public List<District> queryAllDistricts() {
		logger.info(DistrictServiceImpl.class.getName()+":queryAllDistricts begin");
		try {

			DistrictExample example = new DistrictExample();
			example.setOrderByClause("sort asc");
			return districtMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error(DistrictServiceImpl.class.getName()+":queryAllDistricts error",e);
			throw e;
		}
	}

	@Override
	public RetInfo<District> queryByCode(String districtcode) {
		RetInfo<District> retInfo = new RetInfo<District>();
		if(StringUtils.isBlank(districtcode)){
			logger.info("所传参数 districtcode 为空");
			retInfo.setResult(false);
			retInfo.setMsg("所传参数 districtcode 为空");
			return retInfo;
		}
		DistrictExample example = new DistrictExample();
		DistrictExample.Criteria hoCriteria = example.createCriteria();
		hoCriteria.andCodeEqualTo(Long.valueOf(districtcode));
		example.setOrderByClause("sort asc");
		List<District> models =  districtMapper.selectByExample( example);
		if( models != null && models.size() > 0){
			retInfo.setObj(models.get(0));
			retInfo.setResult(true);
		}else {
			retInfo.setResult(false);
			retInfo.setMsg("未找到"+ districtcode + " 区县");
		}
		return retInfo;
	}

}
