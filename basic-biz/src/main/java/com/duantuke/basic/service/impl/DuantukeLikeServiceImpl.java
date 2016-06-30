package com.duantuke.basic.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duantuke.basic.enums.BusinessTypeEnum;
import com.duantuke.basic.exception.OpenException;
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
		if(duantukeLike.getBusinessType()==null){
			throw new OpenException("请求类型为空");
		}
		DuantukeLikeExample example = new DuantukeLikeExample();
		DuantukeLikeExample.Criteria hoCriteria = example.createCriteria();
		hoCriteria.andBusinessTypeEqualTo(duantukeLike.getBusinessType());
		hoCriteria.andFidEqualTo(duantukeLike.getFid());
		if(duantukeLike.getCustomerId()!=null){
			hoCriteria.andCustomerIdEqualTo(duantukeLike.getCustomerId());
		}
		return duantukeLikeMapper.countByExample(example);
	}

	@Override
	public int deleteDuantukeLike(DuantukeLike duantukeLike) {
		if(duantukeLike.getBusinessType()==null){
			throw new OpenException("请求类型为空");
		}
		DuantukeLikeExample example = new DuantukeLikeExample();
		DuantukeLikeExample.Criteria hoCriteria = example.createCriteria();
		hoCriteria.andBusinessTypeEqualTo(duantukeLike.getBusinessType());
		hoCriteria.andFidEqualTo(duantukeLike.getFid());
		hoCriteria.andCustomerIdEqualTo(duantukeLike.getCustomerId());
		
		int count = 0;
		List<DuantukeLike> list = duantukeLikeMapper.selectByExample(example);
		if(CollectionUtils.isNotEmpty(list)){
			for (DuantukeLike duantukeLike2 : list) {
				 int subcount = duantukeLikeMapper.deleteByPrimaryKey(duantukeLike2.getDuantukeLikeId());
				 count =count+subcount;
			}
		}
		
		return count;
		
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
		if(duantukeLike.getBusinessType()==null){
			throw new OpenException("请求类型为空");
		}
		DuantukeLikeExample example = new DuantukeLikeExample();
		DuantukeLikeExample.Criteria hoCriteria = example.createCriteria();
		hoCriteria.andBusinessTypeEqualTo(duantukeLike.getBusinessType());
		hoCriteria.andFidEqualTo(duantukeLike.getFid());
		if(duantukeLike.getCustomerId()!=null){
			hoCriteria.andCustomerIdEqualTo(duantukeLike.getCustomerId());
		}
		return duantukeLikeMapper.selectByExample(example);
	}
	

}