package com.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="Table_VendorProject")
public class VendorProduct {
	
	@Id
	@GeneratedValue
	private int id;
	
	private int vendorId;           //from user table
	
	private int productId;      //from product table
	
	private int quantity;
	
	@OneToOne
	@JoinColumn(name="productId",insertable=false,updatable=false)
	Product productObj;
	
	
	
	public int getVendorId() {
		return vendorId;
	}
	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "VendorProduct [id=" + id + ", vendorId=" + vendorId + ", productId=" + productId + ", quantity="
				+ quantity + "]";
	}
	public Product getProductObj() {
		return productObj;
	}
	public void setProductObj(Product productObj) {
		this.productObj = productObj;
	}
	
	
	

}
