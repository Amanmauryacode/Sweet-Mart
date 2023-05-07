package com.masai.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exceptions.CategoryException;
import com.masai.Exceptions.ProductException;
import com.masai.Model.Category;
import com.masai.Model.Product;
import com.masai.repository.CategoryRepository;
import com.masai.repository.CustomerRepository;
import com.masai.repository.ProductRepository;
import com.masai.repository.UserRepository;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	public CategoryRepository categoryrepository;
	@Autowired
	public CustomerRepository customerrepository;
	@Autowired
	public ProductRepository productrepository;
	@Autowired
	public UserRepository userrepository;
	
	

	@Override
	public Product addProduct(Integer categoryId,Product product) throws ProductException, CategoryException {
	
		Optional<Category> opt =categoryrepository.findById(categoryId);
		if(opt.isEmpty())throw new CategoryException("Category Not found");
		
		Category c = opt.get();
		c.getProducts().add(product);
		product.setCategory(c);
        try {
            return productrepository.save(product);
        } catch (Exception e) {
            throw new ProductException("Failed to add product: " + e.getMessage());
        }
	}

	@Override
	public Product updateProduct(Product product,Integer productId) throws ProductException {
	
		Optional<Product> opt = productrepository.findById(productId);
		if(opt.isEmpty()) throw new ProductException("Product not found with id: " + productId);
		return productrepository.save(product);
		
		
	}

	@Override
	public Product cancelProduct(Integer productId) throws ProductException {
		 try {
	            Optional<Product> productOptional = productrepository.findById(productId);
	            if (!productOptional.isPresent()) {
	                throw new ProductException("Product not found with id: " + productId);
	            }
	            Product product = productOptional.get();
	            product.setAvailable(true);
	            productrepository.delete(product);
	            return product;
	        } catch (Exception e) {
	            throw new ProductException("Failed to cancel product: " + e.getMessage());
	        }
	}

	@Override
	public List<Product> showAllProductsByProductId(Integer productId) throws ProductException {
		 try {
	            return productrepository.findAllByProductId(productId);
	        } catch (Exception e) {
	            throw new ProductException("Failed to fetch products by id: " + e.getMessage());
	        }
	}

	@Override
	public List<Product> showAllProducts() throws ProductException {
	    try {
            return productrepository.findAll();
        } catch (Exception e) {
            throw new ProductException("Failed to fetch all products: " + e.getMessage());
        }
	}

}
