package com.beans;

public class ViewOrder_Admin {
	private int shoppingCartProductID ;
	private String productName ;
	private String sellerEmail ;
	private String productType ;
	private String productCategoryName ;
	private int quantity ;

	public ViewOrder_Admin() {}

	public ViewOrder_Admin(int shoppingCartProductID, String productName, String sellerEmail,
			String productType, String productCategoryName, int quantity) {
		this.shoppingCartProductID = shoppingCartProductID;
		this.productName = productName;
		this.sellerEmail = sellerEmail;
		this.productType = productType;
		this.productCategoryName = productCategoryName;
		this.quantity = quantity;
	}

	public int getShoppingCartProductID() {
		return shoppingCartProductID;
	}

	public void setShoppingCartProductID(int shoppingCartProductID) {
		this.shoppingCartProductID = shoppingCartProductID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getSellerEmail() {
		return sellerEmail;
	}

	public void setSellerEmail(String sellerEmail) {
		this.sellerEmail = sellerEmail;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getProductCategoryName() {
		return productCategoryName;
	}

	public void setProductCategoryName(String productCategoryName) {
		this.productCategoryName = productCategoryName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
