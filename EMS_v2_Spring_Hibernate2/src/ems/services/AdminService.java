package ems.services;


import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import ems.dao.AdminDao;
import ems.dao.SearchDao;

import ems.beans.BatchBean;
import ems.beans.BatchBean2;
import ems.beans.MedicineBean;

public class AdminService {

	SearchDao searchdao2;
	AdminDao admindao2;
	public AdminDao getAdmindao2() {
		return admindao2;
	}
	public SearchDao getSearchdao2() {
		return searchdao2;
	}
	public void setAdmindao2(AdminDao admindao2) {
		this.admindao2 = admindao2;
	}
	public void setSearchdao2(SearchDao searchdao2) {
		this.searchdao2 = searchdao2;
	}
	
	public boolean addToInventory(BatchBean2 bb) {
		
		System.out.println("inside add to inventory method in admin service");
		List rs = searchdao2.getMed();
		boolean res = false;
		String mId = null;
		Iterator itr = rs.iterator();
		
                 while(itr.hasNext()){
                	 
                	 MedicineBean mb = (MedicineBean)itr.next();
                	 
                 mId = 	 mb.getMedId();
                	 
                	 if(mId.equalsIgnoreCase(bb.getMedId())){
                		 
                		 res = true;
                		 bb.setMedName(mb.getMedName().toLowerCase());
                		 bb.setMedPrice(mb.getMedPrice());
                	 }
                	 
                 }		
		if(res==true){
			
			admindao2.addToInventory(bb);
			
		}
		
		return res;
		
	}
	public ArrayList getExpiry(BatchBean mb) {
		
		
		
		String sid = mb.getSupplierId();
		Date date = mb.getExpiryDate();
		String dt = date.toString();
		
		DateFormat sdf=new SimpleDateFormat("yyyy/mm/dd");
		java.sql.Date javaSqlDate = java.sql.Date.valueOf(dt);
		ArrayList<BatchBean> arr = new ArrayList<BatchBean>();
		List rs = searchdao2.searchMedbyName();
		
		Iterator itr = rs.iterator();
		
		while(itr.hasNext()){
			
			BatchBean mb2 = (BatchBean) itr.next();
			
			
			
			
			
			Date e =mb2.getExpiryDate();
			
			String i = mb2.getSupplierId();
			
		
		System.out.println(mb2.getExpiryDate());
		System.out.println(mb.getExpiryDate());
			System.out.println(mb2.getMedName());
			
			if(i.equalsIgnoreCase(sid) && date.equals(e)){
				
				arr.add(mb2);
			}
			
			
		}
		return arr;
		
	}
	public LinkedList<BatchBean> viewExpired() {


List rs = searchdao2.searchMedbyName();
		
		Date date = new Date();
		LinkedList<BatchBean> ll = new LinkedList<BatchBean>();
		System.out.println("inside viewExpired method in admin service");
		
		Iterator itr  = rs.iterator();
		while(itr.hasNext()){
			
			BatchBean bb = (BatchBean)itr.next();
			Date exd = bb.getExpiryDate();
			
			System.out.println("inside while");
			/*MedicineBean mb = new MedicineBean();
			mb.setMedId(rs.getString("Med_Id"));
			mb.setMedName(rs.getString("Med_Name"));
			mb.setMedPrice(rs.getInt("Med_price"));
			mb.setBatchId(rs.getString("Batch_Id"));
			mb.setSupplierId(rs.getString("Supplier_Id"));
			mb.setSupplierName(rs.getString("supplier_name"));
			mb.setExpiryDate(rs.getDate("exp_date"));
			mb.setQuantity(rs.getInt("Quantity"));
			
			Date exd = rs.getDate("exp_date");*/
			
			if(exd.before(date)){
			ll.add(bb);
			}
		}
		
		
		
		return ll;
		
		
		
	}
	public void returmItem(ArrayList arr) {
		// TODO Auto-generated method stub
		

		Iterator itr = arr.iterator();
		while(itr.hasNext()){
						
			System.out.println("inside while of return item method in admin service");
			String BatchId = (String) itr.next();
		admindao2.removeMed(BatchId);
		}
		
		
	}

}
