package ems.beans;

import java.util.ArrayList;

import ems.beans.MedicineBean;


public class CartService {

	
	private static ArrayList<BatchBean> items;

	public CartService(){
	    items = new ArrayList<BatchBean>();
	}

	public void insert(BatchBean mb2){
	    items.add(mb2);
	}

	public void remove(BatchBean mb){
	    //items.removeAll(items);
	    items.clear();
	}

	public int getSize(){
	    return items.size();
	}

	public ArrayList<BatchBean> getIt(){
	    return items;
	}

	

	
}