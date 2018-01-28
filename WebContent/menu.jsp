<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.beans.*"%>
<%@ page import="com.utils.*"%>

<%
	String label = "";
	String href = "";
	String path;
	boolean isLoggedIn = false;
	String userType = "";
	String userEmail = "";

	response.setHeader("Pragma", "no-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Cache-Control", "no-store");
	response.setHeader("Expires", "0");
	response.setDateHeader("Expires", -1);
	path = request.getContextPath();
	
	if (session != null && session.getAttribute("userEmail") != null
			&& !session.getAttribute("userEmail").toString().equals("")) {
		isLoggedIn = true;
		userEmail = session.getAttribute("userEmail").toString();
	}

	if (session != null && session.getAttribute("userType") != null) {
		userType = session.getAttribute("userType").toString();
	}

	if (!isLoggedIn) {
		out.write("<li><a href=\"" + path + "/commonUser/register\">Sign Up</a></li>");
		out.write("<li><a href=\"" + path + "/commonUser/login\">My Account</a></li>");
	}

	else if (userType.equals(UserRoles.ADMIN)) {
		out.write("<li><a href=\"" + path + "/admin/getAllUsers\">View Users</a></li>");
		out.write("<li><a href=\"" + path + "/admin/getSellerRequests\">View Seller Requests</a></li>");
		out.write("<li><a href=\"" + path + "/admin/viewAllOrders\">View Orders</a></li>");
		out.write("<li><a href=\"" + path + "/admin/viewSalesAdmin\">View Sales</a></li>");
	}
	
	else if (userType.equals(UserRoles.CUSTOMER)) {
		out.write("<li><a href=\"" + path + "/product/recentlyViewedProducts\">Recently Viewed Products</a></li>");
		out.write("<li><a href=\"" + path + "/product/cartList\">My Shopping Cart</a></li>");
		out.write("<li><a href=\"" + path + "/customer/getCustomerOrders\">View Orders</a></li>");
	}
	
	else if (userType.equals(UserRoles.SELLER)) {
		out.write("<li><a href=\"" + path + "/seller/getPendingOrders\">View Pending Orders</a></li>");
		out.write("<li><a href=\"" + path + "/addproduct/addProductsPage\">Add Product</a></li>");
		out.write("<li><a href=\"" + path + "/product/productList/getSellerProducts\">View Added Products</a></li>");
		out.write("<li><a href=\"" + path + "/seller/viewSalesSeller\">View Sales</a></li>");
	}
	
	if (isLoggedIn) {
		out.write("<li><a href=\"" + path + "/commonUser/logOut\">Log Out</a></li>");
		out.write("<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Hello " + userEmail + " </li>");
	}
%>
