package ems.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import ems.beans.UserBean;
import ems.services.DeleteUserService;

public class DeleteUserController extends SimpleFormController {

	private DeleteUserService dels;

	public DeleteUserService getDels() {
		return dels;
	}

	public void setDels(DeleteUserService dels) {
		this.dels = dels;
	}
	
	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors ) throws Exception{
		System.out.println("at the starting point of controller");
		UserBean ub1=(UserBean) command;
		System.out.println(ub1.getU_Id());
		
		boolean res1=dels.deleteUserValidate(ub1);
		
		System.out.println("the validations of enter details is"+res1);
		if(res1==true){
			
			System.out.println("this user is available in database");
			
			boolean res2=dels.deleteUser(ub1);
			if(res2==true){
				System.out.println("the user is deleted successfully"+res2);
			}
			
		}
		
		String msg="User Deleted Successfully";
		
		
		return new ModelAndView("DeleteUser","msg",msg);
	
	}

	}


