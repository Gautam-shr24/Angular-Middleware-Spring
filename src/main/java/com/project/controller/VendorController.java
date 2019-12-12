package com.project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.project.dao.VendorProductDao;
import com.project.model.PurchaseOrder;
import com.project.model.User;
import com.project.model.VendorProduct;

@RestController
@CrossOrigin("http://localhost:4200")
public class VendorController {
	
	@Autowired
	VendorProductDao vendorDaoObj;
	
	@Autowired
	HttpSession session;

		@RequestMapping(value="/updateProductQuantity",method=RequestMethod.GET)
		public ResponseEntity<?> addInVendorproductTable(@RequestParam(name="productId") int productId  , 
				@RequestParam(name="quantity") int quantity,@RequestParam(name="vendorId")int vendorId)
		{
			
			VendorProduct r=vendorDaoObj.checkProductForVendor(vendorId, productId); 
			if(r!=null) {
				r.setQuantity(r.getQuantity()+quantity);      
			}
			else {
				r = new VendorProduct();			
				r.setVendorId(vendorId);
				r.setProductId(productId);
				r.setQuantity(quantity);
			}
			
			boolean re=vendorDaoObj.add(r);                    
			
			 if(re) {
				 	return new ResponseEntity<Object>(r,HttpStatus.OK);
			 }
			 else
			 
				 return new ResponseEntity<String>("Problem in adding quantity",HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		
		


}
