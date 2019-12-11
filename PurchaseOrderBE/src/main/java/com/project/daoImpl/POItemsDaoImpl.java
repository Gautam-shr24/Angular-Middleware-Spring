package com.project.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.POItemsDao;
import com.project.model.POItems;
@Repository("poItemsDao")
@Transactional
public class POItemsDaoImpl implements POItemsDao {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<POItems> getLineItemsById(int purchaseOrderId) {
try {
			
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from com.project.model.POItems where purchaseOrderId=:x");
			query.setParameter("x", purchaseOrderId);
			List<POItems> list = query.list();
			return list;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
