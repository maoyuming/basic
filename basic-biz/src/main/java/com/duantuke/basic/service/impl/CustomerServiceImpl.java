package com.duantuke.basic.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duantuke.basic.face.service.CustomerService;
import com.duantuke.basic.mappers.CustomerMapper;
import com.duantuke.basic.po.Customer;
import com.duantuke.basic.po.CustomerExample;

/**
 * c用户信息相关接口
 * @author tankai
 */
@Service
public class CustomerServiceImpl implements CustomerService {
	
	private static Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	@Autowired
	private CustomerMapper customerMapper;

	@Override
	public Customer queryCustomerByPhone(String phone) {
		CustomerExample example = new CustomerExample();
		CustomerExample.Criteria hoCriteria = example.createCriteria();
		hoCriteria.andPhoneEqualTo(phone);
		List<Customer> models =  customerMapper.selectByExample( example);
		if(CollectionUtils.isNotEmpty(models)){
			return models.get(0);
		}
		return null;
	}

	@Override
	public List<Customer> queryCustomers(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer queryCustomerByLoginName(String loginName) {

		CustomerExample example = new CustomerExample();
		CustomerExample.Criteria hoCriteria = example.createCriteria();
		hoCriteria.andLoginNameEqualTo(loginName);
		List<Customer> models =  customerMapper.selectByExample( example);
		if(CollectionUtils.isNotEmpty(models)){
			return models.get(0);
		}
		return null;
	
	}

}
