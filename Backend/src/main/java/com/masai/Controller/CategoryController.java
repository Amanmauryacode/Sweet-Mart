package com.masai.Controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exceptions.CategoryException;
import com.masai.Model.Category;
import com.masai.Model.Product;
import com.masai.Service.CategoryService;

import jakarta.validation.Valid;

@RestController
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/categorys")
	public ResponseEntity<Category> addCategoryHandler(@Valid @RequestBody Category category) throws CategoryException{
		
		Category addCat = categoryService.addCategory(category);
		
		return new ResponseEntity<>(addCat,HttpStatus.CREATED);
	}
	@PutMapping("/categorys/update/{categoryId}")
	public ResponseEntity<Category> updateCategoryHandeler(@Valid @PathVariable Integer categoryId, @RequestBody Category category) throws CategoryException{
		
		Category updateCat = categoryService.updateCategory(categoryId, category);
		
		return new ResponseEntity<>(updateCat,HttpStatus.OK);
	}
	@DeleteMapping("/categorys/cancel/{categoryId}")
	public ResponseEntity<Category> cancelCategoryHandler(@Valid Integer categoryId) throws CategoryException {
		
		Category cancelCat = categoryService.cancelCategory(categoryId);
		
		return new ResponseEntity<>(cancelCat,HttpStatus.OK);

	}
	@GetMapping("/categorys/all")
    public ResponseEntity<List<Category>> showAllCategorysHandler() throws CategoryException {
		
    	List<Category> showAllCat = categoryService.showAllCategorys();
    	
		return new ResponseEntity<>(showAllCat,HttpStatus.OK);

		
	}
    @GetMapping("/category/calulatecost/{categoryId}")
    public double calculateTotalCostHandler(@Valid @PathVariable Integer categoryId) throws CategoryException {
		
		double calulatetotal = categoryService.calculateTotalCost(categoryId);
		
		return calulatetotal;
	}



}
