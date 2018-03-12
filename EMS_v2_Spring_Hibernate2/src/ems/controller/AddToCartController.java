package ems.controller;

import java.io.PrintWriter;
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
import ems.beans.CartService;

public class AddToCartController extends SimpleFormController{

	
	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors ) throws Exception{
		
		
		String BatchId = request.getParameter("selection");
		System.out.println(BatchId);
		if(BatchId!=null){	
				
			String batchId = BatchId.trim();
			String quantity  = request.getParameter("item_quantity");
			int quant = Integer.parseInt(quantity);
			System.out.println(quantity);
			if (quant<=0){

				String msg = "Enter a valid Quantity";
				request.setAttribute("msg", msg);
				
				RequestDispatcher rd = request.getRequestDispatcher("/billing.jsp");
			       rd.forward(request, response);
				
				
			}else{
			PrintWriter out = response.getWriter();
			/*out.println(MedId);
			out.println(quantity);*/
			HttpSession session = request.getSession(false);
			//ArrayList<MedicineBean> arr2 = new ArrayList<MedicineBean>();
			
			ArrayList arr = (ArrayList) session.getAttribute("al");
			
			
			//CartService cs = new CartService();
			
		
		CartService cs = 	(CartService)session.getAttribute("cs");
			System.out.println("arraylist fetched");
			Iterator itr = arr.iterator();
			while(itr.hasNext()){
				
				BatchBean mb2 = (BatchBean)itr.next();
				System.out.println(mb2.getBatchId()+" "+mb2.getMedName()+" "+mb2.getQuantity());
				System.out.println(BatchId);
				
				//System.out.println(MedId.compareTo(mb2.getMedId()));
				
			//	System.out.println(MedId.equalsIgnoreCase(mb2.getBatchId()));
				
				
				String bid = mb2.getBatchId().trim();
				System.out.println(bid.equals(batchId));
				
				if(bid.equals(batchId)){
					
					if(mb2.getQuantity()>= quant)
					
					{
					System.out.println("before setting quant");
					mb2.setQuantity(quant);
					System.out.println(mb2.getMedName()+ " " +mb2.getExpiryDate() + " " +mb2.getQuantity());
					cs.insert(mb2);
					}else{
						
						String msg = "insufficient stock";
						request.setAttribute("msg", msg);
						
					       break;
					}
					//arr2.add(mb2);
				//System.out.println(mb2.getQuantity());
				}
				
			}
			
			session.setAttribute("cart_array", cs);
			//request.setAttribute("cart_array", arr2);
			
			
			System.out.println("name val pair settin done");
			return new ModelAndView("billing","cart_array", cs);
			
			
			
			}    
		}
		
		
			String msg = "Select an option please !";
			request.setAttribute("msg", msg);
			
			return new ModelAndView("billing","msg", msg);
			
			
		
		
		
		
		
		
		
		
		
		
	//	return new ModelAndView("billing");
	}

}
