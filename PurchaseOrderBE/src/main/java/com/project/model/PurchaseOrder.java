package com.project.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Component
@Entity
@Table(name="PurchaseOrder_Table")
public class PurchaseOrder {

	@Id
	@GeneratedValue
	@Column(name="Po_id")
	private int purchaseOrderId;
	
	@ManyToOne
	@JoinColumn(name="buyer_Id")
	@JsonIgnore
	private User buyerObj;
	
	@ManyToOne
	@JoinColumn(name="seller_Id")
	@JsonIgnore
	private User sellerObj;
	
	@OneToMany(mappedBy="purchaseOrderObj",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JsonIgnore
	private List<POItems> poItemsObj;

	private String status;

	public int getPurchaseOrderId() {
		return purchaseOrderId;
	}

	public void setPurchaseOrderId(int purchaseOrderId) {
		this.purchaseOrderId = purchaseOrderId;
	}

	public User getBuyerObj() {
		return buyerObj;
	}

	public void setBuyerObj(User buyerObj) {
		this.buyerObj = buyerObj;
	}

	public User getSellerObj() {
		return sellerObj;
	}

	public void setSellerObj(User sellerObj) {
		this.sellerObj = sellerObj;
	}

	public List<POItems> getPoItemsObj() {
		return poItemsObj;
	}

	public void setPoItemsObj(List<POItems> poItemsObj) {
		this.poItemsObj = poItemsObj;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "PurchaseOrder [purchaseOrderId=" + purchaseOrderId + ", buyerObj=" + buyerObj + ", sellerObj="
				+ sellerObj + ", poItemsObj=" + poItemsObj + ", status=" + status + "]";
	}



	
	
}
