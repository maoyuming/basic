package com.duantuke.basic.face.service;

import java.util.List;

import com.duantuke.basic.po.Customer;

public interface CustomerService {
	
	public Customer queryCustomerByPhone(String phone);
	
	public Customer queryCustomerByLoginName(String loginName);
	
	public List<Customer> queryCustomers(Customer customer);
}
