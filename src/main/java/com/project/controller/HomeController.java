package com.project.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.dao.ProductDao;
import com.project.dao.PurchaseOrderDao;
import com.project.dao.UserDao;
import com.project.model.POItems;
import com.project.model.Product;
import com.project.model.PurchaseOrder;
import com.project.model.User;
import com.project.service.ProductService;
import com.project.service.PurchaseOrderService;
import com.project.service.UserService;

@RestController
@CrossOrigin("http://localhost:4200")
public class HomeController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	User user; 
	
	//==========For Registration=========
	@PostMapping(value="/user")
	public ResponseEntity<?> addPerson(@RequestBody(required=false)  User uObj)
	{
		
		boolean b = userService.addUser(uObj);
		if(b) {		
			return new ResponseEntity<String>("User Added",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Problem in adding user ",HttpStatus.INTERNAL_SERVER_ERROR);
	
		}
	}
	
	
	//==========For Login=============
	@ResponseBody
	@RequestMapping(value="/uservalidate",method=RequestMethod.POST)
	public ResponseEntity<?> validateUser(@RequestParam(name="userEmail") String userEmail,@RequestParam(name="userPass") String userPass,ModelMap map)
    {
	
            User u = userService.validateUser(userEmail,userPass);
            
            if(u!=null) {
            	
            	session.setAttribute("userObj", u);
            	System.out.println("Has set the object in session : "+session.getAttribute("userObj"));
            
			return new ResponseEntity<User>(u,HttpStatus.OK);
            }
            else
            System.out.println(u);
			return new ResponseEntity<String>("Problem in adding user ",HttpStatus.BAD_REQUEST);
           
    }
	
	
	@Autowired
	ProductService proService;
	//========To View all Products==========
	@GetMapping("/viewAllProducts")
	public ResponseEntity<?> viewAllProducts() {
		//System.out.println("Has set the object in session : "+session.getAttribute("userObj"));
		List<Product> list =  proService.viewAllProducts();
		if(list.size()!=0)
		{
			return new ResponseEntity<List<Product>>(list,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("List empty",HttpStatus.OK);	
		}
	}
	
	@Autowired
	ProductDao productDao;

	@ResponseBody
	@RequestMapping(value="/getProductNameById",method=RequestMethod.GET)
	public Product getProductById(@RequestParam int productId) {
		
		Product pObj=productDao.getProductById(productId);
		return pObj;
	}
	
	@Autowired
	HttpSession session;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	PurchaseOrderService poService;
	
	@Autowired 
	PurchaseOrderDao poDao;
	
	//======to add value in PO========
	
	@PostMapping(value="/purchaseOrder/{buyerId}")
	public ResponseEntity<?> raisePurchaseOrder(@PathVariable int buyerId,@RequestBody List<POItems> poItemsList) {
		
		
		System.out.println("Buyer Id : "+buyerId);
		
		for(POItems obj:poItemsList) {
			System.out.println(obj);
		}
		
		PurchaseOrder poObj=new PurchaseOrder();
		poObj.setBuyerObj(userDao.gettingBuyer(buyerId));
		poObj.setSellerObj(userDao.gettingSeller());
		poObj.setStatus("Sent to Seller");
		
		for(POItems obj:poItemsList) {
		
			obj.setProductObj(productDao.getProductById(obj.getProductId()));
			obj.setPurchaseOrderObj(poObj);
		}
		poObj.setPoItemsObj(poItemsList);		
		
		poDao.addPO(poObj);
		 if(poObj!=null) {
			 	return new ResponseEntity<PurchaseOrder>(poObj,HttpStatus.OK);
		 }
		 else
		 
			 return new ResponseEntity<String>("Problem in raising request",HttpStatus.INTERNAL_SERVER_ERROR);
		
		
	}
	
	@RequestMapping(value="viewPOS",method=RequestMethod.GET)
	public  ResponseEntity<?>  getAllUsers()
	{
		
		List<PurchaseOrder> list = poDao.viewAllOrders();
		if(list.size()!=0)
		{
			return new ResponseEntity<List<PurchaseOrder>>(list,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("List empty",HttpStatus.OK);	
		}
		
	}
	

}
