package com.st.beans;

public class ProductCategory {
	
	private int productCategoryId;
	private String productType;
	private String categoryName;
	public int getProductCategoryId() {
		return productCategoryId;
	}
	public void setProductCategoryId(int productCategoryId) {
		this.productCategoryId = productCategoryId;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public ProductCategory() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
