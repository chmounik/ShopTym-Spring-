package com.beans;

public class FeatureIDValuePair {
	private String featureID ;
	private String featureValue ;
	
	public FeatureIDValuePair(String featureID, String featureValue) {
		this.featureID = featureID;
		this.featureValue = featureValue;
	}

	public String getFeatureID() {
		return featureID;
	}

	public void setFeatureID(String featureID) {
		this.featureID = featureID;
	}

	public String getFeatureValue() {
		return featureValue;
	}

	public void setFeatureValue(String featureValue) {
		this.featureValue = featureValue;
	}
}
