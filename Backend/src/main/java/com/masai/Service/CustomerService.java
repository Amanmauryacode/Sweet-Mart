package com.masai.Service;

import java.util.List;

import com.masai.Exceptions.CustomerException;
import com.masai.Model.Customer;

public interface CustomerService {

	public Customer AddCustomer(Customer customer)throws CustomerException;

	public Customer UpdateCustomer(Customer customer)throws CustomerException;

	public Customer DeleteCustomer(Integer customerId)throws CustomerException;

	public List<Customer> ShowAllCustomers()throws CustomerException;

	public List<Customer> ShowAllCustomerById(Integer customerId)throws CustomerException;
}
