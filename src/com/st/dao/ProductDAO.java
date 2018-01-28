package com.st.dao;

import java.util.ArrayList;
import java.util.List;

import com.beans.Feature;
import com.st.beans.Product;

public interface ProductDAO {
	public List<Product> getProductList() throws Exception;
	public Product getProductbyId(int Id);
	public int addProduct(Product product);
	public void delProduct(Product product);
	public void editProduct(Product product);
	public List<Product> getProductsbyCategory(String productCategory);
	public List<Product> getProductsbySellerID(String sellerID) ;
	public List<Product> getFilteredProducts(String categoryName, ArrayList<String> brands, ArrayList<Feature> features);
	public List<Product> getRecentlyViewedProducts(String customerEmail);
	public int deleteFeatures(String productID) ;
	public int deleteProduct(String productID) ;
	public int modifyProduct(Product product) ;
}
