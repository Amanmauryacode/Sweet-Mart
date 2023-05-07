package com.masai.Service;

import java.util.List;

import com.masai.DTO.CartDTO;
import com.masai.Exceptions.CartException;
import com.masai.Exceptions.UserExceptions;
import com.masai.Model.Cart;

public interface CartService {
	public CartDTO addCart(Long id, Cart cart) throws CartException, UserExceptions;

	public CartDTO updateCart(Long id, Cart cart) throws CartException, UserExceptions;

	public Cart removeCart(Integer cartId) throws CartException;

	public List<CartDTO>  getAllCarts() throws CartException;

	public CartDTO getCartById(Integer cardId) throws CartException;
}
