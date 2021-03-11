package com.app.service;

import java.util.List;

import com.app.pojos.Product;

public interface IProductService {

	// add a method to list all Products 
	List<Product> getAllProducts(); 
	
	// add a method to get specific product details by its id 
	Product getProductDetails(int ProductId);
}
