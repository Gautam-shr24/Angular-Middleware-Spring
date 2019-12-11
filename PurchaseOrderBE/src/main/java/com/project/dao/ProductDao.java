package com.project.dao;

import java.util.List;

import com.project.model.Product;

public interface ProductDao {
	
	public boolean addProduct(Product productObj);
	public List<Product> viewAllProducts();
	public boolean deleteProduct(Product productObj);
	public Product getProductByName(String productName);
	public boolean updateProduct(Product productObj);
	public Product getProductById(int productId);

}
