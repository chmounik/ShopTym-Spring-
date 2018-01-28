package com.st.dao.DAOImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.st.beans.Cart;


public class MyrowMapperCart implements RowMapper<Cart> {
@Override
	public Cart mapRow(ResultSet rs, int rownumber) throws SQLException {
		System.out.println("mapRow()====:"+rownumber);
		Cart c=new Cart();
		c.setCartId(rs.getInt("cartid"));
		c.setProductName(rs.getString("productname"));
		c.setProductId(rs.getInt("productid"));
		c.setQuantity(rs.getInt("quantity"));
		c.setProductImage(rs.getBlob("picture"));
		c.setCost(rs.getDouble("cost"));
		
		return c;
		}
}
