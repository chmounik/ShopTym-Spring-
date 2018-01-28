package com.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.st.utils.ConnectionHelper;
import com.beans.Feature;
import com.beans.FeatureIDValuePair;
import com.beans.ProductCategoryIDMap;

public class AddProductDAO {
	public boolean addProduct(String productID, String productName, String sellerId, String productCategory,
			String productDescription, String productQuantity, String productPrice, String brandName) {
		System.out.println("Inside AddProductDAO");
		boolean isChanged = false;
		ConnectionHelper helper = new ConnectionHelper();

		Connection conn = helper.getDBConnection();
		// String query1 = "SELECT EMAIL FROM USER WHERE EMAIL = 'a@b.com' AND
		// PASSWORD='password'" ;
		/*
		 * String query1 =
		 * "INSERT INTO USER (EMAIL, USERTYPE, PASSWORD, FIRSTNAME, " +
		 * "LASTNAME, CONTACTNO, GENDER) VALUES ( " ; query1 += "'" +
		 * user.getEmail() + "', " ; query1 += "'" + user.getUserType() + "', "
		 * ; query1 += "'" + user.getPassword() + "', " ; query1 += "'" +
		 * user.getFirstName() + "', " ; query1 += "'" + user.getLastName() +
		 * "', " ; query1 += "'" + user.getContactNo() + "', " ; query1 += "'" +
		 * user.getGender() + "' ) ; " ;
		 */

		String query1 = " INSERT INTO PRODUCT ( PRODUCTID, PRODUCTNAME, SELLERID, "
				+ "PRODUCTCATEGORYID, DESCRIPTION, QUANTITY, PRICE, BRANDNAME ) "
				+ " VALUES ( ?, ? , ? , ? , ? , ? , ? , ? ) ";

		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(query1);
			pstmt.setString(1, productID);
			pstmt.setString(2, productName);
			pstmt.setString(3, sellerId);
			pstmt.setString(4, productCategory);
			pstmt.setString(5, productDescription);
			pstmt.setString(6, productQuantity);
			pstmt.setString(7, productPrice);
			pstmt.setString(8, brandName);
			System.out.println(pstmt);

			int rowsChanged = pstmt.executeUpdate();

			if (rowsChanged > 0)
				isChanged = true;
			pstmt.close();
			conn.close();
			/*
			 * rs.close(); pstmt.close() ; conn.close();
			 */
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return isChanged;
	}

	public String getNextProductID(JdbcTemplate jdbcTemplate) {
		String query = "SELECT (MAX(PRODUCTID) + 1) AS PRODUCTID FROM PRODUCT";
		String nextProductID = jdbcTemplate.queryForObject(query, String.class);
		return nextProductID;
	}
	
	public String getProductID(JdbcTemplate jdbcTemplate) {
		String query = "SELECT MAX(PRODUCTID) AS PRODUCTID FROM PRODUCT ";
		String nextProductID = jdbcTemplate.queryForObject(query, String.class);
		return nextProductID;
	}

	public ArrayList<ProductCategoryIDMap> getProductCategories(JdbcTemplate jdbcTemplate) {
		System.out.println("Inside getProductCategories");
		String query = " SELECT PRODUCTCATEGORYID , CATEGORYNAME FROM PRODUCTCATEGORY ";

		System.out.println(query);
		ArrayList<ProductCategoryIDMap> productCategories = (ArrayList<ProductCategoryIDMap>) jdbcTemplate.query(query,
				new RowMapper<ProductCategoryIDMap>() {
					@Override
					public ProductCategoryIDMap mapRow(ResultSet rs, int rowNum) throws SQLException {
						String productCategoryID = rs.getString(1);
						String categoryName = rs.getString(2);

						ProductCategoryIDMap productCategoryMap = new ProductCategoryIDMap(productCategoryID,
								categoryName);
						System.out.println("productCategoryMap.getProductCategoryID = "
								+ productCategoryMap.getProductCategoryID());
						System.out.println(
								"productCategoryMap.getCategoryName = " + productCategoryMap.getCategoryName());
						return productCategoryMap;
					}
				});
		return productCategories;
	}
	
	public boolean isAllowedToAddProduct(JdbcTemplate jdbcTemplate, String sellerEmail) {
		System.out.println("Inside AddProductDAO.isAllowedToAddProduct") ;
		String query = " SELECT COUNT(EMAIL) FROM USERS WHERE EMAIL = ? AND (ISAPPROVED = false OR ISACTIVE = false) " ;
		int rowCount = jdbcTemplate.queryForObject(query, new Object[]{sellerEmail}, Integer.class);
		
		if(rowCount == 1)
			return false ;
		else
			return true ;
	}
	
	public ArrayList<Feature> getFeatures(JdbcTemplate jdbcTemplate, String productCategoryID) {
		System.out.println("Inside getFeatures") ;
		String query = " SELECT FEATURETEMPLATEID, FEATURENAME FROM FEATURETEMPLATE WHERE PRODUCTCATEGORYID = ? " ;
		
		System.out.println(query);
		ArrayList<Feature> featureTemplateList =
				(ArrayList<Feature>) jdbcTemplate.query(query, new String[]{productCategoryID}, new RowMapper<Feature>() {
					@Override
					public Feature mapRow(ResultSet rs, int rowNum) throws SQLException {
						String featureTemplateID = rs.getString(1);
						String featureName = rs.getString(2);

						Feature feature = new Feature(featureTemplateID, featureName) ;
						System.out.println("feature.featureTemplateID = " + feature.getFeatureID());
						System.out.println("feature.featureName = " + feature.getFeatureName());
						return feature ;
					}
				});
		return featureTemplateList ;
	}
	
	public boolean insertFeature(String productID, FeatureIDValuePair feature, JdbcTemplate jdbcTemplate) {

		System.out.println("Inside insertFeatures") ;
		String query = " INSERT INTO FEATURE (PRODUCTID, FEATURETEMPLATEID, FEATUREVALUE ) "
				+ " VALUES ( ? , ? , ? ) " ;
		
		Object[] queryObjects = { productID, feature.getFeatureID(), feature.getFeatureValue() } ;
		int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR } ;
		int rowCount = jdbcTemplate.update(query, queryObjects, types) ;
		
		if(rowCount == 1)
			return true ;
		else
			return false ;
	}
}
