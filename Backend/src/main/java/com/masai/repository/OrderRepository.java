package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.masai.Model.Orders;

public interface OrderRepository extends JpaRepository<Orders, Integer> {

	@Query("Select o from Orders o WHERE o.orderId=:id AND o.customer.userId=:id2")
	public Orders getOrder(@Param("id2") Long customerId,@Param("id") Integer orderId);
}
