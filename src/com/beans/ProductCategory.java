package com.beans;

import java.util.ArrayList;

public class ProductCategory {

	private String productType ;
	private ArrayList<Feature> features = new ArrayList<Feature>() ;

	public ProductCategory() {}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public ArrayList<Feature> getFeatures() {
		return features;
	}

	public void setFeatures(ArrayList<Feature> features) {
		this.features = features;
	}

}
