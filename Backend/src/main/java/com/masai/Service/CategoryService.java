package com.masai.Service;

import java.util.List;

import com.masai.Exceptions.CategoryException;
import com.masai.Model.Cart;
import com.masai.Model.Category;

public interface CategoryService {

	public Category addCategory(Category category) throws CategoryException;
	public Category updateCategory(Integer categoryId,Category category) throws CategoryException;
	public Category cancelCategory(Integer categoryId) throws CategoryException;
	public List<Category> showAllCategorys()throws CategoryException;
	public double calculateTotalCost(Integer categoryId)throws CategoryException;
		
}
