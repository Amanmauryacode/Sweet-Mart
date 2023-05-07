package com.masai.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.DTO.CartDTO;
import com.masai.Exceptions.CartException;
import com.masai.Exceptions.UserExceptions;
import com.masai.Model.Cart;
import com.masai.Model.Customer;
import com.masai.repository.CartRepository;
import com.masai.repository.CustomerRepository;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepo;
	@Autowired
	private CustomerRepository customerRepo;

	@Override
	public CartDTO addCart(Long id, Cart cart) throws CartException, UserExceptions {
		Optional<Customer> opt = customerRepo.findById(id);
		if (opt.isEmpty())
			throw new UserExceptions("Customer Not Found With Id " + id);
		Customer c = opt.get();
		c.setCart(cart);
		cart.setCustomer(c);
		Cart ct = cartRepo.save(cart);
		CartDTO dto = new CartDTO();
		dto.setCartId(ct.getCartId());
		dto.setListProduct(ct.getListProduct());
		dto.setGrandTotal(ct.getGrandTotal());
		dto.setProductCount(ct.getProductCount());
		dto.setTotal(ct.getTotal());
		dto.setUserId(ct.getCustomer().getUserId());
		return dto;
	}

	@Override
	public CartDTO updateCart(Long id, Cart cart) throws CartException, UserExceptions {
		Optional<Customer> opt = customerRepo.findById(id);
		if (opt.isEmpty())
			throw new UserExceptions("Customer Not Found With Id " + id);
		Cart c = opt.get().getCart();
		c.setListProduct(cart.getListProduct());
		c.setGrandTotal(cart.getGrandTotal());
		c.setTotal(cart.getTotal());
		c.setProductCount(cart.getProductCount());

		Cart ct = cartRepo.save(cart);
		CartDTO dto = new CartDTO();
		dto.setCartId(ct.getCartId());
		dto.setListProduct(ct.getListProduct());
		dto.setGrandTotal(ct.getGrandTotal());
		dto.setProductCount(ct.getProductCount());
		dto.setTotal(ct.getTotal());
		dto.setUserId(ct.getCustomer().getUserId());
		return dto;
	}

	@Override
	public Cart removeCart(Integer cartId) throws CartException {

		Optional<Cart> opt = cartRepo.findById(cartId);

		if (opt.isEmpty())
			throw new CartException("Cart Not Found!");

		cartRepo.delete(opt.get());
		return opt.get();
	}

	@Override
	public List<CartDTO> getAllCarts() throws CartException {
		List<Cart> carts = cartRepo.findAll();
		if (carts.isEmpty())
			throw new CartException("Cart Not Found!");
		List<CartDTO> cartDto = new ArrayList<>();
		for (Cart c : carts) {
			Cart ct = c;
			CartDTO dto = new CartDTO();
			dto.setCartId(ct.getCartId());
			dto.setListProduct(ct.getListProduct());
			dto.setGrandTotal(ct.getGrandTotal());
			dto.setProductCount(ct.getProductCount());
			dto.setTotal(ct.getTotal());
			dto.setUserId(ct.getCustomer().getUserId());
			cartDto.add(dto);
		}
		return cartDto;
	}

	@Override
	public CartDTO getCartById(Integer cardId) throws CartException {
		Optional<Cart> opt = cartRepo.findById(cardId);
		if (opt.isEmpty())
			throw new CartException("Cart Not Found with Id " + cardId);
		Cart ct = opt.get();
		CartDTO dto = new CartDTO();
		dto.setCartId(ct.getCartId());
		dto.setListProduct(ct.getListProduct());
		dto.setGrandTotal(ct.getGrandTotal());
		dto.setProductCount(ct.getProductCount());
		dto.setTotal(ct.getTotal());
		dto.setUserId(ct.getCustomer().getUserId());
		return dto;
	}

}
