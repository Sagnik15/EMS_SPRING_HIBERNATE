package ems.controller;

import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import ems.beans.OrderBean;
import ems.services.PlaceOrderService;

public class PlaceOrderController extends SimpleFormController {

	
	PlaceOrderService placeorderservice;
	
	public PlaceOrderService getPlaceorderservice() {
		return placeorderservice;
	}
	public void setPlaceorderservice(PlaceOrderService placeorderservice) {
		this.placeorderservice = placeorderservice;
	}
	
	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors ) throws Exception{
		
System.out.println("inside place order controller");

		/*String orderId = request.getParameter("order_id");
		String medId = request.getParameter("med_id");
		String suppId = request.getParameter("supid");
		String suppName = request.getParameter("supname");
		String quant = request.getParameter("quant");
		String odate = request.getParameter("odate");*/
		
		OrderBean ob = (OrderBean)command;
		
		System.out.println(ob);
			 

				
					boolean res = placeorderservice.placeOrder(ob);
					System.out.println(res);
					if(res==false){
					String msg = "MEDICINE ID DOES NOT MATCH ! First make an entry for this type of Med";
					request.setAttribute("msg2", msg);
					
				      
					
					}else if(res==true){
						String msg = "INSERT SUCCESSFULL";
						request.setAttribute("msg2", msg);
						
					}
						
					
					RequestDispatcher rd = request.getRequestDispatcher("/PlaceOrder.jsp");
				       rd.forward(request, response);
			
			
		
		
		
		return null;
	}
	
	
}
