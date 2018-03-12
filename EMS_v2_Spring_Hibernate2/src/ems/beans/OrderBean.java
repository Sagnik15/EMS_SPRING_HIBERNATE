package ems.beans;

import java.util.Date;

public class OrderBean {

	private String order_Id;
	private String medId;
	private String supplierName;
	private String supplierId;
	private int quantity;
	private String orderDate;
	
	
	public OrderBean() {
		// TODO Auto-generated constructor stub
	}


	public String getOrder_Id() {
		return order_Id;
	}
	public void setOrder_Id(String order_Id) {
		this.order_Id = order_Id;
	}


	public String getMedId() {
		return medId;
	}


	public void setMedId(String medId) {
		this.medId = medId;
	}


	public String getSupplierName() {
		return supplierName;
	}


	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}


	public String getSupplierId() {
		return supplierId;
	}


	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	
	
	
}
