package com.beans;

public class ProductCategoryIDMap {
	
	private String productCategoryID ;
	private String categoryName ;
	
	public ProductCategoryIDMap(String productCategoryID, String categoryName) {
		this.productCategoryID = productCategoryID;
		this.categoryName = categoryName;
	}

	public String getProductCategoryID() {
		return productCategoryID;
	}

	public void setProductCategoryID(String productCategoryID) {
		this.productCategoryID = productCategoryID;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}
