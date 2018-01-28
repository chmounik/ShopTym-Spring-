package com.beans;

public class Orders {
	
	int Orderid;
	String customerId;
	int transactionStatus;
	int shippingAddressId;
	String contactNo;
	
	public Orders(int orderid, String customerId, int transactionStatus, int shippingAddressId, String contactNo) {
		super();
		Orderid = orderid;
		this.customerId = customerId;
		this.transactionStatus = transactionStatus;
		this.shippingAddressId = shippingAddressId;
		this.contactNo = contactNo;
	}
	
	public Orders(){
		super();
	}

	public int getOrderid() {
		return Orderid;
	}

	public void setOrderid(int orderid) {
		Orderid = orderid;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public int getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(int transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public int getShippingAddressId() {
		return shippingAddressId;
	}

	public void setShippingAddressId(int shippingAddressId) {
		this.shippingAddressId = shippingAddressId;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	
	
	
}
