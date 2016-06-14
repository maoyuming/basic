package com.duantuke.basic.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duantuke.basic.enums.IsvisibleEnum;
import com.duantuke.basic.face.service.SaleService;
import com.duantuke.basic.mappers.SaleMapper;
import com.duantuke.basic.po.Boss;
import com.duantuke.basic.po.BossExample;
import com.duantuke.basic.po.Sale;
import com.duantuke.basic.po.SaleExample;

/**
 * c用户信息相关接口
 * @author tankai
 */
@Service
public class SaleServiceImpl implements SaleService {
	
	private static Logger logger = LoggerFactory.getLogger(SaleServiceImpl.class);
	
	@Autowired
	private SaleMapper saleMapper;

	@Override
	public Sale querySaleByPhone(String phone) {
		
		SaleExample example = new SaleExample();
		SaleExample.Criteria hoCriteria = example.createCriteria();
		hoCriteria.andPhoneEqualTo(phone);
		hoCriteria.andIsvisibleEqualTo(IsvisibleEnum.yes.getCode());
		List<Sale> models =  saleMapper.selectByExample( example);
		if(CollectionUtils.isNotEmpty(models)){
			return models.get(0);
		}
		return null;
	}


}
