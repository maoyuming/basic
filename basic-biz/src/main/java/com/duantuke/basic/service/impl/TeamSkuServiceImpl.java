package com.duantuke.basic.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duantuke.basic.face.service.TeamSkuService;
import com.duantuke.basic.mappers.TeamSkuMapper;
import com.duantuke.basic.po.TeamSku;
import com.duantuke.basic.po.TeamSkuExample;
import com.duantuke.basic.po.TeamSkuExample.Criteria;

/**
 * @author he
 * 饮食相关接口
 */
@Service
public class TeamSkuServiceImpl implements TeamSkuService {
	
	private static Logger logger = LoggerFactory.getLogger(TeamSkuServiceImpl.class);
	@Autowired
	private TeamSkuMapper teamSkuMapper;

	@Override
	public int addTeamSku(TeamSku teamSku) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateTeamSku(TeamSku teamSku) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delTeamSkuById(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<TeamSku> queryTeamSkus(TeamSku teamSku) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TeamSku queryTeamSkuById(Long skuid) {

		TeamSkuExample example = new TeamSkuExample();
		TeamSkuExample.Criteria criteria = example.createCriteria();
		criteria.andSkuIdEqualTo(skuid);
		List<TeamSku> list = teamSkuMapper.selectByExample(example);
		if(CollectionUtils.isNotEmpty(list)){
			return list.get(0);
		}
		return null;
	
	}

	@Override
	public List<TeamSku> queryTeamSkuByHotleId(Long hotelId) {

		TeamSkuExample example = new TeamSkuExample();
		Criteria criteria =  example.createCriteria();
		criteria.andSupplierIdEqualTo(hotelId);
		List<TeamSku> list =  teamSkuMapper.selectByExample(example);
		return list;
	
	}

	@Override
	public TeamSku queryTeamSkuBySkuId(Long skuId) {


		TeamSkuExample example = new TeamSkuExample();
		Criteria criteria =  example.createCriteria();
		criteria.andSkuIdEqualTo(skuId);
		
		List<TeamSku> list = teamSkuMapper.selectByExample(example);
		if(CollectionUtils.isNotEmpty(list)){
			return list.get(0);
		}
		return null;
	
	
	}

	@Override
	public List<TeamSku> queryTeamSkuBySkuIds(List<Long> skuIds) {


		List<TeamSku> allList =new ArrayList<TeamSku>();
		for (Long mealId : skuIds) {
			TeamSkuExample example = new TeamSkuExample();
			TeamSkuExample.Criteria criteria =  example.createCriteria();
			criteria.andSkuIdEqualTo(mealId);
			
			List<TeamSku> list = teamSkuMapper.selectByExample(example);
			if(CollectionUtils.isNotEmpty(list)){
				allList.addAll(list);
			}
		}
		return allList;
	
	
	}
	

}
