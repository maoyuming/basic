package com.duantuke.basic.face.service;

import java.util.List;

import com.duantuke.basic.po.RecommendDetail;
import com.duantuke.basic.po.RecommendItem;

public interface RecommendService {
	/**
	 * 根据地域等信息查询推荐位
	 * @param item
	 * @return
	 */
	public List<RecommendItem> queryRecommendItemList(RecommendItem item);
	
	
	

	/**
	 * 根据详情itemid查询发现详情
	 * @param id
	 * @return
	 */
	public  RecommendDetail selectByRecommendid(Long id);
	
	/**
	 * 根据详情id查询发现详情
	 * @param id
	 * @return
	 */
	public  RecommendDetail selectByPrimaryKey(Long id);
}
