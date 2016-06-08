package com.duantuke.basic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		DuantukeCommentExample example = new DuantukeCommentExample();
		DuantukeCommentExample.Criteria hoCriteria = example.createCriteria();
		hoCriteria.andBusinessTypeEqualTo(duantukeComment.getBusinessType());
		hoCriteria.andFidEqualTo(duantukeComment.getFid());
		return duantukeCommentMapper.countByExample(example);
	}

	@Override
	public int deleteDuantukeComment(DuantukeComment duantukeComment) {

		DuantukeCommentExample example = new DuantukeCommentExample();
		DuantukeCommentExample.Criteria hoCriteria = example.createCriteria();
		hoCriteria.andBusinessTypeEqualTo(duantukeComment.getBusinessType());
		hoCriteria.andFidEqualTo(duantukeComment.getFid());
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

		DuantukeCommentExample example = new DuantukeCommentExample();
		DuantukeCommentExample.Criteria hoCriteria = example.createCriteria();
		hoCriteria.andBusinessTypeEqualTo(duantukeComment.getBusinessType());
		hoCriteria.andFidEqualTo(duantukeComment.getFid());
	
		return duantukeCommentMapper.selectByExample(example);
	}
	
}