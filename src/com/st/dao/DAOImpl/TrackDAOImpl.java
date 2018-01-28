package com.st.dao.DAOImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import com.st.dao.TrackDAO;
@Component
public class TrackDAOImpl implements TrackDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public String trackOrder(int id){
		System.out.println("Inside trackOrder") ;
		String query="SELECT shipmentstatus from SHIPMENT, SHOPPINGCARTPRODUCT "
				+ "where SHIPMENT.SHOPPINGCARTPRODUCTID = SHOPPINGCARTPRODUCT.SHOPPINGCARTPRODUCTID "
				+ "AND SHOPPINGCARTPRODUCT.SHOPPINGCARTPRODUCTID ='"+id+"'";
		System.out.println(query);
		return jdbcTemplate.queryForObject(query, String.class);
		
	}

}
