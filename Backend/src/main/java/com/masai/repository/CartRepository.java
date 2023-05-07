package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.Model.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {

}
