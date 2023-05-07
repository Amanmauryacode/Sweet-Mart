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
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exceptions.CategoryException;
import com.masai.Exceptions.ProductException;
import com.masai.Model.Product;
import com.masai.Service.ProductService;
import jakarta.validation.Valid;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
    @PostMapping("/products/{categoryId}")
	public ResponseEntity<Product> addProductHandeler(@Valid @PathVariable Integer categoryId, @RequestBody Product product) throws ProductException, CategoryException {
	
    	Product addPro = productService.addProduct(categoryId,product);
		
		return new ResponseEntity<>(addPro,HttpStatus.CREATED);
	}

    @PutMapping("/updateproducts/{productId}")
	public ResponseEntity<Product> updateProductHandeler(@Valid @RequestBody Product product, @PathVariable Integer productId) throws ProductException {
		 
    	Product updatePro = productService.updateProduct(product, productId);
		
		return new ResponseEntity<>(updatePro,HttpStatus.OK);
	}

    @DeleteMapping("/deleteproducts/{productId}")
	public ResponseEntity<Product> cancelProductHandeler(Integer productId) throws ProductException {
		 
        Product cancelPro = productService.cancelProduct(productId);
		
		return new ResponseEntity<>(cancelPro,HttpStatus.OK);
	}

    @GetMapping("/getproducts/{productId}")
	public ResponseEntity<List<Product>> showAllProductsByProductIdHandeler(Integer productId) throws ProductException {
		 
    	List<Product> showALLPro = productService.showAllProductsByProductId(productId);
    	
    	return new ResponseEntity<>(showALLPro,HttpStatus.OK);
    	
	}

    @GetMapping("/getproductdetails")
	public ResponseEntity<List<Product>> showAllProductsHandeler() throws ProductException {
	    
    	List<Product> showALLProDetails = productService.showAllProducts();
    	
    	return new ResponseEntity<>(showALLProDetails,HttpStatus.OK);
    	
	}

}
