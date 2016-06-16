package com.duantuke.basic.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duantuke.basic.enums.IsvisibleEnum;
import com.duantuke.basic.face.service.CustomerLikeHotelService;
import com.duantuke.basic.mappers.CustomerLikeHotelMapper;
import com.duantuke.basic.po.CustomerLikeHotelExample;
import com.duantuke.basic.po.Hotel;

/**
 * @author he
 * 酒店相关接口
 */
@Service
public class CustomerLikeHotelServiceImpl implements CustomerLikeHotelService {
	
	private static Logger logger = LoggerFactory.getLogger(CustomerLikeHotelServiceImpl.class);
	
	@Autowired
	private CustomerLikeHotelMapper customerLikeHotelMapper;

	
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
