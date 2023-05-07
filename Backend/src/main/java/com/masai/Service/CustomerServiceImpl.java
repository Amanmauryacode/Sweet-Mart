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
		if (customerRepo.existsByUserName(customer.getUserName())) {
			
			throw new CustomerException("Username already exists");
			
		} else if (!customer.getPassword().equals(customer.getConfirmedPassword())) {
			
			throw new CustomerException("Both Password should be Same ");
			
		}
		return customerRepo.save(customer);
	}

	@Override
	public Customer UpdateCustomer(String userName, Customer customerDetails) throws CustomerException {
		Optional<Customer> optionalCustomer = Optional.ofNullable(customerRepo.findByUserName(userName));
		Customer customer = optionalCustomer
				.orElseThrow(() -> new CustomerException("Customer with username " + userName + " not found."));

		if (customerDetails.getUserName() != null) {
			customer.setUserName(customerDetails.getUserName());
		}

		if (customerDetails.getPassword() != null) {
			customer.setPassword(customerDetails.getPassword());
		}

		if (customerDetails.getConfirmedPassword() != null) {
			customer.setConfirmedPassword(customerDetails.getConfirmedPassword());
		}
//		customer.setUserName(customerDetails.getUserName());
//		customer.setPassword(customerDetails.getPassword());
//		customer.setConfirmedPassword(customerDetails.getConfirmedPassword());
		return userRepository.save(customer);

	}

	@Override
	public Customer DeleteCustomer(String customername) throws CustomerException {
		Optional<Customer> optionalCustomer = Optional.ofNullable(customerRepo.findByUserName(customername));
		Customer customer = optionalCustomer
				.orElseThrow(() -> new CustomerException("Customer with username " + customername + " does not exist"));
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

//	@Override
//	public Customer updateCustomer(String userName, Customer customerDetails) throws CustomerException {
//		Optional<Customer> optionalCustomer = Optional.ofNullable(customerRepo.findByUserName(userName));
//		Customer customer = optionalCustomer
//				.orElseThrow(() -> new CustomerException("Customer with username " + userName + " does not exist"));
//		customer.setUserName(customerDetails.getUserName());
//		customer.setPassword(customerDetails.getPassword());
//		customer.setConfirmedPassword(customerDetails.getConfirmedPassword());
//		Customer updatedCustomer = customerRepo.save(customer);
//		return updatedCustomer;
//	}

	@Override
	public Customer ShowCustomerByUserNamer(String customername) throws CustomerException {
		Optional<Customer> optionalCustomer = Optional.ofNullable(customerRepo.findByUserName(customername));
		Customer customer = optionalCustomer
				.orElseThrow(() -> new CustomerException("Customer with username " + customername + " does not exist"));

		return customer;
	}

}
