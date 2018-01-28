package com.service;

import java.util.ArrayList;
import org.springframework.jdbc.core.JdbcTemplate;

import com.beans.*;
import com.dao.* ;

public class AdminService {
	
	public ArrayList<User> getUsers(JdbcTemplate jdbcTemplate, User user) {
		AdminDAO aDao = new AdminDAO() ;
		return aDao.getUsers(jdbcTemplate, user) ;
	}
	
	public boolean deleteUser(JdbcTemplate jdbcTemplate, String email) {
		AdminDAO aDao = new AdminDAO() ;
		return aDao.deleteUser(jdbcTemplate, email) ;
	}
	
	public ArrayList<User> getSellerRequests(JdbcTemplate jdbcTemplate) {
		AdminDAO aDao = new AdminDAO() ;
		return aDao.getSellerRequests(jdbcTemplate) ;
	}
	
	public boolean approveSeller(JdbcTemplate jdbcTemplate, String email) {
		AdminDAO aDao = new AdminDAO() ;
		return aDao.approveSeller(jdbcTemplate, email) ;
	}
	
	public boolean rejectSeller(JdbcTemplate jdbcTemplate, String email) {
		AdminDAO aDao = new AdminDAO() ;
		return aDao.deleteUser(jdbcTemplate, email) ;
	}
	
	public ArrayList<Order> getOrders(JdbcTemplate jdbcTemplate, Order order) {
		AdminDAO aDao = new AdminDAO() ;
		return aDao.getOrders(jdbcTemplate, order) ;
	}
	
	public ArrayList<ViewOrder_Admin> getOrderDetails(JdbcTemplate jdbcTemplate, String orderID) {
		AdminDAO aDao = new AdminDAO() ;
		return aDao.getOrderDetails(jdbcTemplate, orderID) ;
	}
	
	public ArrayList<SalesByProductType> getSalesByProductTypeAdmin(JdbcTemplate jdbcTemplate, String productType) {
		AdminDAO aDao = new AdminDAO() ;
		if(productType.equals("ALL")) {
			productType = "" ;
		}
		return aDao.getSalesByProductTypeAdmin(jdbcTemplate, productType) ;
	}
	
	public ArrayList<SalesByProductCategory> getSalesByProductCategoryAdmin(JdbcTemplate jdbcTemplate, String productCategory) {
		AdminDAO aDao = new AdminDAO() ;
		if(productCategory.equals("ALL")) {
			productCategory = "" ;
		}
		return aDao.getSalesByProductCategoryAdmin(jdbcTemplate, productCategory) ;
	}
}
