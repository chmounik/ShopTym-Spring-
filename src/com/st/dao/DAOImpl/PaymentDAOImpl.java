package com.st.dao.DAOImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;import org.springframework.stereotype.Component;

import com.st.dao.PaymentDAO;
@Component
public class PaymentDAOImpl implements PaymentDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}



	@Override
	public void addPaymentDetails(String cardnumber, String expdate, int cvc, String fname, String lname, String billaddress) {
		try{
			String query = "INSERT INTO PAYMENT (CREDITCARDNUMBER, EXPIRATIONDATE, CVV, FIRSTNAME, "
					+ "LASTNAME, BILLINGADDRESS) VALUES (?, ?, ?, ?, ?, ?, ?) " ;
			jdbcTemplate.update(query,new Object[] {cardnumber,expdate,cvc,fname,lname,billaddress });
			System.out.println(query);
			}
			catch(Exception e){
				System.out.println("Payment Failed");
			}
		
	}

	
}