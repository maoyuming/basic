package com.duantuke.basic.face.service;

import java.util.List;

import com.duantuke.basic.face.base.RetInfo;
import com.duantuke.basic.po.Boss;
import com.duantuke.basic.po.Hotel;

public interface BossService {
	
	public Boss queryBossByPhone(String phone);
	
	public Boss queryBossByLoginName(String loginName);
	
	public List<Boss> queryBosss(Boss boss);
	
	
	public RetInfo<Boolean> saveOrUpdateBosss(Boss boss);
	
	/**
	 * 注册老板端
	 * @param Boss
	 * @return
	 */
	public RetInfo<Boolean> register(Boss boss);
	

	/**
	 * 根据老板id查询酒店信息
	 * @param bossid
	 * @return
	 */
	public List<Hotel> queryHotelByBoss(Long  bossid);
	/**
	 * 根据老板登录账号查询酒店信息
	 * @param bossid
	 * @return
	 */
	public List<Hotel> queryHotelByBossLoginName(String loginName);
}
