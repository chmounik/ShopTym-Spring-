package com.beans;

import java.util.ArrayList;

public class Order {

	private int orderID ;
	private String orderIDString ;
	private String orderStatus ;
	private boolean isTransactionSuccessful ;
	private String transactionStatus ;
	private String userEmail ;
	private User customer ;
	private String contactNo ;
	private ArrayList<ShoppingCartProduct> products = new ArrayList<ShoppingCartProduct>() ;
	private Address shippingAddress ;
	private String orderDate ;

	public Order() {}

	public Order(int orderID, String orderStatus) {
		this.orderID = orderID;
		this.orderStatus = orderStatus;
	}

	public Order(String orderIDString, String transactionStatus, String userEmail, String contactNo) {
		this.orderIDString = orderIDString ;
		this.transactionStatus = transactionStatus;
		this.userEmail = userEmail;
		this.contactNo = contactNo;
	}

	public Order(int orderID, boolean isTransactionSuccessful, String userEmail, String contactNo, String orderDate) {
		this.orderID = orderID;
		this.isTransactionSuccessful = isTransactionSuccessful;
		this.userEmail = userEmail;
		this.contactNo = contactNo;
		this.orderDate = orderDate ;
	}

	public Order(int orderID, String orderStatus, boolean isTransactionSuccessful, String userEmail, User customer,
			String contactNo, ArrayList<ShoppingCartProduct> products, Address shippingAddress) {
		this.orderID = orderID;
		this.orderStatus = orderStatus;
		this.isTransactionSuccessful = isTransactionSuccessful;
		this.userEmail = userEmail;
		this.customer = customer;
		this.contactNo = contactNo;
		this.products = products;
		this.shippingAddress = shippingAddress;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public boolean isTransactionSuccessful() {
		return isTransactionSuccessful;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public void setTransactionSuccessful(boolean isTransactionSuccessful) {
		this.isTransactionSuccessful = isTransactionSuccessful;
	}

	public User getCustomer() {
		return customer;
	}

	public void setCustomer(User customer) {
		this.customer = customer;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public ArrayList<ShoppingCartProduct> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<ShoppingCartProduct> products) {
		this.products = products;
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderIDString() {
		return orderIDString;
	}

	public void setOrderIDString(String orderIDString) {
		this.orderIDString = orderIDString;
	}
}

