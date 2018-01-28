package com.beans;

public class Shipments {
	int shippingId;
	int shoppingCartProductId;
	String shipmentStatus;
	
	public Shipments(int shippingId, int shoppingCartProductId, String shipmentStatus) {
		super();
		this.shippingId = shippingId;
		this.shoppingCartProductId = shoppingCartProductId;
		this.shipmentStatus = shipmentStatus;
	}
	
	public Shipments(){
		super();
	}

	public int getShippingId() {
		return shippingId;
	}

	public void setShippingId(int shippingId) {
		this.shippingId = shippingId;
	}

	public int getShoppingCartProductId() {
		return shoppingCartProductId;
	}

	public void setShoppingCartProductId(int shoppingCartProductId) {
		this.shoppingCartProductId = shoppingCartProductId;
	}

	public String getShipmentStatus() {
		return shipmentStatus;
	}

	public void setShipmentStatus(String shipmentStatus) {
		this.shipmentStatus = shipmentStatus;
	}
	
	

}
