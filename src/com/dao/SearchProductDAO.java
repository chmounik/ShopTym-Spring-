package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.st.beans.Product;
import com.st.utils.ConnectionHelper;

public class SearchProductDAO {
	public ArrayList<Product> serchProducts(String key, String type) {
		System.out.println("Inside AddProductDAO");
		ArrayList<Product> productList = new ArrayList<>();
		ConnectionHelper helper = new ConnectionHelper();
		Connection conn = helper.getDBConnection();
		try {
			String query;
			if(type.equalsIgnoreCase("All"))
				type="";
			//if (type.equalsIgnoreCase("PRODUCTTYPE")) {
				//System.out.println("Inside If of searchProducts");
				query = " SELECT P.PRODUCTID, P.PRODUCTNAME, P.SELLERID, P.BRANDNAME, P.PRODUCTCATEGORYID, "
						+ " P.PRODUCTADDRESSID, P.DESCRIPTION, P.QUANTITY, P.PRICE "
						+ " FROM PRODUCT P INNER JOIN PRODUCTCATEGORY PC "
						+ " ON P.productcategoryid=PC.productcategoryid "
						+ " where PC.producttype like ? and p.description like '%"+key+"%'";
			//}
			//else {
				//productId, String productName, String sellerId, String productBrand, int productCategoryId, int productAddressId,
				//String productDescription, int productQuantity, double productCost
//				System.out.println("Inside Else of serchProducts");
//				query = " SELECT PRODUCTID, PRODUCTNAME, SELLERID, BRANDNAME, PRODUCTCATEGORYID, "
//						+ " PRODUCTADDRESSID, DESCRIPTION, QUANTITY, PRICE "
//						+ " FROM PRODUCT WHERE " + type + " LIKE ? ";
			//}
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, '%' + type + '%');
			System.out.println('%' + type + '%');
			System.out.println("pstmt = " + pstmt);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				productList.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getInt(8), rs.getDouble(9)));
			}
			// return productList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// return null;
		System.out.println(productList);
		return productList;
	}

}
