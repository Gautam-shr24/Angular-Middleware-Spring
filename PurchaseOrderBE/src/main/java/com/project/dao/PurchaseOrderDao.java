package com.project.dao;

import java.util.List;

import com.project.model.PurchaseOrder;

public interface PurchaseOrderDao {
	
	public boolean addPO(PurchaseOrder POobj);
	public List<PurchaseOrder> viewAllOrders();
	


}
