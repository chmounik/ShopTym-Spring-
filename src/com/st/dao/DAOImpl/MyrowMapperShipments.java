package com.st.dao.DAOImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.beans.Shipments;

public class MyrowMapperShipments implements RowMapper<Shipments>{
	@Override
	public Shipments mapRow(ResultSet rs, int rownumber) throws SQLException {
		System.out.println("mapRow()====:"+rownumber);
		Shipments c=new Shipments();
		System.out.println(rs.getInt("shippingid"));
		c.setShippingId(rs.getInt("shippingid"));
		c.setShoppingCartProductId(rs.getInt("SHOPPINGCARTPRODUCT.SHOPPINGCARTPRODUCTID"));
		c.setShipmentStatus(rs.getString("shipmentstatus"));
		
		
		return c;
		}

}
