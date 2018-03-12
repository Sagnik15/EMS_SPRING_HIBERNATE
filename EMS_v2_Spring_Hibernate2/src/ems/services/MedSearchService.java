package ems.services;

import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import ems.dao.MedSearchDao;

import ems.beans.BatchBean;
import ems.beans.MedicineBean;

public class MedSearchService {

	MedSearchDao medsearchdao;
	public MedSearchDao getMedsearchdao() {
		return medsearchdao;
	}
	public void setMedsearchdao(MedSearchDao medsearchdao) {
		this.medsearchdao = medsearchdao;
	}
	
	public LinkedList fetchMed() {
		
		
		
		List rs = medsearchdao.searchMed();
		
		
	System.out.println("resultset fetched in search service");
		
		LinkedList<BatchBean> arr = new LinkedList<BatchBean>();
		
		
		//java.util.Date sqd = new java.util.Date().getDate());
		System.out.println("before while");
		 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		   //get current date time with Date()
		   Date date = new Date();
		   
		/*while(rs.next()){
			
			MedicineBean mb = null;
			mb=	new MedicineBean();
			String a = rs.getString("batch_Id");
			String b = rs.getString("Med_Id");
			String c = rs.getString("Med_Name");
			int d = rs.getInt("Med_Price");
			Date e =(rs.getDate("exp_Date"));
			int f = rs.getInt("quantity");
			String g = rs.getString("supplier_Name");
			
		
			mb.setBatchId(a);
			mb.setMedId(b);
			mb.setMedName(c);
			mb.setMedPrice(d);
			mb.setExpiryDate(e);
			mb.setQuantity(f);
			mb.setSupplierName(g);
			System.out.println(rs.getString("Med_Id") + "++++ "+rs.getString("Med_Name")+" ++++"+rs.getInt("Med_Price"));
		*/
		   
		   
		   Iterator itr2 = rs.iterator();
		   
		   while(itr2.hasNext()){
		   
			   BatchBean mb = (BatchBean) itr2.next();
			   
			   
			if(mb.getExpiryDate().after(date)){
			
			arr.add(mb);
			}
		}
		System.out.println("after while");
		
		Iterator<BatchBean> itr = arr.iterator();
		while(itr.hasNext()){
			
			BatchBean medb = (BatchBean)itr.next();
			System.out.println(medb.getMedId() + medb.getMedName() + medb.getMedPrice());
			
		
		}
		
		return arr;
	}

}
