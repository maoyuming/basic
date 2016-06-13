package com.duantuke.basic.face.service;

import java.util.List;

import com.duantuke.basic.po.Tag;

/**
 * @author he
 * 标签相关接口
 */
public interface TagService {
	public List<Tag> queryTagsByHotelId(Long hotelId);
}
