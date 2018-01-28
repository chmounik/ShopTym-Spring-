package com.st.beans;

import java.sql.Blob;

public class Product {
	
	private int productId;
	private String productName;
	private String sellerId;
	private int productCategoryId;
	private int productAddressId;
	private String productDescription;
	private Blob productImage;
	private int productQuantity;
	private double productCost;
	private String brandName ;
	
	public Product() {}
	
	public Product(int productId, String productName, int productQuantity,  String productDescription, double productCost) {
		this.productId = productId;
		this.productName = productName;
		this.productQuantity = productQuantity ;
		this.productDescription = productDescription;
		this.productCost = productCost;
	}

	public Product(int productId, String productName, String sellerId, int productCategoryId, int productAddressId,
			String productDescription, Blob productImage, int productQuantity, double productCost) {
		this.productId = productId;
		this.productName = productName;
		this.sellerId = sellerId;
		this.productCategoryId = productCategoryId;
		this.productAddressId = productAddressId;
		this.productDescription = productDescription;
		this.productImage = productImage;
		this.productQuantity = productQuantity;
		this.productCost = productCost;
	}
	
	public Product(int productId, String productName, String sellerId, String productBrand, int productCategoryId, int productAddressId,
			String productDescription, int productQuantity, double productCost) {
		this.productId = productId;
		this.productName = productName;
		this.sellerId = sellerId;
		this.productCategoryId = productCategoryId;
		this.productAddressId = productAddressId;
		this.productDescription = productDescription;
		this.productQuantity = productQuantity;
		this.productCost = productCost;
	}

	public Product(int productId, String productName, String sellerId, int productCategoryId, int productAddressId,
			String productDescription, Blob productImage, int productQuantity, double productCost, String brandName) {
		this.productId = productId;
		this.productName = productName;
		this.sellerId = sellerId;
		this.productCategoryId = productCategoryId;
		this.productAddressId = productAddressId;
		this.productDescription = productDescription;
		this.productImage = productImage;
		this.productQuantity = productQuantity;
		this.productCost = productCost;
		this.brandName = brandName;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", sellerId=" + sellerId
				+ ", productCategoryId=" + productCategoryId + ", productAddressId=" + productAddressId
				+ ", productDescription=" + productDescription + ", productImage=" + productImage + ", productQuantity="
				+ productQuantity + ", productCost=" + productCost + ", brandName=" + brandName + "]";
	}

	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductCategoryId() {
		return productCategoryId;
	}
	public void setProductCategoryId(int productCategoryId) {
		this.productCategoryId = productCategoryId;
	}
	public int getProductAddressId() {
		return productAddressId;
	}
	public void setProductAddressId(int productAddressId) {
		this.productAddressId = productAddressId;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public Blob getProductImage() {
		return productImage;
	}
	public void setProductImage(Blob productImage) {
		this.productImage = productImage;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	public double getProductCost() {
		return productCost;
	}
	public void setProductCost(double productCost) {
		this.productCost = productCost;
	}
	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
}
