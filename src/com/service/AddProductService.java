package com.service;

import java.util.ArrayList;

import org.springframework.jdbc.core.JdbcTemplate;

import com.beans.Feature;
import com.beans.FeatureIDValuePair;
import com.beans.ProductCategoryIDMap;
import com.dao.*;

public class AddProductService {
	public boolean addProduct(JdbcTemplate jdbcTemplate, String productName,String sellerId,String productCategory,
			String productDescription, String productQuantity,String productPrice, String brandName) {
		boolean isProductAdded = false ;
		AddProductDAO apDAO = new AddProductDAO() ;
		String nextProductID = apDAO.getNextProductID(jdbcTemplate) ;
		isProductAdded = apDAO.addProduct(nextProductID, productName,sellerId,productCategory,
				productDescription,productQuantity,productPrice,brandName);
		return isProductAdded ;
	}
	
	public ArrayList<ProductCategoryIDMap> getProductCategories(JdbcTemplate jdbcTemplate) {
		AddProductDAO apDAO = new AddProductDAO() ;
		return apDAO.getProductCategories(jdbcTemplate) ;
	}
	
	public boolean isAllowedToAddProduct(JdbcTemplate jdbcTemplate, String sellerEmail) {
		AddProductDAO apDAO = new AddProductDAO() ;
		return apDAO.isAllowedToAddProduct(jdbcTemplate, sellerEmail) ;
	}
	
	public ArrayList<Feature> getFeatures(JdbcTemplate jdbcTemplate, String productCategoryID) {
		AddProductDAO apDAO = new AddProductDAO() ;
		return apDAO.getFeatures(jdbcTemplate, productCategoryID) ;
	}
	
	public boolean addFeatures(ArrayList<FeatureIDValuePair> features, JdbcTemplate jdbcTemplate) {

		System.out.println("Inside AddProductService.addFeatures") ;
		AddProductDAO apDAO = new AddProductDAO() ;
		String productID = apDAO.getProductID(jdbcTemplate) ;
		
		boolean isAllInserted = true, temp ;
		for(FeatureIDValuePair feature: features) {
			temp = apDAO.insertFeature(productID, feature, jdbcTemplate) ;
			if(!temp) {
				isAllInserted = false ;
			}
		}
		return isAllInserted ;
	}
}
