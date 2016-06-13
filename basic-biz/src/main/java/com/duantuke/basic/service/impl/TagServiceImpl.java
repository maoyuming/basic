package com.duantuke.basic.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duantuke.basic.face.service.TagService;
import com.duantuke.basic.mappers.TagMapper;
import com.duantuke.basic.po.Tag;

/**
 * 标签相关接口
 * @author he
 */
@Service
public class TagServiceImpl implements TagService {
	
	private static Logger logger = LoggerFactory.getLogger(TagServiceImpl.class);
	
	@Autowired
	private TagMapper tagMapper;

	@Override
	public List<Tag> queryTagsByHotelId(Long hotelId) {
		return tagMapper.queryTagsByHotelId(hotelId);
	}
	
}
