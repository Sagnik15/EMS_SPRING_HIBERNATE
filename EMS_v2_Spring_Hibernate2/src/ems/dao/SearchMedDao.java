package ems.dao;


import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

public class SearchMedDao {

	HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
	public List getMed() {

		
		List gtmed =     hibernateTemplate.find("from MedicineBean");     
		
		return gtmed;
		
		
		
		
	}

}
