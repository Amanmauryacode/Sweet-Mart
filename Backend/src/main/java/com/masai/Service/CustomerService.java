package com.masai.Service;

import java.util.List;

import com.masai.Exceptions.CustomerException;
import com.masai.Model.Customer;

public interface CustomerService {

	public Customer AddCustomer(Customer customer)throws CustomerException;

	public Customer UpdateCustomer(Long userID ,Customer customer)throws CustomerException;

	public Customer DeleteCustomer(Long userID )throws CustomerException;

	public List<Customer> ShowAllCustomers()throws CustomerException;

	public List<Customer> ShowCustomerByUserNamer(String customername)throws CustomerException;
	
	public Customer getCustomerById(Long userId)throws CustomerException;
	
//	public Customer updateCustomer(String userName, Customer customerDetails) throws CustomerException;
}
