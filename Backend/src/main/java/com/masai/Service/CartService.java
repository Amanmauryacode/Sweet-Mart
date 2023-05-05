package com.masai.Service;

import java.util.List;

import com.masai.Exceptions.CartException;
import com.masai.Exceptions.UserExceptions;
import com.masai.Model.Cart;

public interface CartService {

	public Cart addCart(Long id,Cart cart) throws CartException,UserExceptions;
	
	public Cart updateCart(Long id,Cart cart) throws CartException,UserExceptions;
	
	public Cart removeCart(Integer cartId)throws CartException;
	
	public List<Cart> getAllCarts()throws CartException;
	
	public Cart getCartById(Integer cardId)throws CartException;
}
