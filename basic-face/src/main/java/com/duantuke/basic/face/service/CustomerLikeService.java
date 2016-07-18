package com.duantuke.basic.face.service;

import java.util.List;

import com.duantuke.basic.face.bean.PageItem;
import com.duantuke.basic.po.Hotel;
import com.duantuke.basic.po.Journey;
import com.duantuke.basic.po.Sight;

/**
 * 用户关注收藏相关接口
 * @author tankai
 */
public interface CustomerLikeService {
	public List<Sight> querySights(Long customerId,PageItem pageItem);

	public List<Hotel> queryHotels(Long customerId,PageItem pageItem);
	
	
	public List<Journey> queryJourneys(Long customerId,PageItem pageItem);

}
