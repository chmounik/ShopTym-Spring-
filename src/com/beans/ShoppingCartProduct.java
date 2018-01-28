package com.beans;

public class ShoppingCartProduct {

	private int shoppingCartProductID ;
	private Product product ;
	private int quantity ;
	private Shipment shipment ;

	public ShoppingCartProduct() {}

	public int getShoppingCartProductID() {
		return shoppingCartProductID;
	}

	public void setShoppingCartProductID(int shoppingCartProductID) {
		this.shoppingCartProductID = shoppingCartProductID;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Shipment getShipment() {
		return shipment;
	}

	public void setShipment(Shipment shipment) {
		this.shipment = shipment;
	}

}
