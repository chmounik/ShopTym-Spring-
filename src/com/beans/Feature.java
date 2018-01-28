package com.beans;

import java.util.ArrayList;

public class Feature {
	
	private String featureID ;
	private String featureName ;
	private ArrayList<String> featureValues ;
	
	public Feature() {}

	public Feature(String featureID, String featureName) {
		this.featureID = featureID;
		this.featureName = featureName;
	}
	
	public Feature(String featureID, ArrayList<String> featureValues) {
		this.featureID = featureID;
		this.featureValues = featureValues;
	}
	
	public Feature(String featureID, String featureName, ArrayList<String> featureValues) {
		this.featureID = featureID;
		this.featureName = featureName;
		this.featureValues = featureValues;
	}

	public String getFeatureID() {
		return featureID;
	}

	public void setFeatureID(String featureID) {
		this.featureID = featureID;
	}

	public String getFeatureName() {
		return featureName;
	}

	public void setFeatureName(String featureName) {
		this.featureName = featureName;
	}

	public ArrayList<String> getFeatureValues() {
		return featureValues;
	}

	public void setFeatureValues(ArrayList<String> featureValues) {
		this.featureValues = featureValues;
	}
}
