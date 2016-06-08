package com.duantuke.basic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duantuke.basic.face.service.DuantukeLikeService;
import com.duantuke.basic.mappers.DuantukeLikeMapper;
import com.duantuke.basic.po.DuantukeLike;
import com.duantuke.basic.po.DuantukeLikeExample;

@Service
public class DuantukeLikeServiceImpl implements DuantukeLikeService{


	@Autowired
	private DuantukeLikeMapper duantukeLikeMapper;
	
	
	/**
	 * 根据类型计算评论数
	 */
	@Override
	public int countDuantukeLike(DuantukeLike duantukeLike) {
		DuantukeLikeExample example = new DuantukeLikeExample();
		DuantukeLikeExample.Criteria hoCriteria = example.createCriteria();
		hoCriteria.andBusinessTypeEqualTo(duantukeLike.getBusinessType());
		hoCriteria.andFidEqualTo(duantukeLike.getFid());
		hoCriteria.andCustomerIdEqualTo(duantukeLike.getCustomerId());
		return duantukeLikeMapper.countByExample(example);
	}

	@Override
	public int deleteDuantukeLike(DuantukeLike duantukeLike) {

		DuantukeLikeExample example = new DuantukeLikeExample();
		DuantukeLikeExample.Criteria hoCriteria = example.createCriteria();
		hoCriteria.andBusinessTypeEqualTo(duantukeLike.getBusinessType());
		hoCriteria.andFidEqualTo(duantukeLike.getFid());
		hoCriteria.andCustomerIdEqualTo(duantukeLike.getCustomerId());
		return duantukeLikeMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Long duantukeLikeId) {
		return duantukeLikeMapper.deleteByPrimaryKey(duantukeLikeId);
	}

	@Override
	public int insert(DuantukeLike duantukeLike) {
		return duantukeLikeMapper.insertSelective(duantukeLike);
	}

	@Override
	public List<DuantukeLike> selectByDuantukeLike(
			DuantukeLike duantukeLike) {

		DuantukeLikeExample example = new DuantukeLikeExample();
		DuantukeLikeExample.Criteria hoCriteria = example.createCriteria();
		hoCriteria.andBusinessTypeEqualTo(duantukeLike.getBusinessType());
		hoCriteria.andFidEqualTo(duantukeLike.getFid());
		hoCriteria.andCustomerIdEqualTo(duantukeLike.getCustomerId());
		return duantukeLikeMapper.selectByExample(example);
	}
	

}