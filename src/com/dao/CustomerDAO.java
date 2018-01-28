package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.beans.Order;
import com.beans.ViewOrder;

public class CustomerDAO {
	public ArrayList<Order> getOrders(JdbcTemplate jdbcTemplate, String email) {
		String query = "SELECT ORDERID, TRANSACTIONSTATUS FROM ORDERS WHERE CUSTOMERID = ? " ;
		System.out.println(query) ;
		ArrayList<Order> orderList = (ArrayList<Order>) jdbcTemplate.query(query, new String[]{email}, new RowMapper<Order>() {
			@Override
			public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
				int orderID = rs.getInt(1) ;
				String orderStatus = rs.getString(2) ;
				Order order = new Order(orderID, orderStatus) ;
				System.out.println("order.orderID = " + order.getOrderID() ) ;
				System.out.println("user.usertype = " + order.getOrderStatus() ) ;
				return order;
			}
		});
		return orderList ;
	}
	
	public ArrayList<ViewOrder> getOrderDetails(JdbcTemplate jdbcTemplate, String orderID) {
		String query = "SELECT P.PRODUCTNAME, SCP.QUANTITY FROM SHOPPINGCARTPRODUCT SCP, PRODUCT P " +
						" WHERE SCP.ORDERID = ? AND P.PRODUCTID = SCP.PRODUCTID " ;
		System.out.println(query) ;
		ArrayList<ViewOrder> viewOrderList =
				(ArrayList<ViewOrder>) jdbcTemplate.query(query, new String[]{orderID}, new RowMapper<ViewOrder>() {
			@Override
			public ViewOrder mapRow(ResultSet rs, int rowNum) throws SQLException {
				String productName = rs.getString(1) ;
				int quantity = rs.getInt(2) ;
				ViewOrder viewOrder = new ViewOrder(productName, quantity) ;
				System.out.println("viewOrder.productName = " + viewOrder.getProductName() ) ;
				System.out.println("viewOrder.quantity = " + viewOrder.getQuantity() ) ;
				return viewOrder ;
			}
		});
		return viewOrderList ;
	}
	
	public boolean addRecentlyViewedProduct(JdbcTemplate jdbcTemplate, String userEmail, int productID) {
		System.out.println("Inside CustomerDAO.addRecentlyViewedProduct") ;
		String query = 	" INSERT INTO VIEWEDPRODUCTS (CUSTOMEREMAIL , PRODUCTID , VIEWEDDATE) "
					+	" VALUES ( ? , ? , NOW() ) " ;
		System.out.println("query = " + query) ;
		Object[] queryObjects = { userEmail , productID } ;
		int[] types = new int[] { Types.VARCHAR, Types.INTEGER } ;
		int rowCount = jdbcTemplate.update(query, queryObjects, types) ;
		
		if(rowCount == 1) {
			return true ;
		}
		else {
			return false ;
		}
	}
}
