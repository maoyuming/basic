package com.duantuke.basic.face.service;

import java.util.List;

import com.duantuke.basic.face.base.RetInfo;
import com.duantuke.basic.po.Customer;

public interface CustomerService {
	
	public Customer queryCustomerByPhone(String phone);
	
	public Customer queryCustomerById(Long customerId);
	
	public Customer queryCustomerByLoginName(String loginName);
	
	public List<Customer> queryCustomers(Customer customer);
	
	public boolean updateCustomer(Customer customer);
	
	/**
	 * 注册c端
	 * @param Boss
	 * @return
	 */
	public RetInfo<Boolean> register(Customer customer);
	
	public boolean isExistCustomerByPhone(String phone) ;
	
	public RetInfo<Boolean> saveOrUpdateCustomers(Customer customer) ;
}
