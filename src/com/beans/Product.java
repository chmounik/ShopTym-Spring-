package com.beans;

import java.sql.Blob;
import java.util.ArrayList;

public class Product {
	
	private int productID ;
	private String productName ;
	private ProductCategory productCategory ;
	private int productCategoryID;
	private int productAddressID;
	private Blob productImage;
	private User seller ;
	private String sellerID ;
	private Address productAddress ;
	private String productDescription ;
	private ArrayList<Review> reviews = new ArrayList<Review>() ;
	private int quantity ;
	private double price ;
	
	public Product() {}

	public Product(int productID, String productName, ProductCategory productCategory, User seller,
			Address productAddress, String description, ArrayList<Review> reviews, int quantity, double price) {
		this.productID = productID;
		this.productName = productName;
		this.productCategory = productCategory;
		this.seller = seller;
		this.productAddress = productAddress;
		this.productDescription = description;
		this.reviews = reviews;
		this.quantity = quantity;
		this.price = price;
	}
	
	public Product(int productID, String productName, ProductCategory productCategory, int productCategoryID,
			int productAddressID, Blob productImage, User seller, String sellerID, Address productAddress,
			String productDescription, ArrayList<Review> reviews, int quantity, double price) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.productCategory = productCategory;
		this.productCategoryID = productCategoryID;
		this.productAddressID = productAddressID;
		this.productImage = productImage;
		this.seller = seller;
		this.sellerID = sellerID;
		this.productAddress = productAddress;
		this.productDescription = productDescription;
		this.reviews = reviews;
		this.quantity = quantity;
		this.price = price;
	}

	public Product(int productId, String productName, String sellerID, int productCategoryID, int productAddressID,
			String productDescription, Blob productImage, int productQuantity, double productCost) {
		this.productID = productId;
		this.productName = productName;
		this.sellerID = sellerID;
		this.productCategoryID = productCategoryID;
		this.productAddressID = productAddressID;
		this.productDescription = productDescription;
		this.productImage = productImage;
		this.quantity = productQuantity;
		this.price = productCost;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productID + ", productName=" + productName + ", sellerId=" + sellerID
				+ ", productCategoryId=" + productCategoryID + ", productAddressId=" + productAddressID
				+ ", productDescription=" + productDescription + ", productImage=" + productImage + ", productQuantity="
				+ quantity + ", productCost=" + price + "]";
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public ProductCategory getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

	public int getProductCategoryID() {
		return productCategoryID;
	}

	public void setProductCategoryID(int productCategoryID) {
		this.productCategoryID = productCategoryID;
	}

	public int getProductAddressID() {
		return productAddressID;
	}

	public void setProductAddressID(int productAddressID) {
		this.productAddressID = productAddressID;
	}

	public Blob getProductImage() {
		return productImage;
	}

	public void setProductImage(Blob productImage) {
		this.productImage = productImage;
	}

	public User getSeller() {
		return seller;
	}

	public void setSeller(User seller) {
		this.seller = seller;
	}

	public String getSellerID() {
		return sellerID;
	}

	public void setSellerID(String sellerID) {
		this.sellerID = sellerID;
	}

	public Address getProductAddress() {
		return productAddress;
	}

	public void setProductAddress(Address productAddress) {
		this.productAddress = productAddress;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public ArrayList<Review> getReviews() {
		return reviews;
	}

	public void setReviews(ArrayList<Review> reviews) {
		this.reviews = reviews;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
