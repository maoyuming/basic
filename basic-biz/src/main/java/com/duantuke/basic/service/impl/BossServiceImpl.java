package com.duantuke.basic.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duantuke.basic.enums.IsvisibleEnum;
import com.duantuke.basic.face.base.RetInfo;
import com.duantuke.basic.face.service.BossService;
import com.duantuke.basic.mappers.BossMapper;
import com.duantuke.basic.mappers.BossesRHotelMapper;
import com.duantuke.basic.mappers.HotelMapper;
import com.duantuke.basic.po.Boss;
import com.duantuke.basic.po.BossExample;
import com.duantuke.basic.po.BossesRHotel;
import com.duantuke.basic.po.BossesRHotelExample;
import com.duantuke.basic.po.Hotel;
import com.google.gson.Gson;

/**
 * b用户信息相关接口
 * @author tankai
 */
@Service
public class BossServiceImpl implements BossService {
	
	private static Logger logger = LoggerFactory.getLogger(BossServiceImpl.class);
	
	@Autowired
	private BossMapper bossMapper;
	@Autowired
	private HotelMapper hotelMapper;
	@Autowired
	private BossesRHotelMapper bossesRHotelMapper;

	@Override
	public Boss queryBossByPhone(String phone) {
		BossExample example = new BossExample();
		BossExample.Criteria hoCriteria = example.createCriteria();
		hoCriteria.andPhoneEqualTo(phone);
		hoCriteria.andIsvisibleEqualTo(IsvisibleEnum.yes.getCode());
		List<Boss> models =  bossMapper.selectByExample( example);
		if(CollectionUtils.isNotEmpty(models)){
			return models.get(0);
		}
		return null;
	}
	
	
	/**
	 * 酒店老板是否存在
	 * @param phone
	 * @return
	 */
	public boolean isExistBossByPhone(String phone) {
		Boss boss = queryBossByPhone(phone);
		return boss==null?false:true;
	}

	
	/**
	 * 查询可用老板信息
	 */
	@Override
	public List<Boss> queryBosss(Boss Boss) {

		BossExample example = new BossExample();
		BossExample.Criteria hoCriteria = example.createCriteria();
		hoCriteria.andIsvisibleEqualTo(IsvisibleEnum.yes.getCode());
		List<Boss> models =  bossMapper.selectByExample( example);
		return models;
	}

	@Override
	public Boss queryBossByLoginName(String loginName) {

		BossExample example = new BossExample();
		BossExample.Criteria hoCriteria = example.createCriteria();
		hoCriteria.andLoginNameEqualTo(loginName);
		hoCriteria.andIsvisibleEqualTo(IsvisibleEnum.yes.getCode());
		List<Boss> models =  bossMapper.selectByExample( example);
		if(CollectionUtils.isNotEmpty(models)){
			return models.get(0);
		}
		return null;
	
	}

	@Override
	public RetInfo<Boolean> saveOrUpdateBosss(Boss Boss) {
		// TODO Auto-generated method stub
		return null;
	}

	
	/**
	 * 注册新的b端用户
	 */
	@Override
	public RetInfo<Boolean> register(Boss boss) {
//		logger.info("注册新用户,老板={},销售={}",new Gson().toJson(boss),new Gson().toJson(sale));
		logger.info("注册新用户,老板={}",new Gson().toJson(boss));
		RetInfo<Boolean> info = new RetInfo<Boolean>();
		info.setResult(false);
		
		//check老板是否存在
		if(isExistBossByPhone(boss.getPhone())){
			info.setMsg("老板端手机号码已经存在");
			return info;
		}
		//保存老板信息
		int count=bossMapper.insertSelective(boss);
		if(count>0){
			info.setResult(true);
		}else{
			info.setMsg("保存老板信息失败");
		}
		return info;
	}


	/**
	 * 根据老板id查询酒店信息
	 */
	@Override
	public List<Hotel> queryHotelByBoss(Long bossid) {
		List<Hotel>  hotels = new ArrayList<Hotel>();
		//根据老板id查询出酒店id，
		BossesRHotelExample example = new BossesRHotelExample();
		BossesRHotelExample.Criteria hoCriteria = example.createCriteria();
		hoCriteria.andBossIdEqualTo(bossid);
		List<BossesRHotel> models =  bossesRHotelMapper.selectByExample(example);
		//根据酒店id查询出酒店信息
		if(CollectionUtils.isNotEmpty(models)){
			for (BossesRHotel bossesRHotel : models) {
				Hotel hotel = hotelMapper.selectByPrimaryKey(bossesRHotel.getHotelId());
				hotels.add(hotel);
			}
		}
		
		return hotels;
	}


	/**
	 * 根据登录名称查询酒店信息
	 */
	@Override
	public List<Hotel> queryHotelByBossLoginName(String loginName) {
		Boss boss = this.queryBossByLoginName(loginName);
		if(boss!=null){
			return queryHotelByBoss(boss.getBossId());
		}
		return new ArrayList<Hotel>();
	}


	@Override
	public Boss queryBossById(Long bossId) {
		return bossMapper.selectByPrimaryKey(bossId);
	}


}
