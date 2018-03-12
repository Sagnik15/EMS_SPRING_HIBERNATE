package ems.dao;


import java.sql.ResultSet;
import java.util.Iterator;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import ems.beans.BatchBean;
import ems.beans.MedicineBean;




public class SearchDao {

private	HibernateTemplate hibernateTemplate;

public HibernateTemplate getHibernateTemplate() {
	return hibernateTemplate;
}
public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
	this.hibernateTemplate = hibernateTemplate;
}
	
	public  List<BatchBean> searchMedbyName() {
		
		
	//	List<BatchBean> l = hibernateTemplate.find("select b.medId, b.medName,b.medPrice,b.supplierId,b.supplierName,b.arrivalDate, b.expiryDate, b.quantity from MedicineBean m, BatchBean b where m.medId = b.medId ORDER BY b.expiryDate");
		List<BatchBean> l2 = hibernateTemplate.find("from BatchBean b order by b.expiryDate");
		System.out.println("data fetched from database");
		System.out.println(l2);
		
		
		return l2;
			

	}
	public  List getMed() {

       List gtmed =     hibernateTemplate.find("from MedicineBean");     
		
		return gtmed;
	}
	public String addMed(MedicineBean mb) {


		hibernateTemplate.save(mb);
		
		return "insert successfull !";
	}

}
