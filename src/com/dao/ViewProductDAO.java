package com.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.st.beans.Product;
import com.st.utils.ConnectionHelper;

public class ViewProductDAO {
	public ArrayList<Product> viewProducts(int key){
		System.out.println("Inside ViewProductDAO");
		ArrayList<Product> productList = new ArrayList<>();
		ConnectionHelper helper = new ConnectionHelper() ;
		Connection conn = helper.getDBConnection() ;
		try {
				String query= "select * from product where seller_id= ?" ;
			PreparedStatement pstmt = conn.prepareStatement(query) ;
			pstmt.setInt(1, key);
			System.out.println(key);
			System.out.println("pstmt = " + pstmt) ;
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				productList.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getInt(8), rs.getDouble(9)));
			}
			//return productList;
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return null;
		System.out.println(productList);
		return productList;
	}
}
