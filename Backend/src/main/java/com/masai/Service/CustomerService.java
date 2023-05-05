package com.masai.Service;

import java.util.List;

import com.masai.Exceptions.CustomerException;
import com.masai.Model.Customer;

public interface CustomerService {

	public Customer AddCustomer(Customer customer)throws CustomerException;

	public Customer UpdateCustomer(Customer customer)throws CustomerException;

	public Customer DeleteCustomer(String userName)throws CustomerException;

	public List<Customer> ShowAllCustomers()throws CustomerException;

	public Customer ShowCustomerById(Integer customerId)throws CustomerException;
}
