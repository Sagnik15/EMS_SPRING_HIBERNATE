package ems.dao;

import org.springframework.orm.hibernate3.HibernateTemplate;

import ems.beans.UserBean;





public class UserBeanDao {

	
		private HibernateTemplate hibernateTemplate;

		public HibernateTemplate getHibernateTemplate() {
			return hibernateTemplate;
		}

		public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
			this.hibernateTemplate = hibernateTemplate;
		}
		
		public boolean create(final UserBean ub){
			
			hibernateTemplate.save(ub);
			System.out.println("in dao");
			return false;
			
			
			
		}
		
}