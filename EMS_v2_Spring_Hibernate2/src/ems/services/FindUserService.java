package ems.services;

import java.sql.ResultSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import ems.beans.UserBean;
import ems.dao.AdminDao;

public class FindUserService {

	
	AdminDao admindao;
	
	public AdminDao getAdmindao() {
		return admindao;
	}
	public void setAdmindao(AdminDao admindao) {
		this.admindao = admindao;
	}
	
	
	public LinkedList fetchUserDetails() {
		List rs = admindao.fetchUserDetails();
		System.out.println("resultset fetched in Find User service");
				
				LinkedList<UserBean> arr = new LinkedList<UserBean>();
				
				
				//java.util.Date sqd = new java.util.Date().getDate());
				System.out.println("before while");
				
				 Iterator itr = rs.iterator();
				while(itr.hasNext()){
					
					UserBean ub = (UserBean) itr.next();
										
					arr.add(ub);
					
				}
				System.out.println("after while");
				
				
				
				
				return arr;
		
	}

}
