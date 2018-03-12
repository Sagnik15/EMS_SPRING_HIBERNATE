package ems.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import ems.beans.UserBean;
import ems.dao.UserBeanDao;



public class UserBeanController extends SimpleFormController  {

	private UserBeanDao ubService;

	public UserBeanDao getUbService() {
		return ubService;
	}

	public void setUbService(UserBeanDao ubService) {
		this.ubService = ubService;
	}
	
	protected ModelAndView onSubmit(HttpServletRequest request,HttpServletResponse response,Object command,BindException errors)
			throws Exception{
		
		System.out.println("controller reached");	
		
		UserBean ub=(UserBean) command;
		request.setAttribute("city",ub.getCity());
		request.setAttribute("dno",ub.getDno());
		request.setAttribute("name", ub.getName());
		request.setAttribute("password", ub.getPassword());
		request.setAttribute("phone", ub.getPhone());
		request.setAttribute("pin", ub.getPin());
		request.setAttribute("role", ub.getRole());
		request.setAttribute("state", ub.getState());
		request.setAttribute("street", ub.getStreet());
		request.setAttribute("u_Id", ub.getU_Id());
		
		System.out.println("login details object fetched");	
		ubService.create((UserBean) command);
		System.out.println("user added successfully");
		String msg="User added Successfully";
	
				return new ModelAndView("addUser","msg",msg);
				
				
				
				
				 
	}
	}


