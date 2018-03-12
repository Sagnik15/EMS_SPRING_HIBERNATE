package ems.controller;

import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import ems.beans.MedicineBean;
import ems.services.SearchService;

public class AddToMedicineController extends SimpleFormController {

	
	SearchService searchservice;
	public SearchService getSearchservice() {
		return searchservice;
	}
	public void setSearchservice(SearchService searchservice) {
		this.searchservice = searchservice;
	}
	
	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors ) throws Exception{
		
		/*String id = 	request.getParameter("mid");
		String name = 	request.getParameter("mname");
		String price = 	request.getParameter("mprice");*/
			
		MedicineBean mb = (MedicineBean)command;
		
		
			String res = 	searchservice.addMed(mb);
			
			request.setAttribute("msg5", res);
			System.out.println(res);
			return new ModelAndView("AddToInventory","msg5", res);
			
			
		    
			
		
			
		

		
		
			}
	
}
