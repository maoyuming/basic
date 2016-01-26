package com.fangbaba.basic.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fangbaba.basic.face.bean.HotelExtension;
import com.fangbaba.basic.mappers.HotelExtensionMapper;
import com.fangbaba.basic.po.HotelExtensionExample;
import com.fangbaba.basic.po.HotelExtensionExample.Criteria;
import com.fangbaba.basic.service.HotelExtensionService;

@Service
public class HotelExtensionServiceImpl implements HotelExtensionService {
	private static Logger logger = LoggerFactory.getLogger(HotelExtensionServiceImpl.class);

	@Autowired
	HotelExtensionMapper hotelExtensionMapper;

	@Override
	public HotelExtension getHotelExtension(Long hotelid) {
		try {
			HotelExtensionExample hotelExtensionExample = new HotelExtensionExample();
			Criteria hoCriteria = hotelExtensionExample.createCriteria();
			hoCriteria.andHotelidEqualTo(hotelid);
			List<HotelExtension> list = this.hotelExtensionMapper.selectByExampleWithBLOBs(hotelExtensionExample);
			if (CollectionUtils.isNotEmpty(list)) {
				return list.get(0);
			} else {
				HotelExtensionServiceImpl.logger.error("hotelid:{} does not exist.");
				return null;
			}
		} catch (Exception e) {
			HotelExtensionServiceImpl.logger.error(e.getStackTrace().toString());
			return null;
		}
	}

	@Override
	public Integer saveHotelExtension(HotelExtension hotelExtension) {
		return this.hotelExtensionMapper.insert(hotelExtension);
	}

	@Override
	public Integer updateHotelExtension(HotelExtension hotelExtension) {
		return this.hotelExtensionMapper.updateByPrimaryKeySelective(hotelExtension);
	}

	@Override
	public Integer delHotelExtension(Long id) {
		return this.hotelExtensionMapper.deleteByPrimaryKey(id);
	}
}
