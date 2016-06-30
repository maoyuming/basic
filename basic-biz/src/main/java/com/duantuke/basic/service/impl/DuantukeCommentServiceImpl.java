package com.duantuke.basic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duantuke.basic.exception.OpenException;
import com.duantuke.basic.face.service.DuantukeCommentService;
import com.duantuke.basic.mappers.DuantukeCommentMapper;
import com.duantuke.basic.po.DuantukeComment;
import com.duantuke.basic.po.DuantukeCommentExample;

@Service
public class DuantukeCommentServiceImpl implements DuantukeCommentService{

	@Autowired
	private DuantukeCommentMapper duantukeCommentMapper;
	
	
	/**
	 * 根据类型计算评论数
	 */
	@Override
	public int countDuantukeComment(DuantukeComment duantukeComment) {
		if(duantukeComment.getBusinessType()==null){
			throw new OpenException("请求类型为空");
		}
		DuantukeCommentExample example = new DuantukeCommentExample();
		DuantukeCommentExample.Criteria hoCriteria = example.createCriteria();
		hoCriteria.andBusinessTypeEqualTo(duantukeComment.getBusinessType());
		if(duantukeComment.getFid()!=null){
			hoCriteria.andFidEqualTo(duantukeComment.getFid());
		}
		return duantukeCommentMapper.countByExample(example);
	}

	@Override
	public int deleteDuantukeComment(DuantukeComment duantukeComment) {
		if(duantukeComment.getBusinessType()==null){
			throw new OpenException("请求类型为空");
		}
		DuantukeCommentExample example = new DuantukeCommentExample();
		DuantukeCommentExample.Criteria hoCriteria = example.createCriteria();
		hoCriteria.andBusinessTypeEqualTo(duantukeComment.getBusinessType());
		if(duantukeComment.getFid()!=null){
			hoCriteria.andFidEqualTo(duantukeComment.getFid());
		}
		return duantukeCommentMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Long duantukeCommentId) {
		return duantukeCommentMapper.deleteByPrimaryKey(duantukeCommentId);
	}

	@Override
	public int insert(DuantukeComment duantukeComment) {
		return duantukeCommentMapper.insertSelective(duantukeComment);
	}

	@Override
	public List<DuantukeComment> selectByDuantukeComment(
			DuantukeComment duantukeComment) {
		if(duantukeComment.getBusinessType()==null){
			throw new OpenException("请求类型为空");
		}
		DuantukeCommentExample example = new DuantukeCommentExample();
		DuantukeCommentExample.Criteria hoCriteria = example.createCriteria();
		hoCriteria.andBusinessTypeEqualTo(duantukeComment.getBusinessType());
		if(duantukeComment.getFid()!=null){
			hoCriteria.andFidEqualTo(duantukeComment.getFid());
		}
		example.setLimitStart(duantukeComment.getBegin());
		example.setLimitEnd(duantukeComment.getPageSize());
		return duantukeCommentMapper.selectByExample(example);
	}
	
}