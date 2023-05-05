package com.masai.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exceptions.CustomerException;
import com.masai.Model.Customer;
import com.masai.Service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping("/customers")
	public ResponseEntity<Customer> SaveCustomers(@RequestBody Customer customer) throws CustomerException {

		Customer c = customerService.AddCustomer(customer);
		return new ResponseEntity<>(c, HttpStatus.CREATED);

	}

	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> allListOfCustomer() throws CustomerException {
		List<Customer> list = customerService.ShowAllCustomers();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@DeleteMapping("/customers/{userName}")
	public ResponseEntity<Customer> deleteEntity(@PathVariable String userName) throws CustomerException {

		Customer customer = customerService.DeleteCustomer( userName);

		return new ResponseEntity<>(customer, HttpStatus.ACCEPTED);
	}

}
