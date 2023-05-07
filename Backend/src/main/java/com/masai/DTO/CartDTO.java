package com.masai.DTO;

import java.util.ArrayList;
import java.util.List;

import com.masai.Model.Product;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class CartDTO {
	private Long UserId;
	private Long cartId;
	private Double grandTotal,total;
	private List<Product> listProduct = new ArrayList<>();
	private Integer productCount;
	public CartDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
