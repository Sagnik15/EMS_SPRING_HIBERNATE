package ems.services;

import java.util.Iterator;
import java.util.List;



import ems.beans.UserBean;
import ems.dao.DeleteUserDao;

public class DeleteUserService {
	
	DeleteUserDao deldao;

	public DeleteUserDao getDeldao() {
		return deldao;
	}

	public void setDeldao(DeleteUserDao deldao) {
		this.deldao = deldao;
	}
	
	public boolean deleteUserValidate(UserBean ub1){
		System.out.println("starting point of delete user service");
		boolean res1= false;
		System.out.println(ub1.getU_Id());
		System.out.println(ub1.getName());
		
		List ul=  (List) deldao.getUserDetails(ub1);
		System.out.println(ul);
		Iterator i=ul.iterator();
	while(i.hasNext()){
		
		UserBean ub2=(UserBean) i.next();
		String entered_uid=ub2.getU_Id();
		long entered_phone=ub2.getPhone();
		String entered_name=ub2.getName();
		
		System.out.println("entered uid ="+entered_uid);
		System.out.println("entered name ="+entered_name);
		System.out.println(ub1.getU_Id());
		System.out.println("entered_phone ="+entered_phone);
		if(entered_uid.trim()==ub2.getU_Id()&&entered_name.trim()==ub2.getName())
			System.out.println("came to service and compared details of users...lets see the result");
			res1=true;
	}
		
		
		return res1 ;
				
	}
	public boolean deleteUser(UserBean ub1){
		
		boolean res2=false;
		res2= deldao.deleteUserDetails(ub1);
		System.out.println("in service again for deleting users...lets see whether users are deleted");
		
		return res2;
									
		}
		
		
		
		
	}


