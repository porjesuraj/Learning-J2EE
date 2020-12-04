package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.ProductNotFoundException;
import com.app.dao.ProductRepository;
import com.app.pojos.Product;
@Service 
@Transactional // optional since it is already added on JpaRepository 
public class ProductServiceImpl implements IProductService {

	// dependency 
	
	@Autowired
	private ProductRepository productRepo; 
	
	
	@Override
	public List<Product> getAllProducts() {
		
		
		return productRepo.findAll();
	}


	@Override
	public Product getProductDetails(int ProductId) {
		
	          Optional<Product> optionalProduct = productRepo.findById(ProductId); 
	          
	          if(optionalProduct.isPresent())
	        	  return optionalProduct.get(); 
	          
	  // if product is not found : throw custom exception 
	          throw new ProductNotFoundException("Product not found : Invalid ID : " + ProductId);
	}

}
