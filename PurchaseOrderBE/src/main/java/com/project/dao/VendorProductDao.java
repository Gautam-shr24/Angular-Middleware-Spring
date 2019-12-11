package com.project.dao;

import java.util.List;

import com.project.model.Product;
import com.project.model.VendorProduct;

public interface VendorProductDao {
	
	public Product getProductById(int pId) ;
	public List<Product> getAllProducts(int id);
	public boolean add(VendorProduct vObj);
	public VendorProduct checkProductForVendor(int vendorId,int productId);


}
