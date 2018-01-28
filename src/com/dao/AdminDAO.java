package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.beans.*;

public class AdminDAO {
	public ArrayList<User> getUsers(JdbcTemplate jdbcTemplate, User searchDetails) {
		String query = 	" SELECT EMAIL, USERTYPE, FIRSTNAME, LASTNAME, GENDER, CONTACTNO, ISACTIVE, ISAPPROVED FROM USERS "
				+ 		" WHERE EMAIL LIKE ? "
				+ 		" AND USERTYPE LIKE ? "
				+ 		" AND FIRSTNAME LIKE ? "
				+ 		" AND LASTNAME LIKE ? "
				+ 		" AND GENDER LIKE ? "
				+ 		" AND CONTACTNO LIKE ? "
				+ 		" AND ISACTIVE LIKE ? "
				+ 		" AND ISAPPROVED LIKE ? "
				+ 		" AND USERTYPE <> 'ADMIN' "
				+ 		" ORDER BY EMAIL " ;
		
		String[] qString = {
								"%" + searchDetails.getEmail() + "%" ,
								"%" + searchDetails.getUserType() + "%" ,
								"%" + searchDetails.getFirstName() + "%" , 
								"%" + searchDetails.getLastName() + "%" ,
								"%" + searchDetails.getGender() + "%" ,
								"%" + searchDetails.getContactNo() + "%" ,
								"%" + searchDetails.getIsActiveString() + "%" ,
								"%" + searchDetails.getIsApprovedString() + "%"
							} ;
		System.out.println(query) ;
		ArrayList<User> userList = (ArrayList<User>) jdbcTemplate.query(query, qString, new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				String email = rs.getString(1) ;
				String userType = rs.getString(2) ;
				String firstName = rs.getString(3) ;
				String lastName = rs.getString(4) ;
				String gender = rs.getString(5) ;
				String contactNo = rs.getString(6) ;
				int isActiveInt = rs.getInt(7) ;
				int isApprovedInt = rs.getInt(8) ;
				
				User user = new User(email, userType, firstName, lastName, gender, contactNo, isActiveInt, isApprovedInt) ;
				System.out.println("user.email = " + user.getEmail() ) ;
				System.out.println("user.usertype = " + user.getUserType() ) ;
				System.out.println("user.firstName = " + user.getFirstName() ) ;
				System.out.println("user.lastName = " + user.getLastName() ) ;
				System.out.println("user.gender = " + user.getGender() ) ;
				System.out.println("user.contactNo = " + user.getContactNo() ) ;
				System.out.println("user.isActive = " + user.isActive() ) ;
				System.out.println("user.isApproved = " + user.isApproved() ) ;
				return user;
			}
		});
		return userList ;
	}
	
	public boolean deleteUser(JdbcTemplate jdbcTemplate, String email) {
		String query = " UPDATE USERS SET ISACTIVE = FALSE WHERE EMAIL = ? " ;
		int rowCount = jdbcTemplate.update(query, email) ;
		if(rowCount == 1)
			return true ;
		else
			return false ;
		
	}

	public ArrayList<User> getSellerRequests(JdbcTemplate jdbcTemplate) {
		String query = "SELECT EMAIL, FIRSTNAME, LASTNAME, CONTACTNO FROM USERS WHERE ISACTIVE = TRUE AND ISAPPROVED = FALSE " ;
		System.out.println(query) ;
		ArrayList<User> userList = (ArrayList<User>) jdbcTemplate.query(query, new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				String email = rs.getString(1) ;
				String firstName = rs.getString(2) ;
				String lastName = rs.getString(3) ;
				String contact = rs.getString(4) ;
				User user = new User(firstName, lastName, email, contact) ;
				System.out.println("user.email = " + user.getEmail() ) ;
				System.out.println("user.firstName = " + user.getFirstName() ) ;
				System.out.println("user.lastName = " + user.getLastName() ) ;
				System.out.println("user.contact = " + user.getContactNo() ) ;
				return user;
			}
		});
		return userList ;
	}
	
	public boolean approveSeller(JdbcTemplate jdbcTemplate, String email) {
		String query = " UPDATE USERS SET ISAPPROVED = TRUE WHERE EMAIL = ? " ;
		int rowCount = jdbcTemplate.update(query, email) ;
		if(rowCount == 1)
			return true ;
		else
			return false ;
	}
	
	public ArrayList<Order> getOrders(JdbcTemplate jdbcTemplate, Order orderSearch) {
		
		String query = " SELECT ORDERID, CUSTOMERID, TRANSACTIONSTATUS, CONTACTNO, ORDERDATE FROM ORDERS "
				+ " WHERE ORDERID LIKE ? AND CUSTOMERID LIKE ? AND TRANSACTIONSTATUS LIKE ? AND CONTACTNO LIKE ? " ;

		String[] qStrings = {
								"%" + orderSearch.getOrderIDString() + "%" ,
								"%" + orderSearch.getUserEmail() + "%" ,
								"%" + orderSearch.getTransactionStatus() + "%" ,
								"%" + orderSearch.getContactNo() + "%"
							} ;
		System.out.println(query) ;
		ArrayList<Order> orderList = (ArrayList<Order>) jdbcTemplate.query(query, qStrings, new RowMapper<Order>() {
			@Override
			public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
				int orderID = rs.getInt(1) ;
				String customerEmail = rs.getString(2) ;
				int txStatus = rs.getInt(3) ;
				String contactNo = rs.getString(4) ;
				String orderDate = rs.getString(5) ;
				boolean isTxSuccess = (txStatus==0) ? false : true ;

				Order order = new Order(orderID, isTxSuccess, customerEmail, contactNo, orderDate) ;
				System.out.println("order.orderID = " + order.getOrderID() ) ;
				System.out.println("user.isTxSuccess = " + order.isTransactionSuccessful() ) ;
				System.out.println("order.customerEmail = " + order.getUserEmail() ) ;
				System.out.println("order.contactNo = " + order.getContactNo() ) ;
				System.out.println("order.orderDate = " + order.getOrderDate() ) ;
				return order;
			}
		});
		return orderList ;
	}
	
	public ArrayList<ViewOrder_Admin> getOrderDetails(JdbcTemplate jdbcTemplate, String orderID) {
		String query = " SELECT SCP.SHOPPINGCARTPRODUCTID, P.PRODUCTNAME, "
				+ " P.SELLERID, PC.PRODUCTTYPE, PC.CATEGORYNAME, SCP.QUANTITY "
				+ " FROM SHOPPINGCARTPRODUCT SCP, PRODUCT P, PRODUCTCATEGORY PC "
				+ " WHERE SCP.ORDERID = ? "
				+ " AND P.PRODUCTCATEGORYID = PC.PRODUCTCATEGORYID "
				+ " AND P.PRODUCTID = SCP.PRODUCTID " ;
		
		System.out.println(query) ;
		ArrayList<ViewOrder_Admin> viewOrderAdminList =
				(ArrayList<ViewOrder_Admin>) jdbcTemplate.query(query, new String[]{orderID}, new RowMapper<ViewOrder_Admin>() {
			@Override
			public ViewOrder_Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
				int shoppingCartProductID = rs.getInt(1) ;
				String productName = rs.getString(2) ;
				String sellerEmail = rs.getString(3) ;
				String productType = rs.getString(4) ;
				String productCategoryName = rs.getString(5) ;
				int quantity = rs.getInt(6) ;
				ViewOrder_Admin viewOrder_admin = new ViewOrder_Admin(shoppingCartProductID, productName,
																	sellerEmail, productType, productCategoryName, quantity) ;
				System.out.println("viewOrder_admin.shoppingCartProductID = " + viewOrder_admin.getShoppingCartProductID() ) ;
				System.out.println("viewOrder_admin.productName = " + viewOrder_admin.getProductName() ) ;
				System.out.println("viewOrder_admin.sellerEmail = " + viewOrder_admin.getSellerEmail() ) ;
				System.out.println("viewOrder_admin.productType = " + viewOrder_admin.getProductType() ) ;
				System.out.println("viewOrder_admin.productCategoryName = " + viewOrder_admin.getProductCategoryName() ) ;
				System.out.println("viewOrder_admin.quantity = " + viewOrder_admin.getQuantity() ) ;
				return viewOrder_admin ;
			}
		});
		return viewOrderAdminList ;
	}
	
	public ArrayList<SalesByProductType> getSalesByProductTypeAdmin(JdbcTemplate jdbcTemplate, String productType) {
		
		String query = 		" SELECT PC.PRODUCTTYPE, COUNT(*) AS SALES "
						+	" FROM SHOPPINGCARTPRODUCT SCP, PRODUCT P, PRODUCTCATEGORY PC " 
						+	" WHERE P.PRODUCTID = SCP.PRODUCTID "
						+	" AND P.PRODUCTCATEGORYID = PC.PRODUCTCATEGORYID "
						+	" AND PC.PRODUCTTYPE LIKE ? "
						+	" GROUP BY PC.PRODUCTTYPE "
						+	" ORDER BY SALES DESC " ;
		
		String qString = "%" + productType + "%" ;
		System.out.println(query) ;
		ArrayList<SalesByProductType> salesList = (ArrayList<SalesByProductType>) jdbcTemplate.query(query, new String[]{qString}, new RowMapper<SalesByProductType>() {
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
	
	public ArrayList<SalesByProductCategory> getSalesByProductCategoryAdmin(JdbcTemplate jdbcTemplate, String productCategory) {
		
		String query = 		" SELECT PC.PRODUCTCATEGORYID, PC.CATEGORYNAME, PC.PRODUCTTYPE, COUNT(*) AS SALES "
						+	" FROM SHOPPINGCARTPRODUCT SCP, PRODUCT P, PRODUCTCATEGORY PC " 
						+	" WHERE P.PRODUCTID = SCP.PRODUCTID "
						+	" AND P.PRODUCTCATEGORYID = PC.PRODUCTCATEGORYID "
						+	" AND PC.CATEGORYNAME LIKE ? "
						+	" GROUP BY PC.PRODUCTCATEGORYID "
						+	" ORDER BY SALES DESC " ;
		
		String qString = "%" + productCategory + "%" ;
		System.out.println(query) ;
		ArrayList<SalesByProductCategory> salesByProductCategoryList =
				(ArrayList<SalesByProductCategory>) jdbcTemplate.query(query, new String[]{qString}, new RowMapper<SalesByProductCategory>() {
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
}