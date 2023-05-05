package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.Model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
