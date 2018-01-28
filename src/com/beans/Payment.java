package com.beans;

public class Payment {
	private int paymentId ;
	private String creditcardNumber;
	private String expirationDate ;
	private int cvv ;
	private double amount;
	private String firstName ;
	private String lastName ;
	private String billingAddress ;
	
	public Payment(int paymentId, String creditcardNumber, String expirationDate, int cvv, double amount,
			String firstName, String lastName, String billingAddress) {
		super();
		this.paymentId = paymentId;
		this.creditcardNumber = creditcardNumber;
		this.expirationDate = expirationDate;
		this.cvv = cvv;
		this.amount = amount;
		this.firstName = firstName;
		this.lastName = lastName;
		this.billingAddress = billingAddress;
	}
	public Payment(){
		super();
	}
	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public String getCreditcardNumber() {
		return creditcardNumber;
	}

	public void setCreditcardNumber(String creditcardNumber) {
		this.creditcardNumber = creditcardNumber;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}
	
	
}
