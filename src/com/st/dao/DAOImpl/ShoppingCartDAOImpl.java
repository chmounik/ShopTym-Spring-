package com.st.dao.DAOImpl;

import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.st.dao.ShoppingCartsDAO;

public class ShoppingCartDAOImpl implements ShoppingCartsDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public void insertShoppingCart() {
		try {
			String query = "INSERT INTO SHOPPINGCARTPRODUCT ( shoppingcartproductid ,orderid,productid,quantity ) VALUES ( ? , ?, ?, ? ) ";
			Object[] queryObjects = {"xyz@gmail.com",1,8001,"25669987"} ;
			int[] types = new int[] {Types.VARCHAR,Types.INTEGER,Types.INTEGER,Types.VARCHAR  } ;
			jdbcTemplate.update(query, queryObjects, types) ;
			System.out.println(query);
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

}
