package com.project.daoImpl;

import java.util.List;

import com.project.dao.ProductDao;
import com.project.model.Product;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Repository("productDao")
@Transactional
public class ProductDaoImpl implements ProductDao {

		
		@Autowired
		SessionFactory sessionFactory;

		public boolean addProduct(Product productObj) {
				try {
					Session session = sessionFactory.getCurrentSession();
					
					session.saveOrUpdate(productObj);
					return true;
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			return false;
		}

		public List<Product> viewAllProducts() {
			try {
				Session session = sessionFactory.getCurrentSession();
				Query query = session.createQuery("from com.project.model.Product");
				List<Product> productList = query.list();
				return productList;
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				return null;
				
		}
		
	   
	    public boolean deleteProduct(Product productObj) {
	                    try {
	                                    Session session = sessionFactory.getCurrentSession();
	                                    session.delete(productObj);
	                                    return true;
	                    } catch (Exception e) {
	                                    e.printStackTrace();

	                    }

	                    return false;
	    }

	    public boolean updateProduct(Product productObj) {
	        try {
	                        Session session = sessionFactory.getCurrentSession();
	                        session.update(productObj);
	                        return true;
	        } catch (Exception e) {
	                        e.printStackTrace();

	        }

	        return false;
	    }

	 
	    public Product getProductByName(String productName) {
	        try {
	            Session session=sessionFactory.getCurrentSession();
	            Product pro=session.get(Product.class,productName);
	            return pro;
	            }
	            catch(Exception e) {
	                e.printStackTrace();
	            }
	        return null;
	    }

		public Product getProductById(int productId) {
			
			try {
				Session session=sessionFactory.getCurrentSession();
				Product product=session.get(Product.class,productId);
				return product;
				}
				catch(Exception e){
					e.printStackTrace(); 
				}
				return null;
		}

	}

