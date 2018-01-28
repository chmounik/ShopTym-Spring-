package com.service;

import java.util.ArrayList;
import com.st.beans.Product;
import com.dao.SearchProductDAO;

public class SearchProductService {
	public ArrayList<Product> searchProduct(String key,String type){
		ArrayList<Product> productList = null;
		SearchProductDAO spDAO = new SearchProductDAO();
		productList=spDAO.serchProducts(key, type);
		return productList;
	}
}

