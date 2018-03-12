package ems.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.orm.hibernate3.HibernateTemplate;



import ems.beans.OrderBean;

public class PlaceOrderDao {

HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
	
	public void placeOrder(OrderBean ob) {

		//Integer quant  = ob.getQuantity();
		int quantity = ob.getQuantity();
		/*java.util.Date utilDate = new java.util.Date();
	    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		*/
		
		System.out.println("inside place order in admin dao");
		
		
		
		
		DateFormat sdf=new SimpleDateFormat("yyyy/mm/dd");
		
		//Date odate = ob.getOrderDate();
		//String odate = odate2.toString();
		String odate =ob.getOrderDate();
	//	String date = "2000-11-01";
	    java.sql.Date javaSqlDate = java.sql.Date.valueOf(odate);
		
				//Date d = Date.valueOf(sdf.format(odate));
		
		
		//java.sql.Date d1= (java.sql.Date) d.valueOf(d);
		
       
		
		//Date date = Date.valueOf(odate);
		
		

		System.out.println("inserting values to database");
		

		hibernateTemplate.save(ob);
		
		
		
		System.out.println("Insertion into table completed");
		
	}

}
