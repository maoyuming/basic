package com.duantuke.basic.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duantuke.basic.enums.IsvisibleEnum;
import com.duantuke.basic.face.service.CustomerLikeService;
import com.duantuke.basic.mappers.CustomerLikeHotelMapper;
import com.duantuke.basic.mappers.CustomerLikeSightMapper;
import com.duantuke.basic.po.CustomerLikeHotelExample;
import com.duantuke.basic.po.CustomerLikeSightExample;
import com.duantuke.basic.po.Hotel;
import com.duantuke.basic.po.Sight;

/**
 * @author tankai
 * 收藏相关接口
 */
@Service
public class CustomerLikeServiceImpl implements CustomerLikeService {
	
	private static Logger logger = LoggerFactory.getLogger(CustomerLikeServiceImpl.class);
	
	@Autowired
	private CustomerLikeSightMapper customerLikeSightMapper;

	@Autowired
	private CustomerLikeHotelMapper customerLikeHotelMapper;
	
	/**
	 * 根据用户id查询收藏的景点列表
	 */
	@Override
	public List<Sight> querySights(Long customerId) {
		logger.info("查询用户customer：{}的收藏景点",customerId);
		CustomerLikeSightExample example = new CustomerLikeSightExample();
		CustomerLikeSightExample.Criteria criteria = example.createCriteria();
		
//		criteria.andIsvisibleEqualTo(IsvisibleEnum.yes.getCode());
		criteria.andCustomerIdEqualTo(customerId);
		
		return customerLikeSightMapper.selectByExample(example);
	}
	

	
	/**
	 * 根据用户id查询收藏的酒店列表
	 */
	@Override
	public List<Hotel> queryHotels(Long customerId) {
		logger.info("查询用户customer：{}的收藏酒店",customerId);
		CustomerLikeHotelExample example = new CustomerLikeHotelExample();
		CustomerLikeHotelExample.Criteria criteria = example.createCriteria();
		
		criteria.andIsvisibleEqualTo(IsvisibleEnum.yes.getCode());
		criteria.andCustomerIdEqualTo(customerId);
		
		return customerLikeHotelMapper.selectByExample(example);
	}


}
