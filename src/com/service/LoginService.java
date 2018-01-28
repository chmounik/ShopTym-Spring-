package com.service;

import com.dao.*;

public class LoginService {
//	public boolean validateUserCredentials(String userName, String password,
//			String userType) {
//		boolean isValidUser = false ;
//		LoginDAO loginDao = new LoginDAO() ;
//		isValidUser = loginDao.validateCredentials(userName, password, userType) ;
//		return isValidUser ;
//	}
	
	public boolean changePassword(String password,String email) {
		boolean isPasswordChanged = false ;
		ChangePasswordDAO cpDAO = new ChangePasswordDAO() ;
		isPasswordChanged = cpDAO.changePassword(password,email) ;
		return isPasswordChanged ;
	}
}
