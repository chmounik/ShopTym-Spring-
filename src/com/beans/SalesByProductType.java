package com.beans;

public class SalesByProductType {
	
	private String productType ;
	private int sales ;
	
	public SalesByProductType() {}

	public SalesByProductType(String productType, int sales) {
		this.productType = productType;
		this.sales = sales;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public int getSales() {
		return sales;
	}

	public void setSales(int sales) {
		this.sales = sales;
	}	
}
