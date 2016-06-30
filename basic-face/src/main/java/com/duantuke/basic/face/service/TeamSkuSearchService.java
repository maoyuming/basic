package com.duantuke.basic.face.service;

import java.util.List;

import com.duantuke.basic.face.esbean.output.TeamSkuOutputBean;
import com.duantuke.basic.face.esbean.query.TeamSkuQueryBean;

/**
 * @author he
 * teamSku es搜索相关接口
 */
public interface TeamSkuSearchService {
	/**
	 * @param teamSkuQueryBean
	 * 搜索es
	 */
	List<TeamSkuOutputBean> searchTeamSkusFromEs(TeamSkuQueryBean teamSkuQueryBean);
	
	/**
	 * @param teamSkuId 不传则刷全部
	 * 初始化es 
	 */
	void initEs(Long teamSkuId);
	
	/**
	 * @param teamSkuId
	 * 通过teamSkuid删除es
	 */
	boolean delEsByTeamSkuId(Long teamSkuId);
	
	/**
	 * 删除es
	 */
	void delEs();
}
