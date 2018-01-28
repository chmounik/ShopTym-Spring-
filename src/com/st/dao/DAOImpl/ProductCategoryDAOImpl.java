package com.st.dao.DAOImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.st.dao.ProductCategoryDAO;
@Component
public class ProductCategoryDAOImpl implements ProductCategoryDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	@Override
	public String getProductType(int productCategoryId) throws Exception {
		// TODO Auto-generated method stub
		String query="select categoryname from productcategory where productcategoryid='"+productCategoryId+"'";
		return (String)jdbcTemplate.queryForObject(query, String.class);
	}

}