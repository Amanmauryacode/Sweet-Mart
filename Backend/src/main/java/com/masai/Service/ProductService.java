package com.masai.Service;

import java.util.List;

import com.masai.Exceptions.CategoryException;
import com.masai.Exceptions.ProductException;
import com.masai.Model.Product;

public interface ProductService {

	public Product addProduct(Integer categoryId,Product product) throws ProductException, CategoryException;
	public Product updateProduct(Product product,Integer productId) throws ProductException;
	public Product cancelProduct(Integer productId) throws ProductException;
	public List<Product> showAllProductsByProductId(Integer productId)throws ProductException;
	public List<Product> showAllProducts()throws ProductException;
	
}
