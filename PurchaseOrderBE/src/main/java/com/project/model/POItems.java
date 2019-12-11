package com.project.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Component
@Entity
@Table(name="PO_Items")
public class POItems {
	
	@Id
	@GeneratedValue
	private int purchaseOrderItemId;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="productId")
	@JsonIgnore
	private Product productObj;
	
	private int quantity;
	
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="purchaseOrderId")
	@JsonIgnore
	private PurchaseOrder purchaseOrderObj;
	
	@Transient
	private int productId;
	
	@Transient
	private String productName;

	public int getPurchaseOrderItemId() {
		return purchaseOrderItemId;
	}

	public void setPurchaseOrderItemId(int purchaseOrderItemId) {
		this.purchaseOrderItemId = purchaseOrderItemId;
	}

	public Product getProductObj() {
		return productObj;
	}

	public void setProductObj(Product productObj) {
		this.productObj = productObj;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public PurchaseOrder getPurchaseOrderObj() {
		return purchaseOrderObj;
	}

	public void setPurchaseOrderObj(PurchaseOrder purchaseOrderObj) {
		this.purchaseOrderObj = purchaseOrderObj;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Override
	public String toString() {
		return "POItems [purchaseOrderItemId=" + purchaseOrderItemId + ", productObj=" + productObj + ", quantity="
				+ quantity + ", purchaseOrderObj=" + purchaseOrderObj + ", productId=" + productId + ", productName="
				+ productName + "]";
	}

	
}
