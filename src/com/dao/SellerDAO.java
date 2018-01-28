package com.dao ;

import java.sql.ResultSet ;
import java.sql.SQLException ;
import java.util.ArrayList ;
import org.springframework.jdbc.core.JdbcTemplate ;
import org.springframework.jdbc.core.RowMapper ;

import com.beans.PendingOrder ;
import com.beans.SalesByProductCategory;
import com.beans.SalesByProductType;

public class SellerDAO {
	
	public ArrayList<PendingOrder> getOrders(JdbcTemplate jdbcTemplate, String email) {
		String query = " SELECT P.PRODUCTNAME, SCP.QUANTITY "
				+ " FROM PRODUCT P, SHOPPINGCARTPRODUCT SCP, SHIPMENT S "
				+ " WHERE P.SELLERID = ? "
				+ " AND SCP.PRODUCTID = P.PRODUCTID "
				+ " AND S.SHOPPINGCARTPRODUCTID = SCP.SHOPPINGCARTPRODUCTID "
				+ " AND S.SHIPMENTSTATUS = 'TOBESHIPPED' " ;
		
		ArrayList<PendingOrder> pendingOrderList = (ArrayList<PendingOrder>) jdbcTemplate.query(query, new String[] { email },
				new RowMapper<PendingOrder>() {
					@Override
					public PendingOrder mapRow(ResultSet rs, int rowNum) throws SQLException {
						String productName = rs.getString(1) ;
						int quantity = rs.getInt(2) ;
						PendingOrder pendingOrder = new PendingOrder(productName, quantity) ;
						System.out.println("pendingOrder.productName = " + pendingOrder.getProductName()) ;
						System.out.println("pendingOrder.quantity = " + pendingOrder.getQuantity()) ;
						return pendingOrder ;
					}
				}) ;
		return pendingOrderList ;
	}
	
	public ArrayList<SalesByProductType> getSalesByProductTypeSeller(JdbcTemplate jdbcTemplate,
			String productType, String sellerEmail) {
		
		String query = 		" SELECT PC.PRODUCTTYPE, COUNT(*) AS SALES "
						+	" FROM SHOPPINGCARTPRODUCT SCP, PRODUCT P, PRODUCTCATEGORY PC " 
						+	" WHERE P.PRODUCTID = SCP.PRODUCTID "
						+	" AND P.PRODUCTCATEGORYID = PC.PRODUCTCATEGORYID "
						+	" AND PC.PRODUCTTYPE LIKE ? "
						+	" AND P.SELLERID = ? "
						+	" GROUP BY PC.PRODUCTTYPE "
						+	" ORDER BY SALES DESC " ;
		
		String qString = "%" + productType + "%" ;
		System.out.println(query) ;
		ArrayList<SalesByProductType> salesList =
				(ArrayList<SalesByProductType>) jdbcTemplate.query(query, new String[]{qString, sellerEmail}, new RowMapper<SalesByProductType>() {
			@Override
			public SalesByProductType mapRow(ResultSet rs, int rowNum) throws SQLException {
				String productType = rs.getString(1) ;
				int sales = rs.getInt(2) ;
				SalesByProductType salesByProductType = new SalesByProductType(productType, sales) ;
				System.out.println("salesByProductType.getProductType = " + salesByProductType.getProductType() ) ;
				System.out.println("salesByProductType.getSales = " + salesByProductType.getSales() ) ;
				return salesByProductType ;
			}
		});
		return salesList ;
	}
	
	public ArrayList<SalesByProductCategory> getSalesByProductCategorySeller(JdbcTemplate jdbcTemplate,
			String productCategory, String sellerEmail) {
		
		String query = 		" SELECT PC.PRODUCTCATEGORYID, PC.CATEGORYNAME, PC.PRODUCTTYPE, COUNT(*) AS SALES "
						+	" FROM SHOPPINGCARTPRODUCT SCP, PRODUCT P, PRODUCTCATEGORY PC " 
						+	" WHERE P.PRODUCTID = SCP.PRODUCTID "
						+	" AND P.PRODUCTCATEGORYID = PC.PRODUCTCATEGORYID "
						+	" AND PC.CATEGORYNAME LIKE ? "
						+	" AND P.SELLERID = ? "
						+	" GROUP BY PC.PRODUCTCATEGORYID "
						+	" ORDER BY SALES DESC " ;
		
		String qString = "%" + productCategory + "%" ;
		System.out.println(query) ;
		ArrayList<SalesByProductCategory> salesByProductCategoryList =
				(ArrayList<SalesByProductCategory>) jdbcTemplate.query(query, new String[]{qString, sellerEmail}, new RowMapper<SalesByProductCategory>() {
			@Override
			public SalesByProductCategory mapRow(ResultSet rs, int rowNum) throws SQLException {
				int productCategoryID = rs.getInt(1) ;
				String categoryName = rs.getString(2) ;
				String productType = rs.getString(3) ;
				int sales = rs.getInt(4) ;

				SalesByProductCategory salesByProductCategory = 
						new SalesByProductCategory(productCategoryID, categoryName, productType, sales) ;
				System.out.println("salesByProductCategory.getProductCategoryID = " + salesByProductCategory.getProductCategoryID() ) ;
				System.out.println("salesByProductCategory.getCategoryName = " + salesByProductCategory.getCategoryName() ) ;
				System.out.println("salesByProductCategory.getProductType = " + salesByProductCategory.getProductType() ) ;
				System.out.println("salesByProductCategory.getSales = " + salesByProductCategory.getSales() ) ;
				return salesByProductCategory ;
			}
		});
		return salesByProductCategoryList ;
	}

	public boolean isSellerForProduct(JdbcTemplate jdbcTemplate, String userEmail, int productId) {
		System.out.println("Inside SellerDAO.isSellerForProduct") ;
		String query = "SELECT COUNT(SELLERID) FROM PRODUCT WHERE SELLERID = ? AND PRODUCTID = ? " ;
		System.out.println("query = " + query) ;
		if(jdbcTemplate == null) {
			System.out.println("jdbcTemplate is null") ;
		}
		
		int rowCount = jdbcTemplate.queryForObject (query, new Object[]{userEmail, productId}, Integer.class);
		
		if(rowCount == 1) {
			return true ;
		}
			
		else {
			return false ;
		}
	}
}

/*
SELECT P.PRODUCTNAME, SCP.QUANTITY
FROM PRODUCT P, SHOPPINGCARTPRODUCT SCP, SHIPMENT S

WHERE P.SELLERID = 'seller2'
AND SCP.PRODUCTID = P.PRODUCTID
AND S.SHOPPINGCARTPRODUCTID = SCP.SHOPPINGCARTPRODUCTID
AND S.SHIPMENTSTATUS = 'TOBESHIPPED'
*/