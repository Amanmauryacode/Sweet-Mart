package com.masai.Service;

import java.util.List;

import com.masai.Exceptions.CustomerException;
import com.masai.Exceptions.OrderException;
import com.masai.Model.Orders;

public interface OrderService {
	public Orders addOrder(Long customerId, Orders order) throws CustomerException, OrderException;

	public Orders updateOrder(Integer orderId, Orders order) throws CustomerException, OrderException;

	public Orders cancelOrder(Integer orderId) throws OrderException;

	public List<Orders> getAllOrder(Long id) throws OrderException;
}
