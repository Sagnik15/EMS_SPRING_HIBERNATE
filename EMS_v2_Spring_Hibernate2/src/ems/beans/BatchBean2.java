package ems.beans;

import java.util.Date;

public class BatchBean2 {

	private String medId;
	private String medName;
	private int medPrice;
	private String batchId;
	private String supplierId;
	private String supplierName;
	private String arrivalDate;
	private String expiryDate;
	private int quantity;

	{
		System.out.println("been instantiated");
	}

	public String getMedId() {
		return medId;
	}

	public void setMedId(String medId) {
		this.medId = medId;
	}

	public String getMedName() {
		return medName;
	}

	public void setMedName(String medName) {
		this.medName = medName;
	}

	public int getMedPrice() {
		return medPrice;
	}

	public void setMedPrice(int medPrice) {
		this.medPrice = medPrice;
	}

	public String getBatchId() {
		return batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getArrivalDate() {
		return arrivalDate;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
