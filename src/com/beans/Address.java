package com.beans;

public class Address {
	private String firstLine ;
	private String lastLine ;
	private String city ;
	private String state ;
	private String country ;
	private String zip ;
	
	public Address() {}

	public Address(String firstLine, String lastLine, String city, String state, String country, String zip) {
		this.firstLine = firstLine;
		this.lastLine = lastLine;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zip = zip;
	}

	public String getFirstLine() {
		return firstLine;
	}

	public void setFirstLine(String firstLine) {
		this.firstLine = firstLine;
	}

	public String getLastLine() {
		return lastLine;
	}

	public void setLastLine(String lastLine) {
		this.lastLine = lastLine;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}	
}
