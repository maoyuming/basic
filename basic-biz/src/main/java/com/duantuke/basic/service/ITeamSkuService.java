package com.duantuke.basic.service;

import java.util.List;

import com.duantuke.basic.esbean.input.TeamSkuInputBean;
import com.duantuke.basic.face.service.TeamSkuService;

public interface ITeamSkuService extends TeamSkuService {
	public List<TeamSkuInputBean> queryEsInputTeamSkus(Long teamSkuId);
	public List<TeamSkuInputBean> queryEsInputTeamSkusByHotelId(Long hotelId);
}
