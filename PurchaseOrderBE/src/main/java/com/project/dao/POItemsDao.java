package com.project.dao;

import java.util.List;

import com.project.model.POItems;

public interface POItemsDao {
	
	public List<POItems> getLineItemsById(int purchaseOrderId);

}
