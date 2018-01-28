package com.st.dao;


public interface PaymentDAO {


	public void addPaymentDetails(String cardnumber, String expdate, int cvc, String fname, String lname, String billaddress);
}
