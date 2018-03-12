package ems.services;

import java.util.Iterator;
import java.util.List;



import ems.beans.LoginBean;
import ems.dao.LoginDao;

public class LoginService {

	LoginDao logd ;
	public LoginDao getLogd() {
		return logd;
	}public void setLogd(LoginDao logd) {
		this.logd = logd;
	}
	
	public boolean validateLogin(LoginBean lb){
	
		
		boolean res= false;
		System.out.println(lb.getRole());
		System.out.println(lb.getPwd());
		System.out.println(lb.getUserid());
		List l = logd.getLoginDetails(lb);
		Iterator itr =  l.iterator();
		while(itr.hasNext()){
			
			
			
		
	LoginBean lb2 = (LoginBean) itr.next();
	int sourceuid = 	lb.getUserid();
	String sourcepwd = lb.getPwd();
	String sourcerole = lb.getRole();
		System.out.println(sourceuid+sourcerole+sourcepwd);
	if(sourceuid==lb2.getUserid() && sourcepwd.trim().equals(lb2.getPwd()) && sourcerole.trim().equalsIgnoreCase(lb2.getRole())){
		res= true;
	}
	
		
		
	}
		return res;
	
	}
}
