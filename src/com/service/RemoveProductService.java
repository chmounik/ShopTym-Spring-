package com.service;

import com.dao.*;

public class RemoveProductService {
	public boolean RemoveProduct(String sellerId,String productId) {
		boolean isPasswordChanged = false ;
		RemoveProductDAO rpDAO = new RemoveProductDAO() ;
		isPasswordChanged = rpDAO.removeProduct(sellerId,productId);
		return isPasswordChanged ;
	}
}
