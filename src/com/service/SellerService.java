package com.service;

import java.util.ArrayList;

import org.springframework.jdbc.core.JdbcTemplate;

import com.beans.* ;
import com.dao.SellerDAO;

public class SellerService {
	
	public ArrayList<PendingOrder> getOrders(JdbcTemplate jdbcTemplate, String email) {
		SellerDAO sDao = new SellerDAO() ;
		return sDao.getOrders(jdbcTemplate, email) ;
	}
	
	public ArrayList<SalesByProductType> getSalesByProductTypeSeller(JdbcTemplate jdbcTemplate,
			String productType, String sellerEmail) {
		SellerDAO sDao = new SellerDAO() ;
		
		if(productType.equals("ALL")) {
			productType = "" ;
		}
		return sDao.getSalesByProductTypeSeller(jdbcTemplate, productType, sellerEmail) ;
	}
	
	public ArrayList<SalesByProductCategory> getSalesByProductCategorySeller(JdbcTemplate jdbcTemplate,
			String productCategory, String sellerEmail) {
		SellerDAO sDao = new SellerDAO() ;
		if(productCategory.equals("ALL")) {
			productCategory = "" ;
		}
		return sDao.getSalesByProductCategorySeller(jdbcTemplate, productCategory, sellerEmail) ;
	}

	public boolean isSellerForProduct(JdbcTemplate jdbcTemplate, String userEmail, int productId) {
		SellerDAO sDao = new SellerDAO() ;
		return sDao.isSellerForProduct(jdbcTemplate, userEmail, productId) ;
	}
}