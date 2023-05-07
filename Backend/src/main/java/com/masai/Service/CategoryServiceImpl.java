package com.masai.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exceptions.CategoryException;
import com.masai.Exceptions.ProductException;
import com.masai.Model.Cart;
import com.masai.Model.Category;
import com.masai.Model.Product;
import com.masai.repository.CategoryRepository;
import com.masai.repository.CustomerRepository;
import com.masai.repository.ProductRepository;
import com.masai.repository.UserRepository;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	public CategoryRepository categoryrepository;
	@Autowired
	public CustomerRepository customerrepository;
	@Autowired
	public ProductRepository productrepository;
	@Autowired
	public UserRepository userrepository;
	
	@Override
	public Category addCategory(Category category) throws CategoryException {
		
		List<Product> productList = category.getProducts();

		if(productList.isEmpty()) {
		    throw new CategoryException("No product for this category Available!!");
		}
		for(Product product : productList) {
		    product.setCategory(category);
		}
		category.setProducts(productList);
		return categoryrepository.save(category);
	}

	@Override
	public Category updateCategory(Integer categoryId,Category category) throws CategoryException {
		
		Optional<Category> cat = categoryrepository.findById(categoryId);
		
		List<Product> proList = category.getProducts();
		if(cat.isPresent()) {
			
			Category c = cat.get();
			c.setCatogeryName(category.getCatogeryName());
			c.setProducts(proList);
			
			return categoryrepository.save(c);
		}
		throw new CategoryException("Category not found for this Id: " + categoryId);		
	}

	@Override
	public Category cancelCategory(Integer categoryId) throws CategoryException {
		
		Optional<Category> cat = categoryrepository.findById(categoryId);
		
		if(cat.isPresent()) {
			Category category = cat.get();
			categoryrepository.delete(category);
			return category;
		}
		throw new CategoryException("Category not found for this Id: " + categoryId);
		
	}

	@Override
	public List<Category> showAllCategorys() throws CategoryException {
		
		List<Category> category = categoryrepository.findAll();
		if(category.isEmpty()) {
			throw new CategoryException("Failed to fetch all Categories");
		}
			return category;
		
	}

	@Override
	public double calculateTotalCost(Integer categoryId) throws CategoryException {
		
		
		Optional<Category> cat = categoryrepository.findById(categoryId);
		
		if(cat.isPresent()) {
			
			Category category = cat.get();
			List<Product> products = category.getProducts();
			double Sum = 0;
			for(Product pro:products) {
				Sum += pro.getPrice();
			}
			return Sum;
		}
		
		throw new CategoryException("Categories are not Available!!");		
	}
}
