package ems.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import ems.beans.BatchBean;
import ems.beans.BillingBean;

import ems.beans.MedicineBean;
import ems.services.BillingService;

public class BillingController extends SimpleFormController {

	BillingService billingservice;
	
	
	
	
	public BillingService getBillingservice() {
		return billingservice;
	}




	public void setBillingservice(BillingService billingservice) {
		this.billingservice = billingservice;
	}




	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors ) throws Exception{
	
		BillingBean fetchMed = (BillingBean) command;
		
		System.out.println("inside billing controller");
		  HttpSession session = request.getSession(false);
			 
	     //  String item_name = request.getParameter("item_name");
		  String item_name = fetchMed.getItem_name();
	       System.out.println(item_name);
	      
	          
	     
	    	
	    	  System.out.println("Initiating addToCart");
			ArrayList al =  billingservice.addToCart(item_name);
			
			
			if(al.isEmpty()){
				System.out.println("in else");
				String msg="Invalid Name";
				request.setAttribute("msg2", msg);
				}
					
			
			
				Iterator itr = al.iterator();
				
				System.out.println("inside if ");
			while(itr.hasNext()){
				
				BatchBean mb2 = (BatchBean)itr.next();
				
				System.out.println(mb2.getMedId() + " "+mb2.getExpiryDate());
				
			}
			
			
			request.setAttribute("availableMed", al);
			
			session.setAttribute("al", al);
				
			
			
			
			
			
		
		
		
		return new ModelAndView("billing","al",al);
	}
	
}
