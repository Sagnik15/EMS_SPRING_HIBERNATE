package ems.controller;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import ems.beans.BatchBean;
import ems.services.AdminService;

public class ViewExpiredController extends SimpleFormController {

	AdminService adminservice3;
	public AdminService getAdminservice3() {
		return adminservice3;
	}
	public void setAdminservice3(AdminService adminservice3) {
		this.adminservice3 = adminservice3;
	}
	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors ) throws Exception{
		
		
		
			System.out.println("get exp servlet");
			LinkedList<BatchBean> ll = adminservice3.viewExpired();
			System.out.println("list fetched");
			HttpSession session = request.getSession(false);
			
			session.setAttribute("expiredItems", ll);
			
			Iterator itr = ll.iterator();
			while(itr.hasNext()){
				
				System.out.println(itr.next());
			}
			
			
			System.out.println("list saved in session");
			
			
			RequestDispatcher rd = request.getRequestDispatcher("/ReturnItems.jsp");
		       rd.forward(request, response);
			
		
		
		return null;
	}
	
	
	
}
