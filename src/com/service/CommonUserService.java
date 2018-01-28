package com.service;

import org.springframework.jdbc.core.JdbcTemplate;

import com.beans.User;
import com.dao.CommonUserDAO;
import com.exceptions.*;

public class CommonUserService {

	public boolean registerUser(User user, JdbcTemplate jdbcTemplate) throws UserAlreadyRegistered, RegistrationException {
		CommonUserDAO cuDAO = new CommonUserDAO() ;
		if(cuDAO.isUserRegistered(user.getEmail(), jdbcTemplate)) {
			throw new UserAlreadyRegistered() ;
		}
		else {
			boolean regFlag = cuDAO.registerUser(user, jdbcTemplate) ;
			if(regFlag)
				return true ;
			else
				throw new RegistrationException() ;
		}
	}
	
	public String isValidUser(String email, String password, String userType, JdbcTemplate jdbcTemplate) {
		System.out.println("Inside CommonUserService.isValidUser") ;
		CommonUserDAO cuDAO = new CommonUserDAO() ;
		
		if(cuDAO.isUserDisabled(email, jdbcTemplate)) {
			return "Your profile is disabled. Please contact administrator" ;
		}
		
		if(! cuDAO.isValidUser(email, password, userType, jdbcTemplate)) {
			return "Incorrect credentials" ;
		}
		
		else {
			return "CORRECT" ;
		}
	}
}
