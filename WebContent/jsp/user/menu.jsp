<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.beans.*"%>
<%@ page import="com.utils.*"%>


<%!	boolean isLoggedIn = false ;
	String userType = "" ;
	String userEmail = "" ;
	String label = "" ;
	String href = "" ;		%>

<%
 	if(session != null && session.getAttribute("userType") != null) {
		userType = session.getAttribute("userType").toString();
	}
/*
	if(userType.equals(UserRoles.ADMIN)) {
		label = "View Users" ;
		href = "/getUsers" ;
	}
	else if(userType.equals(UserRoles.CUSTOMER)) {
		label = "View Orders" ;
		href = "/getCustomerOrders" ;
	}
	else if (userType.equals(UserRoles.SELLER)) {
		label = "View Pending Orders" ;
		href = "/getSellerOrders" ;
	}
	else {
		label = "Don't view users";
		href = "/getUsers";
	} */
%>


<%
	if(userType.equals(UserRoles.ADMIN)) {
		out.write("<li><a href=\"/getUsers?userEmail=&userType=&firstName=&lastName=&gender=&contactNo=&isActive=&isApproved=\">View Users</a></li>") ;
		out.write("<li><a href=\"/getSellerRequests\">View Seller Requests</a></li>") ;
		out.write("<li><a href=\"/searchOrders?orderID=&userEmail=&transactionStatus=&contactNo=\">View Orders</a></li>") ;
		out.write("<li><a href=\"/viewSalesAdmin\">View Sales</a></li>") ;
	}
	else if(userType.equals(UserRoles.CUSTOMER)) {
		out.write("<li><a href=\"/getCustomerOrders\">View Orders</a></li>") ;
	}
	else if(userType.equals(UserRoles.SELLER)) {
		out.write("<li><a href=\"/getPendingOrders\">View Pending Orders</a></li>") ;
		out.write("<li><a href=\"/viewSalesSeller\">View Sales</a></li>") ;
	}
%>