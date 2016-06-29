package com.duantuke.basic.face.service;

import java.util.List;

import com.duantuke.basic.po.TeamSku;

/**
 * @author he
 * 饮食相关接口
 */
public interface TeamSkuService {
	public int addTeamSku(TeamSku teamSku);
	public int updateTeamSku(TeamSku teamSku);
	public int delTeamSkuById(Long id);
	public List<TeamSku> queryTeamSkus(TeamSku teamSku);
	public TeamSku queryTeamSkuById(Long skuid);
	

	public List<TeamSku> queryTeamSkuByHotleId(Long hotelId);
	public TeamSku queryTeamSkuBySkuId(Long skuId);
	public List<TeamSku> queryTeamSkuBySkuIds(List<Long> skuIds);
}
