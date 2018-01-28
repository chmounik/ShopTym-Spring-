package com.beans;

public class ShoppingCartProducts {
	
	private int shoppingCartProductId ;
	private int orderId;
	private int productId;
	private int quantity;
	
	public ShoppingCartProducts(int shoppingCartProductId, int orderId, int productId, int quantity) {
		super();
		this.shoppingCartProductId = shoppingCartProductId;
		this.orderId = orderId;
		this.productId = productId;
		this.quantity = quantity;
	}

	public int getShoppingCartProductId() {
		return shoppingCartProductId;
	}

	public void setShoppingCartProductId(int shoppingCartProductId) {
		this.shoppingCartProductId = shoppingCartProductId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
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
	
	

}
