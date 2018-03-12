package ems.services;


import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import ems.beans.BatchBean;
import ems.beans.MedicineBean;
import ems.dao.SearchDao;

public class BillingService {

	SearchDao searchdao;
	
	public SearchDao getSearchdao() {
		return searchdao;
	}
	public void setSearchdao(SearchDao searchdao) {
		this.searchdao = searchdao;
	}
	
	
	public  ArrayList<BatchBean> addToCart(String item_name)  {
		// TODO Auto-generated method stub
		
		ArrayList<BatchBean> al = new ArrayList<BatchBean>();
		
		
		List rs = searchdao.searchMedbyName();
		System.out.println("srch dao methd executed in billing service");
		  Date date = new Date();
		  
		  System.out.println(rs.isEmpty());
		 
			
		  if(!(rs.isEmpty())){
			  Iterator itr = rs.iterator();
			  while(itr.hasNext()){
				  
				  Object obj = itr.next();
				  System.out.println(obj);
				  BatchBean mb2 = (BatchBean) obj;
				  
				  if(mb2.getMedName().equalsIgnoreCase(item_name)){
						
						if(mb2.getExpiryDate().after(date)){
							
							
						
					al.add(mb2);
						}
					System.out.println("item is added");
					}
				  
			  }
			   
		  }
		  		
		System.out.println("item adding done");
		
		
		return al;
	}
	public MedicineBean getEarliestExpiry(String item_name) {
		// TODO Auto-generated method stub
		return null;
	}

}
