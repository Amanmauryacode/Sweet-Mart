package com.masai.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exceptions.CustomerException;
import com.masai.Model.Customer;
import com.masai.repository.CustomerRepository;
import com.masai.repository.UserRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepo;

	@Autowired
	private UserRepository userRepository;

	@Override
	public Customer AddCustomer(Customer customer) throws CustomerException {
		
		if(customer.getPassword().equals(customer.getConfirmedPassword())) {

			return customerRepo.save(customer);
		}
		throw new CustomerException("Password And Confirmed Password Must same ");
	}

	@Override
	public Customer UpdateCustomer(Long userID , Customer customerDetails) throws CustomerException {
		Optional<Customer> optionalCustomer = customerRepo.findById(userID);
		Customer customer = optionalCustomer
				.orElseThrow(() -> new CustomerException("Customer with Id " + userID + " not found."));

		if(customerDetails.getPassword().equals(customerDetails.getConfirmedPassword())) {
			return customerRepo.save(customer);
		}
		throw new CustomerException("Password And Confirmed Password Must same ");

	}

	@Override
	public Customer DeleteCustomer(Long userID ) throws CustomerException {
		Optional<Customer> optionalCustomer = customerRepo.findById(userID);
		Customer customer = optionalCustomer
				.orElseThrow(() -> new CustomerException("Customer with optionalCustomer " + userID + " does not exist"));
		customerRepo.delete(customer);
		return customer;
	}

	@Override
	public List<Customer> ShowAllCustomers() throws CustomerException {
		List<Customer> customers = customerRepo.findAll();
		if (customers.isEmpty()) {
			throw new CustomerException("No customers found");
		}
		return customers;
	}


	@Override
	public List<Customer> ShowCustomerByUserNamer(String customername) throws CustomerException {
		
		List<Customer> customers = customerRepo.findByUserName(customername);
		if(customers.isEmpty())throw new CustomerException("No customers found with name "+customername);
		return customers;
	}

	@Override
	public Customer getCustomerById(Long userId) throws CustomerException {
		Optional<Customer> opt = customerRepo.findById(userId);
		if(opt.isEmpty())throw new CustomerException("No customers found with Id "+userId);
		return opt.get();
	}
	
	

}
