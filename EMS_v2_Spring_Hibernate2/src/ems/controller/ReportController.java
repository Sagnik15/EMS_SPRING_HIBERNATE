package ems.controller;


import java.util.ArrayList;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import ems.beans.BatchBean;
import ems.beans.BatchBean2;
import ems.services.AdminService;




public class ReportController extends SimpleFormController {

	AdminService adminservice2;
	
	
	
	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors ) throws Exception{
		
		/*String sid = 	request.getParameter("supplierId");
		String dt = 	request.getParameter("expiryDate");*/
		
		System.out.println("inside report controller");
		
		BatchBean2 bb = (BatchBean2) command;
			BatchBean bb2 = new BatchBean();
			String expDate = bb.getExpiryDate();
			java.sql.Date expdt = java.sql.Date.valueOf(expDate);
			bb2.setExpiryDate(expdt);
			
			bb2.setSupplierId(bb.getSupplierId());
			
				
				System.out.println("starting search for expired medicine !");
			ArrayList arr = adminservice2.getExpiry(bb2);
			System.out.println("search complete !");
			System.out.println(arr);
			if(arr.isEmpty()){
				System.out.println("empty arraylist");
				String message = "No Expired Products for this supplier on this date";
				request.setAttribute("message2", message);
			}else{
				System.out.println("items found");
				request.setAttribute("medListExp", arr);
				
			}
			
			//return new ModelAndView("PrintReport","medListExp", arr );
			
				return new ModelAndView("PrintReport");
			/*RequestDispatcher rd = request.getRequestDispatcher("/PrintReport.jsp");
		       rd.forward(request, response);
		
		return null;*/
		
	}
	
	public AdminService getAdminservice2() {
		return adminservice2;
	}
	public void setAdminservice2(AdminService adminservice2) {
		this.adminservice2 = adminservice2;
	}
	
}
