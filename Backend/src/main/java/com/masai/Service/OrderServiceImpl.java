package com.masai.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exceptions.CustomerException;
import com.masai.Exceptions.OrderException;
import com.masai.Model.Customer;
import com.masai.Model.Orders;
import com.masai.repository.CustomerRepository;
import com.masai.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepo;

	@Autowired
	private CustomerRepository customerRepo;

	@Override
	public Orders addOrder(Long customerId, Orders order) throws CustomerException, OrderException {

		Optional<Customer> opt = customerRepo.findById(customerId);

		if (opt.isEmpty())
			throw new CustomerException("Customer Data Not Found With Id " + customerId);

		Customer customer = opt.get();
		customer.getOrders().add(order);
		order.setCustomer(customer);
		order.setCreatedDate(LocalDate.now());

		// Here we Have to create Order bill And set to order;
		return orderRepo.save(order);
	}

	@Override
	public Orders updateOrder(Integer orderId, Orders order) throws CustomerException, OrderException {
		// TODO Auto-generated method stub
		Optional<Orders> opt = orderRepo.findById(orderId);
		if (opt.isEmpty())
			throw new OrderException("NO order Found");
		Orders o = opt.get();
		o.setItems(order.getItems());
		o.setGroupProduct(order.getGroupProduct());
		o.setCreatedDate(LocalDate.now());
		// Here we Have to create Order bill And set to order;
		return orderRepo.save(o);
	}

	@Override
	public Orders cancelOrder(Integer orderId) throws OrderException {
		// TODO Auto-generated method stub

		Optional<Orders> opt = orderRepo.findById(orderId);
		if (opt.isEmpty())
			throw new OrderException("No order found with id " + orderId);

		orderRepo.delete(opt.get());
		return opt.get();
	}

	@Override
	public List<Orders> getAllOrder(Long id) throws OrderException {

		// Here We need to check for permission (User is Admin or not);

		List<Orders> list = orderRepo.findAll();

		if (list.isEmpty())
			throw new OrderException("No order found in record");
		return list;
	}

}
