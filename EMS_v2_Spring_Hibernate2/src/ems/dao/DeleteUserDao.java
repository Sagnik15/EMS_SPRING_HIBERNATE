package ems.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;

import ems.beans.UserBean;

public class DeleteUserDao {
	
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public List getUserDetails(UserBean ub1){
		
		List ul= (List)hibernateTemplate.find("from UserBean");
		System.out.println(ul);
		
		
		System.out.println("in dao...got the user details from data base");
		return ul;
	}
		
		public boolean deleteUserDetails(UserBean ub2){
			Session session=hibernateTemplate.getSessionFactory().openSession();
			Query query=session.createQuery("delete from UserBean where  id=:i");
			query.setParameter("i", ub2.getU_Id());
			int result=query.executeUpdate();
			
			
			System.out.println("deleted users successfulyy from data base");
			return true;
		
			
		
		
		
		
		
	}
	

}
