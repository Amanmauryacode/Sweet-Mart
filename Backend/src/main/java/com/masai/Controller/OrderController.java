package com.masai.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exceptions.CustomerException;
import com.masai.Exceptions.OrderException;
import com.masai.Model.Orders;
import com.masai.Service.OrderService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@PostMapping("/orders")
	public ResponseEntity<Orders> createOrder(@Valid @RequestParam("customerId") Long id,@RequestBody Orders order) throws CustomerException, OrderException{
		
		Orders od = orderService.addOrder(id, order);
		return new ResponseEntity<>(od,HttpStatus.CREATED);
	}
	
	@PutMapping("/orders/customerId/{customerId}")
	public ResponseEntity<Orders> updateOrder(@Valid @PathVariable("customerId") Long cId,@RequestBody Orders orders) throws CustomerException, OrderException{
		Orders od = orderService.updateOrder(cId, orders);
		return new ResponseEntity<>(od,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/orders/delete/{id}")
	public ResponseEntity<Orders> cancelOrder(@Valid @PathVariable("id") Integer id) throws OrderException{
		Orders od = orderService.cancelOrder(id);
		return new ResponseEntity<>(od,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/orders/all")
	public ResponseEntity<List<Orders>> getAllOrders(@RequestParam("userId")Long userId) throws OrderException{
		
		List<Orders> orders = orderService.getAllOrder(userId);
		return new ResponseEntity<>(orders,HttpStatus.ACCEPTED);
	}
}
