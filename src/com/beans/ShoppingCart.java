package com.beans;

import java.util.ArrayList;

public class ShoppingCart {

	private int shoppingCartID ;
	private ArrayList<ShoppingCartProduct> products ;
	private double totalValue ;

	public ShoppingCart() {}

	public ShoppingCart(int shoppingCartID, ArrayList<ShoppingCartProduct> products, double totalValue) {
		this.shoppingCartID = shoppingCartID;
		this.products = products;
		this.totalValue = totalValue;
	}

	public int getShoppingCartID() {
		return shoppingCartID;
	}

	public void setShoppingCartID(int shoppingCartID) {
		this.shoppingCartID = shoppingCartID;
	}

	public ArrayList<ShoppingCartProduct> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<ShoppingCartProduct> products) {
		this.products = products;
	}

	public double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}
}
