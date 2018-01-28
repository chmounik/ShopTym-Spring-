package com.beans;

public class SalesByProductCategory {

	private int productCategoryID ;
	private String categoryName ;
	private String productType ;
	private int sales ;
	
	public SalesByProductCategory() {}

	public SalesByProductCategory(int productCategoryID, String categoryName, String productType, int sales) {
		this.productCategoryID = productCategoryID;
		this.categoryName = categoryName;
		this.productType = productType;
		this.sales = sales;
	}

	public int getProductCategoryID() {
		return productCategoryID;
	}

	public void setProductCategoryID(int productCategoryID) {
		this.productCategoryID = productCategoryID;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public int getSales() {
		return sales;
	}

	public void setSales(int sales) {
		this.sales = sales;
	}
}
