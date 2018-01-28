package com.st.dao.DAOImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.beans.Payment;


public class MyrowMapperPayment implements RowMapper<Payment> {
@Override
	public Payment mapRow(ResultSet rs, int rownumber) throws SQLException {
		System.out.println("mapRow()====:"+rownumber);
		Payment p=new Payment();
		p.setPaymentId(rs.getInt("paymentid"));
		p.setCreditcardNumber(rs.getString("creditcardnumber"));
		p.setExpirationDate(rs.getString("expirationdate"));
		p.setCvv(rs.getInt("cvv"));
		p.setAmount(rs.getDouble("amount"));
		p.setFirstName(rs.getString("firstname"));
		p.setLastName(rs.getString("lastname"));
		p.setBillingAddress(rs.getString("billingaddress"));

		
		System.out.println(p.toString());
		return p;
		}
}
