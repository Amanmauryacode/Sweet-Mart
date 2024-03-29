package com.masai.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exceptions.CustomerException;
import com.masai.Model.Cart;
import com.masai.Model.CurrentUserSession;
import com.masai.Model.Customer;
import com.masai.repository.CustomerRepository;
import com.masai.repository.SessionDao;
import com.masai.repository.UserRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepo;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private SessionDao sDao;

	@Override
	public Customer AddCustomer(Customer customer) throws CustomerException {

		Customer existingCustomer = customerRepo.findByUserName(customer.getUserName());
		if (existingCustomer != null)
			throw new CustomerException("Customer Already Registered with User Name");
		Cart cart = new Cart();
		customer.setCart(cart);
		return customerRepo.save(customer);

	}

	@Override
	public Customer UpdateCustomer(String key, Customer customer) throws CustomerException {
		CurrentUserSession loggedInUser = sDao.findByUuid(key);
		
		if (loggedInUser == null) {
			throw new CustomerException("Please provide a valid key to update a customer");
		}
		System.out.println(loggedInUser);
		if (customer.getUserId() == loggedInUser.getUserId()) {
			// If LoggedInUser id is same as the id of supplied Customer which we want to
			// update
			Optional<Customer> opt = customerRepo.findById(customer.getUserId());
			Customer c = opt.get();
			c.setUserName(customer.getUserName());
			if(customer.getPassword() != null)
				c.setPassword(customer.getPassword());

			return customerRepo.save(c);
		} else
			throw new CustomerException("Invalid Customer Details, please login first");

	}

	@Override
	public Customer DeleteCustomer(Long userID) throws CustomerException {
		Optional<Customer> optionalCustomer = customerRepo.findById(userID);
		Customer customer = optionalCustomer.orElseThrow(
				() -> new CustomerException("Customer with optionalCustomer " + userID + " does not exist"));
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
	public Customer ShowCustomerByUserNamer(String customername) throws CustomerException {

		Customer customers = customerRepo.findByUserName(customername);
		if (customers == null)
			throw new CustomerException("No customers found with name " + customername);
		return customers;
	}

	@Override
	public Customer getCustomerById(String key) throws CustomerException {
		CurrentUserSession loggedInUser = sDao.findByUuid(key);

		if (loggedInUser == null) {
			throw new CustomerException("Please provide a valid key to update a customer");
		}

		Optional<Customer> opt = customerRepo.findById(loggedInUser.getUserId());
		if (opt.isEmpty())
			throw new CustomerException("Invalid Customer !!");
		Customer customer = opt.get();

		return customer;

	}

}
