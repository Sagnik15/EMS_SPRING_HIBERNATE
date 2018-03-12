package ems.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

public class MedSearchDao {

	HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
	public List searchMed() {


		List l = hibernateTemplate.find("from BatchBean");
		
		
		return l;
	}

}
