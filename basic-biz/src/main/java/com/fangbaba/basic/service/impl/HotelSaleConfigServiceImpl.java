package com.fangbaba.basic.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fangbaba.basic.face.bean.HotelSaleConfig;
import com.fangbaba.basic.face.service.HotelSaleConfigService;
import com.fangbaba.basic.mappers.HotelSaleConfigMapper;
import com.fangbaba.basic.po.HotelSaleConfigExample;
import com.fangbaba.basic.service.OtaRoomtypeService;

/**
 * @author he
 * 酒店网络配置房间数量相关接口
 */
@Service
public class HotelSaleConfigServiceImpl implements HotelSaleConfigService {

	private static Logger logger = LoggerFactory.getLogger(HotelSaleConfigServiceImpl.class);
	@Autowired
	private HotelSaleConfigMapper hotelSaleConfigMapper;
	@Autowired
	private OtaRoomtypeService otaRoomtypeService;
	
	
	/**
	 * 保存或更新
	 */
	@Override
	public void saveConfig(Long hotelid, Integer salenum) {
		try {
			HotelSaleConfigExample example = new HotelSaleConfigExample();
			example.createCriteria().andHotelidEqualTo(hotelid);
			List<HotelSaleConfig> list = hotelSaleConfigMapper.selectByExample(example);
			HotelSaleConfig hotelSaleConfig = null;
			if(CollectionUtils.isNotEmpty(list)){
				hotelSaleConfig = list.get(0);
				hotelSaleConfig.setHotelid(hotelid);
				hotelSaleConfig.setSaleNum(salenum);
				hotelSaleConfig.setUpdatetime(new Date());
				hotelSaleConfigMapper.updateByPrimaryKeySelective(hotelSaleConfig);
			}else{
				hotelSaleConfig = new HotelSaleConfig();
				hotelSaleConfig.setHotelid(hotelid);
				hotelSaleConfig.setSaleNum(salenum);
				hotelSaleConfig.setCreatetime(new Date());
				hotelSaleConfigMapper.updateByPrimaryKeySelective(hotelSaleConfig);
			}
			//创建ota_roomtype数据
			int i = otaRoomtypeService.initOtaRoomtype(hotelid, salenum);
			logger.info("创建ota_roomtype记录{}条",i);
		} catch (Exception e) {
			logger.error(HotelSaleConfigServiceImpl.class.getName()+":saveOrUpdate error",e);
			throw e;
		}
	}
	
	/**
	 * 根据hotelid查询
	 */
	@Override
	public HotelSaleConfig queryByHotelId(Long hotelid) {
		try {
			HotelSaleConfigExample example = new HotelSaleConfigExample();
			example.createCriteria().andHotelidEqualTo(hotelid);
			List<HotelSaleConfig> list = hotelSaleConfigMapper.selectByExample(example);
			if(CollectionUtils.isNotEmpty(list)){
				return list.get(0);
			}else{
				return null;
			}
		} catch (Exception e) {
			logger.error(HotelSaleConfigServiceImpl.class.getName()+":queryByHotelId error",e);
			throw e;
		}
	}

}
