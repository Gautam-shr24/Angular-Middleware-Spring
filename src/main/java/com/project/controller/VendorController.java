package com.project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.project.dao.VendorProductDao;
import com.project.model.User;
import com.project.model.VendorProduct;

@RestController
@CrossOrigin("http://localhost:4200")
public class VendorController {
	
	@Autowired
	VendorProductDao vendorDaoObj;
	
	@Autowired
	HttpSession session;

		@RequestMapping(value="/updateProductQuantity",method=RequestMethod.POST)
		public ModelAndView addInVendorproductTable(@RequestParam int pId  , @RequestParam int quantity)
		{
			User userObj=(User)session.getAttribute("userObj");	
			VendorProduct r=vendorDaoObj.checkProductForVendor(userObj.getUserId(), pId); 
			if(r!=null) {
				r.setQuantity(r.getQuantity()+quantity);      
			}
			else {
				r = new VendorProduct();			
				r.setVendorId(userObj.getUserId());
				r.setProductId(pId);
				r.setQuantity(quantity);
			}
			
			vendorDaoObj.add(r);                    
			
			ModelAndView mv=new ModelAndView("VendorPage");
			mv.addObject("msg","Product Quantity Added Succesfully");
			return mv;
		}


}
