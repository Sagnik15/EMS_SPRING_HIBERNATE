package ems.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import ems.beans.LoginBean;
import ems.services.LoginService;

public class LoginController extends SimpleFormController {

	private LoginService ls;
	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors ) throws Exception{
		
		LoginBean logb = (LoginBean) command;
		
		boolean res = ls.validateLogin(logb);
		
		System.out.println(res);
		if(res==true){
			HttpSession session = request.getSession();
			String sessionid = session.getId();
			session.setAttribute("sessionId", sessionid);
			System.out.println("credentials validated");
			if(logb.getRole().trim().equalsIgnoreCase("admin")){
				
				return new ModelAndView("admin");
				
			}
			else if(logb.getRole().trim().equalsIgnoreCase("user")){
				
				System.out.println("inside user page dispatcher if");
				return new ModelAndView("user");
			}
			
		}
		
		
		System.out.println(logb.getUserid());
		request.setAttribute("uid", logb.getUserid());
		request.setAttribute("pwd", logb.getPwd());
		request.setAttribute("role", logb.getRole());
		System.out.println("reached Controller.....");
		
		
		return new ModelAndView("Error");
		
		
		
	}
	public LoginService getLs() {
		return ls;
	}
	public void setLs(LoginService ls) {
		this.ls = ls;
	}

	
	
}
