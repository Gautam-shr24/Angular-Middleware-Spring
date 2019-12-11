package com.project.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.ProductDao;
import com.project.dao.PurchaseOrderDao;
import com.project.dao.UserDao;
import com.project.model.POItems;
import com.project.model.PurchaseOrder;
import com.project.service.PurchaseOrderService;

@Service("purchaseOrderService")
@Transactional
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

	@Autowired
	UserDao userDao;
	
	@Autowired
	PurchaseOrder poObj;
	
	@Autowired
	PurchaseOrderDao poDao;
	
	
	
	@Override
	public boolean addPO(PurchaseOrder POobj) {
	
		poObj.setStatus("Sent to Seller");
		
		
		
		return poDao.addPO(POobj) ;
	}

}
