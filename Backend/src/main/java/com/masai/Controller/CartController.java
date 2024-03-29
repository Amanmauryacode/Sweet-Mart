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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.DTO.CartDTO;
import com.masai.Exceptions.CartException;
import com.masai.Exceptions.UserExceptions;
import com.masai.Model.Cart;
import com.masai.Service.CartService;

@RestController
public class CartController {

	@Autowired
	private CartService cartService;

	@PostMapping("/carts")
	public ResponseEntity<CartDTO> addCart(@RequestParam("customerId") Long id, @RequestBody Cart cart)
			throws CartException, UserExceptions {

		CartDTO c = cartService.addCart(id, cart);

		return new ResponseEntity<>(c, HttpStatus.CREATED);

	}

	@PutMapping("/carts/{customerId}")
	public ResponseEntity<CartDTO> updateCart(@PathVariable("customerId") Long id, @RequestBody Cart cart)
			throws CartException, UserExceptions {

		CartDTO c = cartService.updateCart(id, cart);
		return new ResponseEntity<>(c, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/carts/delete/{cartId}")
	public ResponseEntity<Cart> deleteCart(@PathVariable("cartId") Integer id)
			throws CartException, UserExceptions {

		Cart c = cartService.removeCart(id);
		return new ResponseEntity<>(c, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/carts/All")
	public ResponseEntity<List<CartDTO>> getAllCart() throws CartException
			{

		List<CartDTO> c = cartService.getAllCarts();
		return new ResponseEntity<>(c, HttpStatus.OK);
	}
	
	@GetMapping("/carts")
	public ResponseEntity<CartDTO> getCartById(@RequestParam("cartId") Integer id) throws CartException
			 {

		CartDTO c = cartService.getCartById(id);

		return new ResponseEntity<>(c, HttpStatus.CREATED);

	}
	
}
