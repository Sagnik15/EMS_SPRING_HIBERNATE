package ems.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import ems.services.AdminService;

public class ReturnItemController extends SimpleFormController {

	
	AdminService adminservice4;
	public AdminService getAdminservice4() {
		return adminservice4;
	}
	public void setAdminservice4(AdminService adminservice4) {
		this.adminservice4 = adminservice4;
	}
	
	
	
	
	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors ) throws Exception{
		
		
		
		HttpSession session = request.getSession(false);
		ArrayList arr = new ArrayList();
		
         int j = (int) session.getAttribute("countexp");
	
		//int j = Integer.parseInt(q);
		
		for(int i=1; i<j ;i++){
			String ch = (String)request.getParameter("choice"+i);
			arr.add(ch);
			System.out.println("choice"+j);
			System.out.println("choice"+i);
			System.out.println("inside for");
		}
		
		
		
		
			adminservice4.returmItem(arr);
			String msg = "Items Deleted";
			session.setAttribute("msg", msg);
		
		
		Iterator itr = arr.iterator();
		while(itr.hasNext()){
			/*String BatchId = (String)itr.next();*/
			System.out.println(itr.next());
		}
		
		
		
		
		
		return new ModelAndView("ReturnItems"); 
	}
	
	
}
