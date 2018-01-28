package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.beans.Feature;

public class FeatureDAO {
	
	public ArrayList<Feature> getFeaturesForProductCategory(JdbcTemplate jdbcTemplate, String productCategory) {
		System.out.println("Inside getFeaturesForProductCategory") ;
		productCategory = "'" + productCategory + "'" ;
		String query = " SELECT FEATURETEMPLATEID, FEATURENAME FROM FEATURETEMPLATE WHERE PRODUCTCATEGORYID = "
				+ " ( SELECT PRODUCTCATEGORYID FROM PRODUCTCATEGORY WHERE CATEGORYNAME = " + productCategory + " ) " ;
		System.out.println(query);

		ArrayList<Feature> features = (ArrayList<Feature>) jdbcTemplate.query(query, new RowMapper<Feature>() {
					@Override
					public Feature mapRow(ResultSet rs, int rowNum) throws SQLException {
						System.out.println("Inside MapRow of getFeaturesForProductCategory") ;
						String featureID = rs.getString(1) ;
						String featureName = rs.getString(2) ;

						System.out.println("featureID = " + featureID) ;
						System.out.println("featureName = " + featureName) ;
						
						Feature feature = new Feature(featureID, featureName) ;
						return feature;
					}
				});
		features = getDistinctValues(jdbcTemplate, features) ;
		return features;
	}
	
	public ArrayList<String> getBrands(JdbcTemplate jdbcTemplate, String categoryName) {
		System.out.println("Inside getBrands") ;
		String query = 	" SELECT DISTINCT(BRANDNAME) FROM PRODUCT WHERE PRODUCTCATEGORYID =  "
					  + " ( SELECT PRODUCTCATEGORYID FROM PRODUCTCATEGORY WHERE CATEGORYNAME = ? ) " ;
		System.out.println(query);
		
		ArrayList<String> brands =
				(ArrayList<String>) jdbcTemplate.query(query, new String[]{categoryName}, new RowMapper<String>() {
			@Override
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				System.out.println("Inside MapRow of getBrands") ;
				String brand = rs.getString(1) ;
				System.out.println("brand = " + brand) ;
				return brand ;
			}
		});
		return brands ;
	}
	
	public ArrayList<Feature> getDistinctValues(JdbcTemplate jdbcTemplate, ArrayList<Feature> features) {
		System.out.println("Inside getDistinctValues") ;
		String query = 	" SELECT DISTINCT FEATUREVALUE FROM FEATURE "
					  + " WHERE FEATURETEMPLATEID = ? " ;
		System.out.println(query);
		
		for(Feature feature: features) {
			ArrayList<String> featureValues =
					(ArrayList<String>) jdbcTemplate.query(query, new String[]{feature.getFeatureID()}, new RowMapper<String>() {
				@Override
				public String mapRow(ResultSet rs, int rowNum) throws SQLException {
					System.out.println("Inside MapRow of getDistinctValues") ;
					String featureValue = rs.getString(1) ;

					System.out.println("featureValue = " + featureValue) ;
					return featureValue ;
				}
			});
			feature.setFeatureValues(featureValues) ;
		}
		return features ;
	}
	public ArrayList<Feature> getProductDescription(JdbcTemplate jdbcTemplate,int productId){
		String query="select featurename,featurevalue from feature f,featuretemplate ft where "
				+ "f.featuretemplateid=ft.featuretemplateid and productid='"+productId+"'";
		ArrayList<Feature> features = (ArrayList<Feature>) jdbcTemplate.query(query, new RowMapper<Feature>() {
			@Override
			public Feature mapRow(ResultSet rs, int rowNum) throws SQLException {
				String featureName = rs.getString(1) ;
				String featureValue = rs.getString(2) ;
				Feature feature = new Feature(featureName, featureValue) ;
				return feature;
			}
		});
		return features;
	}
}
