package com.st.dao.DAOImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.st.beans.Product;

public class MyrowMapper implements RowMapper<Product> {
@Override
	public Product mapRow(ResultSet rs, int rownumber) throws SQLException {
		System.out.println("mapRow()====:"+rownumber);
		Product p=new Product();
		p.setProductAddressId(rs.getInt("productaddressid"));
		p.setSellerId(rs.getString("sellerid"));
		p.setProductCategoryId(rs.getInt("productcategoryid"));
		p.setProductId(rs.getInt("productid"));
		p.setProductDescription(rs.getString("description"));
		p.setProductName(rs.getString("productname"));
		p.setProductImage(rs.getBlob("picture"));
		p.setProductQuantity(rs.getInt("quantity"));
		p.setProductCost(rs.getDouble("price"));
		p.setBrandName(rs.getString("brandName")) ;
		
		System.out.println(p.toString());
		return p;
		}
}