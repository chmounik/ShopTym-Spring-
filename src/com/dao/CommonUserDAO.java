package com.dao;

import java.sql.Types;

import org.springframework.jdbc.core.JdbcTemplate;

import com.beans.User;
import com.utils.UserRoles ;

public class CommonUserDAO {

	public boolean registerUser(User user, JdbcTemplate jdbcTemplate) {

		System.out.println("Inside CommonUserDAO.registerUser") ;
		String query = "INSERT INTO USERS (EMAIL, USERTYPE, PWD, FIRSTNAME, "
				+ "LASTNAME, CONTACTNO, GENDER, ISAPPROVED, ISACTIVE) VALUES (?, ?, ?, ?, ?, ?, ?, TRUE, " ;
		
		String isRegisteredStr = "TRUE ) " ;
		if(user.getUserType().equals(UserRoles.SELLER)) {
			isRegisteredStr = "FALSE ) " ;
		}
		
		query += isRegisteredStr ;
		
		Object[] queryObjects = {
									user.getEmail(),
									user.getUserType(),
									user.getPassword(),
									user.getFirstName(),
									user.getLastName(),
									user.getContactNo(),
									user.getGender()
								} ;
		int[] types = new int[] { 	Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
									Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
									Types.VARCHAR } ;
		int rowCount = jdbcTemplate.update(query, queryObjects, types) ;
		
		if(rowCount == 1)
			return true ;
		else
			return false ;
	}
	
	public boolean isUserRegistered(String email, JdbcTemplate jdbcTemplate) {
		System.out.println("Inside CommonUserDAO.isUserRegistered") ;
		
		String query = "SELECT COUNT(EMAIL) FROM USERS WHERE EMAIL = ? " ;
		if(jdbcTemplate == null)
			System.out.println("jdbcTemplate is null") ;
		int rowCount = jdbcTemplate.queryForObject
				(query, new Object[]{email}, Integer.class);
		
		if(rowCount == 1)
			return true ;
		else
			return false ;
	}
	
	public boolean isUserDisabled(String email, JdbcTemplate jdbcTemplate) {
		System.out.println("Inside CommonUserDAO.isUserDisabled") ;
		String query = "SELECT COUNT(EMAIL) FROM USERS WHERE EMAIL = ? AND ISACTIVE = FALSE " ;
		if(jdbcTemplate == null)
			System.out.println("jdbcTemplate is null") ;
		int rowCount = jdbcTemplate.queryForObject
				(query, new Object[]{email}, Integer.class);
		
		if(rowCount == 1)
			return true ;
		else
			return false ;
	
	}
	
	public boolean isValidUser(String email, String password, String userType, JdbcTemplate jdbcTemplate) {
		System.out.println("Inside CommonUserDAO.isValidUser") ;
		String query = "SELECT COUNT(EMAIL) FROM USERS WHERE EMAIL = ? AND USERTYPE = ? AND PWD = ? " ;
		if(jdbcTemplate == null)
			System.out.println("jdbcTemplate is null") ;
		int rowCount = jdbcTemplate.queryForObject
				(query, new Object[]{email, userType, password}, Integer.class);
		
		if(rowCount == 1)
			return true ;
		else
			return false ;
	}
}
