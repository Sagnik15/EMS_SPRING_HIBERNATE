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
import ems.beans.MedicineBean;
import ems.services.MedSearchService;

public class MedSearchController extends SimpleFormController {


	MedSearchService medsearchservice;
	
	public MedSearchService getMedsearchservice() {
		return medsearchservice;
	}
	public void setMedsearchservice(MedSearchService medsearchservice) {
		this.medsearchservice = medsearchservice;
	}
	
	
	
	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors ) throws Exception{
		
		String srch = request.getParameter("search");
		//String formId=request.getParameter("search-form");
		System.out.println(srch);
		
		HttpSession session = request.getSession();
		session.setAttribute("search", srch);
		
		
			LinkedList ar = medsearchservice.fetchMed();
			System.out.println("array list fetched");
			Iterator itr = ar.iterator();
			
			LinkedList<BatchBean> arFilter = new LinkedList<BatchBean>();
			
			/*System.out.println(itr.hasNext());*/
			
			while(itr.hasNext()){
				
				BatchBean mb1 = (BatchBean)itr.next();
				
				
				System.out.println(mb1.getMedId() + "@@@@@" +mb1.getMedName()+"@@@@@"+mb1.getMedPrice());
				
				
				if(mb1.getMedId().equalsIgnoreCase(srch) || mb1.getMedName().equalsIgnoreCase(srch)){
					arFilter.add(mb1);
					
				 request.setAttribute("values", mb1);
				
				
				// System.out.println(mb1.getMedId() + "------- " +mb1.getMedName()+" --------"+mb1.getMedPrice());
				}
			
			}
			
			if(arFilter.isEmpty()){
				String msg = "Sorry, nothing found !  Try Again !";
				request.setAttribute("msg",msg);
				
				return new ModelAndView("userSearch","msg",msg);
				
			}else{
			
			 request.setAttribute("valList", arFilter);
				return new ModelAndView("userSearch","valList", arFilter);
			
		
		
	}
			
	
		}
		
	}
