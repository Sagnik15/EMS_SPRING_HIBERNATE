package ems.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;

import ems.beans.MedicineBean;


import ems.beans.BatchBean;
import ems.beans.CartService;

public class BillingDao {

	HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public void updateQuant(CartService cs2) {

		ArrayList arr = cs2.getIt();
		Iterator itr = arr.iterator();
		while (itr.hasNext()) {
			BatchBean mb = (BatchBean) itr.next();
			int quant = mb.getQuantity();
			String bid = mb.getBatchId();
			
		
			
			
		Session session=hibernateTemplate.getSessionFactory().openSession();
		String hql = "UPDATE BatchBean set quantity = quantity -  :q "  + 
		            "WHERE BatchId = :id";
		Query query = session.createQuery(hql);
		query.setParameter("q", quant);
		query.setParameter("id", bid);
		int result = query.executeUpdate();
		System.out.println("Rows affected: " + result);
	
		
		}
		
		
		
	
		System.out.println("update successfull");

	}

	
	

	
	
}
