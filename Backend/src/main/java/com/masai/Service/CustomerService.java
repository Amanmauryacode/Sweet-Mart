package com.masai.Service;

import java.util.List;

import com.masai.Exceptions.CustomerException;
import com.masai.Model.Customer;

public interface CustomerService {

	public Customer AddCustomer(Customer customer)throws CustomerException;

	public Customer UpdateCustomer(String key,Customer customer)throws CustomerException;

	public Customer DeleteCustomer(Long userID )throws CustomerException;

	public List<Customer> ShowAllCustomers()throws CustomerException;

	public Customer ShowCustomerByUserNamer(String customername)throws CustomerException;
	
	public Customer getCustomerById(String key)throws CustomerException;
	
//	public Customer updateCustomer(String userName, Customer customerDetails) throws CustomerException;
}
