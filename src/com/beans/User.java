package com.beans;

public class User {
	private String userType ;
	private String firstName ;
	private String lastName ;
	private String email ;
	private String password ;
	private String gender ;
	private String contactNo ;
	private boolean isActive ;
	private boolean isApproved ;
	private String isActiveString ;
	private String isApprovedString ;

	
	public User() {
		this.email = "" ;
		this.userType = "" ;
		this.firstName = "" ;
		this.lastName = "" ;
		this.email = "" ;
		this.gender = "" ;
		this.contactNo = "" ;
		this.isActiveString = "" ;
		this.isApprovedString = "" ;
	}
	
	public User(String email, String userType) {
		this.email = email;
		this.userType = userType;
	}
	
	public User(String firstName, String lastName, String email, String contactNo) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.contactNo = contactNo;
	}
	
	public User(String userType, String firstName, String lastName, String email, String gender, String contactNo,
			String isActiveString, String isApprovedString) {
		this.userType = userType;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.contactNo = contactNo;
		this.isActiveString = isActiveString;
		this.isApprovedString = isApprovedString;
	}

	public User(String email, String userType, String firstName, String lastName, 
			String gender, String contactNo, int isActiveInt, int isApprovedInt) {
		this.email = email ;
		this.userType = userType;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.contactNo = contactNo;
		setActive(isActiveInt) ;
		setApproved(isApprovedInt) ;
	}
	
	public User(String userType, String firstName, String lastName, String email, 
			String password, String gender, String contactNo) {
		this.userType = userType;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.contactNo = contactNo;
	}
	
	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(int isActiveInt) {
		if(isActiveInt == 0) {
			this.isActive = false ;
		}
		else {
			this.isActive = true ;
		}
	}
	
	public void setActive(String isActiveString) {
		if(isActiveString.equalsIgnoreCase("TRUE")) {
			this.isActive = true ;
		}
		else if(isActiveString.equalsIgnoreCase("FALSE")) {
			this.isActive = false ;
		}
	}

	public boolean isApproved() {
		return isApproved;
	}

	public void setApproved(int isApprovedInt) {
		if(isApprovedInt == 0) {
			isApproved = false ;
		}
		else {
			isApproved = true ;
		}
	}
	
	public void setApproved(String isApprovedString) {
		if(isApprovedString.equalsIgnoreCase("TRUE")) {
			this.isApproved = true ;
		}
		else if(isApprovedString.equalsIgnoreCase("FALSE")) {
			this.isApproved = false ;
		}
	}

	public String getIsActiveString() {
		return isActiveString;
	}

	public void setIsActiveString(String isActiveString) {
		this.isActiveString = isActiveString;
	}

	public String getIsApprovedString() {
		return isApprovedString;
	}

	public void setIsApprovedString(String isApprovedString) {
		this.isApprovedString = isApprovedString;
	}
}
