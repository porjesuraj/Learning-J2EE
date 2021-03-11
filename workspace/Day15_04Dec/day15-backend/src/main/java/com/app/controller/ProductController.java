package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Product;
import com.app.service.IProductService;

@RestController // @Controller + @ResponseBody 
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private IProductService productService;
	
	public ProductController() {
	System.out.println("in contr of " + getClass().getName());
		// TODO Auto-generated constructor stub
	}
	
	// add a req handling method to return representation of list of availabe products 
	
	/*
	 * @GetMapping public List<Product> fetchAllProducts() {
	 * System.out.println(" in fetch all products"); return
	 * productService.getAllProducts(); }
	 */
	
	
	
	@GetMapping 
	public ResponseEntity<?> fetchAllProducts()
	{
		System.out.println(" in fetch all products");
		
		List<Product> products = productService.getAllProducts();
		// check if empty
		if(products.isEmpty())
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		// non empty list
		
		return new ResponseEntity<>(products,HttpStatus.OK); 
		
	}
	
	// add a req handling method to return representation of selected product by Id OR in case of invalid Id SC : 404
	
	@GetMapping("/{pid}")
	public ResponseEntity<?> getProductDetails(@PathVariable int pid)
	{
		System.out.println(" in get product details : " + pid);
		 
		try {
			
		 return ResponseEntity.ok(productService.getProductDetails(pid))  ;
	  
			  
		} catch (RuntimeException e) {
			
			System.out.println("err in controller " + e);
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
		}
		
		
		
	}
	
	
	
}
