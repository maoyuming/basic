package com.duantuke.basic.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duantuke.basic.enums.HotelStateEnum;
import com.duantuke.basic.enums.IsvisibleEnum;
import com.duantuke.basic.enums.ReadonlyEnum;
import com.duantuke.basic.exception.OpenException;
import com.duantuke.basic.face.base.RetInfo;
import com.duantuke.basic.face.bean.BossParam;
import com.duantuke.basic.face.service.BossService;
import com.duantuke.basic.face.service.HotelService;
import com.duantuke.basic.face.service.SaleService;
import com.duantuke.basic.mappers.BossMapper;
import com.duantuke.basic.mappers.BossesRHotelMapper;
import com.duantuke.basic.mappers.HotelMapper;
import com.duantuke.basic.mappers.SalesRHotelMapper;
import com.duantuke.basic.po.Boss;
import com.duantuke.basic.po.BossExample;
import com.duantuke.basic.po.BossesRHotel;
import com.duantuke.basic.po.BossesRHotelExample;
import com.duantuke.basic.po.Hotel;
import com.duantuke.basic.po.Sale;
import com.duantuke.basic.po.SalesRHotel;
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
	private HotelService hotelService;
	@Autowired
	private SaleService saleService;
	@Autowired
	private BossesRHotelMapper bossesRHotelMapper;
	@Autowired
	private SalesRHotelMapper salesRHotelMapper;

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
	public RetInfo<Boolean> register(BossParam boss) {
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
			//新建酒店
			if(boss.getHotelId()!=null){
				//已经存在酒店，绑定老板关系，和处理hotel的readonly字段
				Hotel hotel = new Hotel();
				hotel.setHotelId(boss.getHotelId());
				hotel.setReadonly(ReadonlyEnum.yes.getCode());
				hotel.setUpdatetime(new Date());
				hotel.setUpdateuser(boss.getSalePhone());
				hotel.setState(HotelStateEnum.init.getId());
				

				hotel.setLatitude(boss.getLatitude());
				hotel.setLongitude(boss.getLongitude());
				
				int num = hotelService.updateHotel(hotel);
				if(num>0){
					//绑定老板关系
					saveBossesRHotel(boss.getBossId(), boss.getHotelId(), boss.getSalePhone());
					saveSalesRHotel(boss.getSalePhone(), boss.getHotelId());
				}
			}else{
				//已经存在酒店，绑定老板关系，和处理hotel的readonly字段
				Hotel hotel = new Hotel();
				hotel.setHotelName(boss.getHotelName());
				hotel.setReadonly(ReadonlyEnum.yes.getCode());
				hotel.setCreatetime(new Date());
				hotel.setUpdatetime(new Date());
				hotel.setCreateuser(boss.getSalePhone());
				hotel.setUpdateuser(boss.getSalePhone());
				

				hotel.setLatitude(boss.getLatitude());
				hotel.setLongitude(boss.getLongitude());
				
				hotel.setState(HotelStateEnum.init.getId());
				int num = hotelService.addHotel(hotel);
				if(num>0){
					//绑定老板关系
					saveBossesRHotel(boss.getBossId(), hotel.getHotelId(), boss.getSalePhone());
					saveSalesRHotel(boss.getSalePhone(), hotel.getHotelId());
				}
			}
			info.setResult(true);
		}else{
			info.setMsg("保存老板信息失败");
		}
		return info;
	}

	
	/**
	 * 保存老板和酒店关系
	 * @param bossId
	 * @param hotelId
	 * @param salePhone
	 * @return
	 */
	public int saveBossesRHotel(Long bossId,Long hotelId,String salePhone){
		BossesRHotel record = new BossesRHotel();
		record.setBossId(bossId);
		record.setHotelId(hotelId);
		record.setCreateuser(salePhone);
		record.setUpdateuser(salePhone);
		record.setCreatetime(new Date());
		record.setUpdatetime(new Date());
		return bossesRHotelMapper.insertSelective(record);
	}
	
	/**
	 * 保存销售和酒店关系
	 * @param bossId
	 * @param hotelId
	 * @param salePhone
	 * @return
	 */
	public int saveSalesRHotel(String salePhone,Long hotelId){
		//根据销售手机号码反查销售id
		Sale sale = saleService.querySaleByPhone(salePhone);
		if(sale==null){
			throw new OpenException("销售信息不存在");
		}
		SalesRHotel record = new SalesRHotel();
		record.setSaleId(sale.getSalesId());
		record.setHotelId(hotelId);
		record.setCreateuser(salePhone);
		record.setUpdateuser(salePhone);
		record.setCreatetime(new Date());
		record.setUpdatetime(new Date());
		return salesRHotelMapper.insertSelective(record);
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
