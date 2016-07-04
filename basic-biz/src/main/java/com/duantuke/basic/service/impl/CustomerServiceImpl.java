package com.duantuke.basic.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duantuke.basic.face.base.RetInfo;
import com.duantuke.basic.face.service.CustomerService;
import com.duantuke.basic.mappers.CustomerMapper;
import com.duantuke.basic.po.Customer;
import com.duantuke.basic.po.CustomerExample;
import com.google.gson.Gson;

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

	@Override
	public RetInfo<Boolean> register(Customer customer) {

//		logger.info("注册新用户,老板={},销售={}",new Gson().toJson(boss),new Gson().toJson(sale));
		logger.info("注册新用户,c端={}",new Gson().toJson(customer));
		RetInfo<Boolean> info = new RetInfo<Boolean>();
		info.setResult(false);
		
		//check c端用户是否存在
		if(isExistCustomerByPhone(customer.getPhone())){
			customer.setUpdateuser(customer.getPhone());
			this.updateCustomer(customer);
			info.setMsg("c端手机号码已经存在");
			info.setResult(true);
			return info;
		}
		//保存老板信息
		int count=customerMapper.insertSelective(customer);
		if(count>0){
			info.setResult(true);
		}else{
			info.setMsg("保存c端信息失败");
		}
		return info;
	
	}
	
	

	/**
	 * 酒店C端用户是否存在
	 * @param phone
	 * @return
	 */
	public boolean isExistCustomerByPhone(String phone) {
		Customer customer = queryCustomerByPhone(phone);
		return customer==null?false:true;
	}

	/**
	 * 更新用户信息
	 */
	@Override
	public boolean updateCustomer(Customer customer) {
		Long customerId = customer.getCustomerId();
		if(customer.getCustomerId()==null){
			//根据手机号码查询出主键id
			Customer customer2 = this.queryCustomerByPhone(customer.getPhone());
			if(customer2!=null){
				customerId = customer2.getCustomerId();
			}else{
				return false;
			}
		}
		customer.setCustomerId(customerId);

		int count = customerMapper.updateByPrimaryKeySelective(customer);
		if(count>0){
			logger.info("更新用户信息成功,{}",new Gson().toJson(customer));
			return true;
		}
		return false;
	}

	@Override
	public Customer queryCustomerById(Long customerId) {
		return customerMapper.selectByPrimaryKey(customerId);
	}
	
	
	/**
	 * 更新或者新增customer数据
	 */
	@Override
	public RetInfo<Boolean> saveOrUpdateCustomers(Customer customer) {
		RetInfo<Boolean> retInfo = new RetInfo<Boolean>();
		retInfo.setResult(false);
		//if bossid not null
		if(customer!=null){
			if(customer.getCustomerId()!=null){
				//update by primary key
				customer.setUpdatetime(new Date());
				int count =  customerMapper.updateByPrimaryKeySelective(customer);
				if(count>0){
					retInfo.setResult(true);
				}
			}else if(StringUtils.isNotBlank(customer.getPhone())){
				//根据手机号码查询主键
				Customer customer2= this.queryCustomerByPhone(customer.getPhone());
				if(customer2!=null){
					customer.setCustomerId(customer2.getCustomerId());
					customer.setUpdatetime(new Date());
					
					int count =  customerMapper.updateByPrimaryKeySelective(customer);
					if(count>0){
						retInfo.setResult(true);
					}
				}else{//不存在插入酒店
					customer.setCreateuser(customer.getUpdateuser());
					customer.setCreatetime(new Date());
					customer.setUpdatetime(new Date());
					int count = 	customerMapper.insertSelective(customer);
					if(count>0){
						retInfo.setResult(true);
					}
				}
			}
		}
		return retInfo;
	}


}
