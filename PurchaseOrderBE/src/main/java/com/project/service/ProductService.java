package com.project.service;

import java.util.List;

import com.project.model.Product;

public interface ProductService {
	
	public boolean addProduct(Product productObj);
	public List<Product> viewAllProducts();
	public boolean deleteProduct(Product productObj);
	//public Product getProductByName(String productName);
	public boolean updateProduct(Product productObj);

}
