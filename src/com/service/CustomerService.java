package com.service;

import java.util.ArrayList;
import org.springframework.jdbc.core.JdbcTemplate;
import com.beans.Order;
import com.beans.ViewOrder;
import com.dao.CustomerDAO ;

public class CustomerService {
	
	public ArrayList<Order> getOrders(JdbcTemplate jdbcTemplate, String email) {
		CustomerDAO cDao = new CustomerDAO() ;
		return cDao.getOrders(jdbcTemplate, email) ;
	}
	
	public ArrayList<ViewOrder> getOrderDetails(JdbcTemplate jdbcTemplate, String orderID) {
		CustomerDAO cDao = new CustomerDAO() ;
		return cDao.getOrderDetails(jdbcTemplate, orderID) ;
	}
	
	public boolean addRecentlyViewedProduct(JdbcTemplate jdbcTemplate, String userEmail, int productID) {
		CustomerDAO cDao = new CustomerDAO() ;
		return cDao.addRecentlyViewedProduct(jdbcTemplate, userEmail, productID) ;
	}

}