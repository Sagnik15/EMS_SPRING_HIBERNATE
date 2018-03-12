package ems.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;

import ems.beans.BatchBean;
import ems.beans.BatchBean2;

public class AdminDao {

	HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
	public List fetchUserDetails() {
		
		List fud = hibernateTemplate.find("from UserBean");
		
		return fud;
	}
	public void addToInventory(BatchBean2 bb) {
		// TODO Auto-generated method stub
		
		BatchBean batchB = new BatchBean();
		String arrDt = bb.getArrivalDate();
		String expDt = bb.getExpiryDate();
		java.sql.Date javaSqlDate = java.sql.Date.valueOf(arrDt);
		java.sql.Date javaSqlDate2 = java.sql.Date.valueOf(expDt);
		
		
		/*date = bb.getArrivalDate().*/
		batchB.setArrivalDate(javaSqlDate);
		batchB.setExpiryDate(javaSqlDate2);
		batchB.setBatchId(bb.getBatchId());
		batchB.setMedId(bb.getMedId());
		batchB.setMedName(bb.getMedName());
		batchB.setMedPrice(bb.getMedPrice());
		batchB.setQuantity(bb.getQuantity());
		batchB.setSupplierId(bb.getSupplierId());
		batchB.setSupplierName(bb.getSupplierName());
	
		
		System.out.println("inside add to inventory method of admin dao");
		hibernateTemplate.save(batchB);
		System.out.println("batch bean added");
	}
	public void removeMed(String batchId) {
		
		Session session=hibernateTemplate.getSessionFactory().openSession();
		Query query=session.createQuery("delete from BatchBean where  batchId=:i");
		query.setParameter("i", batchId);
		query.executeUpdate();
		
		
		System.out.println("deleted medicine successfulyy from batch base");
	
		
		
	}

}
