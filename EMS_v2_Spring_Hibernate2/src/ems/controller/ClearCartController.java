package ems.controller;

import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import ems.beans.BatchBean;
import ems.dao.BillingDao;
import ems.beans.CartService;

public class ClearCartController extends SimpleFormController{

	
	BillingDao billingdao;
	
	public BillingDao getBillingdao() {
		return billingdao;
	}
	public void setBillingdao(BillingDao billingdao) {
		this.billingdao = billingdao;
	}
	
	
	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors ) throws Exception{
		
		
		HttpSession session = request.getSession(false);
		Object obj3 = session.getAttribute("cart_array");
		

			CartService cs2 = (CartService) obj3;
			BatchBean mb = new BatchBean();
			
		
				billingdao.updateQuant(cs2);
			
	        cs2.remove(mb);
	        
	        return new ModelAndView("billing");
	      
	}
	
}
