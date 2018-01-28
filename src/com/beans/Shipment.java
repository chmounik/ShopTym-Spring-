package com.beans;

public class Shipment {
	
	private int shipmentID ;
	private ShoppingCartProduct shoppingCartProduct ;
	private Order order ;
	private String shipmentStatus ;

	public Shipment() {}

	public Shipment(int shipmentID, ShoppingCartProduct shoppingCartProduct, Order order, String shipmentStatus) {
		this.shipmentID = shipmentID;
		this.shoppingCartProduct = shoppingCartProduct;
		this.order = order;
		this.shipmentStatus = shipmentStatus;
	}

	public int getShipmentID() {
		return shipmentID;
	}

	public void setShipmentID(int shipmentID) {
		this.shipmentID = shipmentID;
	}

	public ShoppingCartProduct getShoppingCartProduct() {
		return shoppingCartProduct;
	}

	public void setShoppingCartProduct(ShoppingCartProduct shoppingCartProduct) {
		this.shoppingCartProduct = shoppingCartProduct;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getShipmentStatus() {
		return shipmentStatus;
	}

	public void setShipmentStatus(String shipmentStatus) {
		this.shipmentStatus = shipmentStatus;
	}
}
