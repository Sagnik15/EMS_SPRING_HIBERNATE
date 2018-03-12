package ems.services;

import java.sql.ResultSet;
import java.util.Iterator;
import java.util.List;

import ems.dao.PlaceOrderDao;
import ems.dao.SearchMedDao;

import ems.beans.BatchBean;
import ems.beans.MedicineBean;
import ems.beans.OrderBean;

public class PlaceOrderService {

	SearchMedDao searchmeddao;
	PlaceOrderDao placeorderdao;
	
	public PlaceOrderDao getPlaceorderdao() {
		return placeorderdao;
	}
	public SearchMedDao getSearchmeddao() {
		return searchmeddao;
	}
	public void setPlaceorderdao(PlaceOrderDao placeorderdao) {
		this.placeorderdao = placeorderdao;
	}
	public void setSearchmeddao(SearchMedDao searchmeddao) {
		this.searchmeddao = searchmeddao;
	}

	public boolean placeOrder(OrderBean ob) {

		
		String medId = ob.getMedId();
		
		boolean res = false;
		List rs = searchmeddao.getMed();
		System.out.println("resultset fetched!");
		Iterator itr= rs.iterator();
                 while(itr.hasNext()){
                	
               MedicineBean bb = (MedicineBean)itr.next(); 	 
                	 
                String mId = 	 bb.getMedId();
                	 
                	 if(mId.equalsIgnoreCase(medId)){
                		 
                		 res = true;
                	 }
                	 
                 }		
		if(res==true){
			
			placeorderdao.placeOrder(ob);
			System.out.println("row inserted");
		}
		return res;
			

		
		
	}

}
