package com.duantuke.basic.face.service;

import java.util.List;

import com.duantuke.basic.face.base.RetInfo;
import com.duantuke.basic.po.Boss;

public interface BossService {
	
	public Boss queryBossByPhone(String phone);
	
	public Boss queryBossByLoginName(String loginName);
	
	public List<Boss> queryBosss(Boss Boss);
	
	
	public RetInfo<Boolean> saveOrUpdateBosss(Boss Boss);
	
	/**
	 * 注册老板端
	 * @param Boss
	 * @return
	 */
	public RetInfo<Boolean> register(Boss Boss);
}
