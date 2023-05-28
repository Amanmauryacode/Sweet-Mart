package com.masai.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exceptions.CustomerException;
import com.masai.Model.Customer;
import com.masai.Service.CustomerService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin("*")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping("/customers")
	public ResponseEntity<Customer> SaveCustomers( @Valid @RequestBody Customer customer) throws CustomerException {

		Customer c = customerService.AddCustomer(customer);
		return new ResponseEntity<>(c, HttpStatus.CREATED);

	}
	
	@PutMapping("/customers/{key}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable("key") String key ,@RequestBody Customer customer) throws CustomerException{
		
		customer= customerService.UpdateCustomer(key,customer);
		return new ResponseEntity<>(customer,HttpStatus.ACCEPTED);
	}

	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> allListOfCustomer() throws CustomerException {
		List<Customer> list = customerService.ShowAllCustomers();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@DeleteMapping("/customers/{userId}")
	public ResponseEntity<Customer> deleteEntity(@PathVariable Long userId) throws CustomerException {

		Customer customer = customerService.DeleteCustomer( userId);

		return new ResponseEntity<>(customer, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/customers/{userName}")
	public ResponseEntity< Customer> getCustomerByUserNames(@PathVariable String userName) throws CustomerException{
	
		Customer customer= customerService.ShowCustomerByUserNamer(userName);
		return new ResponseEntity<>(customer,HttpStatus.OK);
	}
	
	@GetMapping("/customers/id/{key}")
	public ResponseEntity<Customer> getCustomerByUuid(@Valid @PathVariable  String key) throws CustomerException{
		Customer customer = customerService.getCustomerById(key);
		return new ResponseEntity<>(customer, HttpStatus.ACCEPTED);
	}
	
	

}
