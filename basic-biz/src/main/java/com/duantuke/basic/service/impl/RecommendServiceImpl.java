package com.duantuke.basic.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duantuke.basic.enums.IsvisibleEnum;
import com.duantuke.basic.enums.RecommendItemStateEnum;
import com.duantuke.basic.exception.OpenException;
import com.duantuke.basic.face.service.RecommendService;
import com.duantuke.basic.mappers.RecommendDetailMapper;
import com.duantuke.basic.mappers.RecommendItemMapper;
import com.duantuke.basic.po.RecommendDetail;
import com.duantuke.basic.po.RecommendDetailExample;
import com.duantuke.basic.po.RecommendItem;
import com.duantuke.basic.po.RecommendItemExample;

/**
 * 推荐位接口
 * @author tankai
 */
@Service
public class RecommendServiceImpl implements RecommendService {
	
	private static Logger logger = LoggerFactory.getLogger(RecommendServiceImpl.class);
	
	@Autowired
	private RecommendItemMapper recommendItemMapper;
	@Autowired
	private RecommendDetailMapper recommendDetailMapper;

	
	/**
	 * 根据地域信息查询推荐位
	 */
	@Override
	public List<RecommendItem> queryRecommendItemList(RecommendItem item) {

		RecommendItemExample example = new RecommendItemExample();
		RecommendItemExample.Criteria hoCriteria = example.createCriteria();
		hoCriteria.andPositionIdEqualTo(item.getPositionId());
		if(item.getCityCode()!=null){
			hoCriteria.andCityCodeEqualTo(item.getCityCode());
		}
		if(item.getProvinceCode()!=null){
			hoCriteria.andProvinceCodeEqualTo(item.getProvinceCode());
		}
		if(item.getDistrictCode()!=null){
			hoCriteria.andDistrictCodeEqualTo(item.getDistrictCode());
		}
		hoCriteria.andIsvisibleEqualTo(IsvisibleEnum.yes.getCode());
		hoCriteria.andStateEqualTo(RecommendItemStateEnum.pass.getCode());
		hoCriteria.andStartTimeLessThanOrEqualTo(new Date());
		hoCriteria.andEndTimeGreaterThanOrEqualTo(new Date());
		if(item.getIndex()==-1){
			throw new OpenException("查询页数错误");
		}
		example.setLimitStart(item.getBegin());
		example.setLimitEnd(item.getPageSize());
		
		example.setOrderByClause("recommend_sort desc");
		
		List<RecommendItem> models =  recommendItemMapper.selectByExample( example);
		return models;
	}

	
	
	/**
	 * 根据详情itemid查询发现详情
	 * @param id
	 * @return
	 */
	public  RecommendDetail selectByRecommendid(Long id){
		RecommendDetailExample example = new RecommendDetailExample();
		RecommendDetailExample.Criteria hoCriteria = example.createCriteria();
		hoCriteria.andRecommendIdEqualTo(id);
		List<RecommendDetail> recommendDetails =recommendDetailMapper.selectByExampleWithBLOBs(example);
		if(CollectionUtils.isNotEmpty(recommendDetails)){
			return recommendDetails.get(0);
		}
		return null;
	}
	
	/**
	 * 根据详情id查询发现详情
	 * @param id
	 * @return
	 */
	public  RecommendDetail selectByPrimaryKey(Long id){
		return recommendDetailMapper.selectByPrimaryKey(id);
	}


}
