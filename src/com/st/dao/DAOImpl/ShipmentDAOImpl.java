package com.st.dao.DAOImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;import org.springframework.stereotype.Component;

import com.st.dao.ShipmentsDAO;

import java.sql.Types;

@Component
public class ShipmentDAOImpl implements ShipmentsDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public void addShipmentDetails() {
		try {
			String query = "INSERT INTO SHIPMENT ( shoppingcartproductid , shipmentstatus ) VALUES ( ? , ? ) ";
			Object[] queryObjects = {593,"Ordered"} ;
			int[] types = new int[] { Types.INTEGER, Types.VARCHAR } ;
			jdbcTemplate.update(query, queryObjects, types) ;
			System.out.println(query);
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

}
