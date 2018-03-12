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

import ems.beans.UserBean;
import ems.services.FindUserService;

public class SearchUserController extends SimpleFormController {

	
	FindUserService finduserservice;
	
	public FindUserService getFinduserservice() {
		return finduserservice;
	}
	public void setFinduserservice(FindUserService finduserservice) {
		this.finduserservice = finduserservice;
	}
	
	
	
	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors ) throws Exception{
		
		
		
		String srch = request.getParameter("search");
		// String formId=request.getParameter("search-form");
		System.out.println(srch);

		HttpSession session = request.getSession(false);
		session.setAttribute("search", srch);

		
			LinkedList ar = finduserservice.fetchUserDetails();
			
			
			
			System.out.println("array list fetched");
			Iterator itr = ar.iterator();

			LinkedList<UserBean> listFilter = new LinkedList<UserBean>();
			
			/* System.out.println(itr.hasNext()); */

			while (itr.hasNext()) {

				UserBean mb1 = (UserBean) itr.next();

				/* if(mb1.getName().equals(srch) || mb1.getUId().equals(srch)){ */
				listFilter.add(mb1);
				System.out.println("inside insert all");
				request.setAttribute("values", mb1);

				// System.out.println(mb1.getMedId() + "------- "
				// +mb1.getMedName()+" --------"+mb1.getMedPrice());
				/* } */

			}

			Iterator itr2 = ar.iterator();

			LinkedList<UserBean> listFilter2 = new LinkedList<UserBean>();

			System.out.println(itr2.hasNext());

			while (itr2.hasNext()) {

				UserBean mb2 = (UserBean) itr2.next();

				if (mb2.getName().equalsIgnoreCase(srch)
						|| mb2.getU_Id().equalsIgnoreCase(srch)) {

					System.out.println("inside selective insert");
					listFilter2.add(mb2);

					// System.out.println(mb1.getMedId() + "------- "
					// +mb1.getMedName()+" --------"+mb1.getMedPrice());
				}

			}
			

			

			request.setAttribute("userList", listFilter);

			request.setAttribute("userList2", listFilter2);
			
			
			
			
			RequestDispatcher rd = request
					.getRequestDispatcher("/ViewUser.jsp");
			rd.forward(request, response);
		
		
		return null;
		
	}
	
}
