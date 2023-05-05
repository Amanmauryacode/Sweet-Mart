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
		}

		return customerRepo.save(customer);
	}

	@Override
	public Customer UpdateCustomer(Customer customer) throws CustomerException {
		if (!customerRepo.existsByUserName(customer.getUserName())) {
			throw new CustomerException("Customer with id " + customer.getUserName() + " does not exist");
		}
		return userRepository.save(customer);

	}


	@Override
	public Customer DeleteCustomer(String customername) throws CustomerException {
	    Optional<Customer> optionalCustomer = Optional.ofNullable(customerRepo.findByUserName(customername));
	    Customer customer = optionalCustomer.orElseThrow(() -> new CustomerException("Customer with username " + customername + " does not exist"));
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
	public Customer ShowCustomerById(Integer customerId) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

}
