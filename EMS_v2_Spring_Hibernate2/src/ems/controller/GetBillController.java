package ems.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import ems.beans.BatchBean;
import ems.beans.CartService;

public class GetBillController extends SimpleFormController{

	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors ) throws Exception{
	
		
HttpSession session = request.getSession(false);
		
		
		CartService cs = (CartService) session.getAttribute("cs");
		int sum = 0;
		ArrayList arr = cs.getIt();
		if(arr.isEmpty()){
			String msg = "Please add something to cart !";
			request.setAttribute("msg", msg);
			
			return new ModelAndView("billing","msg", msg );
			
			
			
			
		}else{
		Iterator itr = arr.iterator();
		while(itr.hasNext()){
			
		BatchBean mb = (BatchBean)itr.next();
			int a = mb.getMedPrice();
			int b= mb.getQuantity();
			sum=sum+(a*b);
			/*out.println(itr.next());*/
			session.setAttribute("total", sum);
		}
		return new ModelAndView("genbill","total", sum);
		
	}
		
		
	
	
	
	}
	
	
	
}
