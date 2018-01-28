package com.st.beans;

import java.sql.Blob;

public class Cart {
	
	private int cartId;
	private String productName;
	private int productId;
	private int quantity;
	private Blob productImage;
	private double cost;
	
	public Cart(int cartId, String productName, int productId, int quantity, Blob productImage, double cost) {
		super();
		this.cartId = cartId;
		this.productName = productName;
		this.productId = productId;
		this.quantity = quantity;
		this.productImage = productImage;
		this.cost = cost;
	}

	public Cart() {
		super();
	}
	
	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Blob getProductImage() {
		return productImage;
	}

	public void setProductImage(Blob productImage) {
		this.productImage = productImage;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
	
	
	
}
