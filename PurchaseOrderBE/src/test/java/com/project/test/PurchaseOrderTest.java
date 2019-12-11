package com.project.test;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.project.config.DBConfig;
import com.project.dao.PurchaseOrderDao;

public class PurchaseOrderTest {
	
	@Autowired
	private static PurchaseOrderDao purchaseorder;
	
	@BeforeClass
	public static void init() {

		try {
			
			AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
			purchaseorder  = context.getBean(PurchaseOrderDao.class, "purchaseorder");
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Test
	@Ignore
	public void addPurchaseOrderTest()
	{
		/*PurchaseOrder poObj = new PurchaseOrder();
		poObj.setBuyerId(101);
		poObj.setPoName("Firstorder");
		poObj.setProductId(101111);
		poObj.setQuantity(120);
		poObj.setCreatedDate(LocalDate.now());
		poObj.setStatus("pending");
		boolean b = purchaseorder.addPO(poObj);

		assertTrue("Problem in adding product", b);*/

	}
		

}
