package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.masai.Model.Customer;
import com.masai.Model.User;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

	public boolean existsByUserName(String userName);
	
	public Customer findByUserName(String userName);
	
	
}
