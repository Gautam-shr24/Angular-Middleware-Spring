package com.project.test;

import static org.junit.Assert.assertTrue;


import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.project.config.DBConfig;
import com.project.model.User;
import com.project.service.UserService;

public class TestClass {

	private static UserService buyerService;
	
	
	
	
	@BeforeClass
	public static void init() {
		
		try {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
		buyerService = context.getBean(UserService.class,"buyerService");
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("I m Init.....");
	}
	
	@Test
	@Ignore
	public void addUserTest()
	{
		User uObj = new User();
		uObj.setUserName("Divya");
		uObj.setUserAddress("Saharanpur");
		uObj.setUserEmail("d@gmail.com");
		uObj.setUserPhone(3456789012l);
		uObj.setUserPass("k123");
	
		
		boolean b = buyerService.addUser(uObj);
		
		assertTrue("Problem in adding product",b);
	}
}
