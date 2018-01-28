package com.st.dao.DAOImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.beans.Feature;
import com.st.beans.Product;
import com.st.dao.ProductDAO;
@Component
public class ProductDAOImpl implements ProductDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Product> getProductList(){
		// TODO Auto-generated method stub
		String query="select * from product"; 
		System.out.println(query);
		System.out.println(jdbcTemplate.isResultsMapCaseInsensitive());
		return jdbcTemplate.query(query, new MyrowMapper());
	}

	@Override
	public Product getProductbyId(int Id) {
		String query="select * from product where productid='"+Id+"'";
		System.out.println(query);
		return jdbcTemplate.queryForObject(query, new MyrowMapper());
	}

	@Override
	public int addProduct(Product product) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delProduct(Product product) {
		// TODO Auto-generated method stub

	}

	@Override
	public void editProduct(Product product) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Product> getProductsbyCategory(String categoryName) {
		// TODO Auto-generated method stub
		String query="select * from product p, productcategory pc where pc.categoryname like '%"+categoryName+"%'"
				+ " and pc.productcategoryid=p.productcategoryid";
		return jdbcTemplate.query(query, new MyrowMapper());
	}
	
	@Override
	public List<Product> getProductsbySellerID(String sellerID) {
		String query=" SELECT * FROM PRODUCT WHERE SELLERID = ? " ;
		return jdbcTemplate.query(query, new String[]{sellerID}, new MyrowMapper());
	}
	
	@Override
	public List<Product> getRecentlyViewedProducts(String customerEmail) {
		String query =	" SELECT * FROM PRODUCT WHERE PRODUCTID IN "
					+ 	" ( SELECT PRODUCTID FROM VIEWEDPRODUCTS WHERE CUSTOMEREMAIL = ? "
					+ 	" AND DATE_SUB(NOW(),INTERVAL 7 DAY) <= VIEWEDDATE ORDER BY VIEWEDDATE DESC ) " ;
		return jdbcTemplate.query(query, new String[]{customerEmail}, new MyrowMapper()) ;
	}
	
	@Override
	public List<Product> getFilteredProducts(String categoryName, ArrayList<String> brands, ArrayList<Feature> features) {
		String query = " SELECT * FROM PRODUCT " ;
		
		query += " WHERE PRODUCTCATEGORYID = " ;
		query += " ( SELECT PRODUCTCATEGORYID FROM PRODUCTCATEGORY " ;
		query += " WHERE CATEGORYNAME = '" + categoryName + "') " ;
		
		if(features != null && features.size() > 0) {
			query += " AND PRODUCTID IN ( SELECT DISTINCT (PRODUCTID) FROM FEATURE WHERE " ;
			
			for(int i=0 ; i<features.size() ; i++) {
				Feature feature = features.get(i) ;
				query += " FEATURETEMPLATEID = '" + feature.getFeatureID() + "'";
				ArrayList<String> featureValues = feature.getFeatureValues() ;
				
				if(featureValues != null && featureValues.size() > 0) {
					query += " AND FEATUREVALUE IN ( " ;
					
					for(int j=0 ; j<featureValues.size() ; j++) {
						query += "'" + featureValues.get(j) + "'" ;
						if(j < featureValues.size()-1) {
							query += " , " ;
						}
					}
					query += " ) " ;
				}
				if(i < features.size()-1) {
					query += " OR " ;
				}
			}
			query += " ) " ;
		}
		
		if(brands != null && brands.size() > 0) {
			query += " AND BRANDNAME IN ( " ;
			
			for(int i=0 ; i<brands.size() ; i++) {
				query += "'" + brands.get(i) + "'" ;
				if(i < brands.size()-1) {
					query += " , " ;
				}
			}
			query += " ) " ;
		}
		
		System.out.println("Query in getFilteredProducts= " ) ;
		System.out.println(query) ;
		return jdbcTemplate.query(query, new MyrowMapper());
	}
	
	public int deleteFeatures(String productID) {
		String query = " DELETE FROM FEATURE WHERE PRODUCTID = '" + productID + "'" ;
		return jdbcTemplate.update(query);
	}
	
	public int deleteProduct(String productID) {
		String query = " DELETE FROM PRODUCT WHERE PRODUCTID = ? " ;
		return jdbcTemplate.update(query, productID);
	}
	
	public int modifyProduct(Product product) {
		System.out.println("Inside modifyProduct") ;
		String query = " UPDATE PRODUCT SET PRODUCTNAME = ? , DESCRIPTION = ? , QUANTITY = ? , PRICE = ? WHERE PRODUCTID = ? " ;
		int rowCount = jdbcTemplate.update(query, product.getProductName(), product.getProductDescription(),
				product.getProductQuantity(), product.getProductCost(), product.getProductId() ) ;
		return rowCount ;
	}
	
	public int getOrders(int productId,String customerId) {
		// TODO Auto-generated method stub
		String query="SELECT COUNT(*)  FROM shoppingcartproduct scp,orders o where productid='"+productId+"' "
				+ "and scp.orderid=o.orderid and customerid='"+customerId+"'";
		return jdbcTemplate.queryForInt(query);
	}
	
	public int updatePassword(String email,String password){
		String query="UPDATE USERS SET PASSWORD='"+password+"' where email='"+email+"'";
		System.out.println(query);
		return jdbcTemplate.update(query);
	}

	public int isvalidId(String email) {
		// TODO Auto-generated method stub
		String query="SELECT COUNT(*) FROM USERS WHERE EMAIL='"+email+"'";
		return jdbcTemplate.queryForInt(query);
	}
}
