package com.project.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.ProductDao;
import com.project.model.Product;
import com.project.service.ProductService;

@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductDao productdao;
	

	public boolean addProduct(Product productObj) {
		
		return productdao.addProduct(productObj);
	}

	public List<Product> viewAllProducts() {
		
		return productdao.viewAllProducts();
	}

	public boolean deleteProduct(Product productObj) {
		
		return productdao.deleteProduct(productObj);
	}

	

	public boolean updateProduct(Product productObj) {
		
		return productdao.updateProduct(productObj);
	}
	

}
