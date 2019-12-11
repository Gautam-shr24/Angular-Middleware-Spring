package com.project.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.PurchaseOrderDao;
import com.project.model.PurchaseOrder;

@Repository("purchaseOrderDao")
@Transactional
public class PurchaseOrderDaoImpl implements PurchaseOrderDao {
	
	@Autowired
	SessionFactory sessionFactory;

	public boolean addPO(PurchaseOrder POobj) {
		try {
			Session session=sessionFactory.getCurrentSession();
	
			session.saveOrUpdate(POobj);
			return true;

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<PurchaseOrder> viewAllOrders() {
		try {
			Session session=sessionFactory.getCurrentSession();
			Query q=session.createQuery("from com.project.model.PurchaseOrder where status='Sent to Seller'");
	        return q.list();

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
