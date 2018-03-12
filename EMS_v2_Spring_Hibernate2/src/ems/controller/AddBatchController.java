package ems.controller;

import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import ems.beans.BatchBean2;
import ems.services.AdminService;

public class AddBatchController extends SimpleFormController {
	
	AdminService adminservice5;
	public AdminService getAdminservice5() {
		return adminservice5;
	}
	public void setAdminservice5(AdminService adminservice5) {
		this.adminservice5 = adminservice5;
	}
	
	{System.out.println("inside controller, outside method");}
	
	
	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors ) throws Exception{
		
		/*String bid = request.getParameter("bid");
		String sid = request.getParameter("sid");
		String sname = request.getParameter("sname");
		String ad = request.getParameter("ad");
		String ed = request.getParameter("ed");
		String quant = request.getParameter("quant");
		String mid = request.getParameter("mid");
		*/
		
		
		BatchBean2 bb = (BatchBean2) command;
		
		

		
			boolean res = adminservice5.addToInventory(bb);
			if(res==false){
			String msg = "MEDICINE ID DOES NOT MATCH !   Please enter a valid ID";
			request.setAttribute("msg", msg);
			return new ModelAndView("AddToInventory","msg", msg);
					
			}else{
				String msg = "INSERT SUCCESSFULL";
				request.setAttribute("msg", msg);
				return new ModelAndView("AddToInventory","msg", msg);
				
			}
			
			
			
			/*RequestDispatcher rd = request.getRequestDispatcher("/AddToInventory.jsp");
		       rd.forward(request, response);*/
		
		
		
		//return null;
		
		
		
		
		
		
	}

}
