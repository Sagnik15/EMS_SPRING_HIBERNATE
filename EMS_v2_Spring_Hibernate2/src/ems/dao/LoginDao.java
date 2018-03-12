package ems.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import ems.beans.LoginBean;

public class LoginDao {
private HibernateTemplate hibernateTemplate;
	
	
	public LoginDao() {
		// TODO Auto-generated constructor stub
	}
	
	
	public LoginDao(HibernateTemplate hibernateTemplate) {
		
		this.hibernateTemplate=hibernateTemplate;
		
	}


	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
	public List getLoginDetails(final LoginBean lb){
		
	
		/*Employee ref = (Employee) hibernateTemplate.load(Employee.class, 1);
		System.out.println(ref.getEname());*/
		
	List l =    (List) hibernateTemplate.find("from LoginBean");
		return l;
		
	}
}
