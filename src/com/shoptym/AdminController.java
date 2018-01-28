package com.shoptym;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

import com.beans.*;
import com.beans.ViewOrder_Admin;
import com.service.* ;
import com.utils.* ;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
    JdbcTemplate jdbcTemplate;
	
	private HttpSession session ;
	
	@RequestMapping("/viewSalesAdmin")
    public String viewSalesAdmin() {
        return "jsp/admin/viewsales_admin" ;
    }
	
	@RequestMapping("/getAllUsers")
    public String getAllUsers(HttpServletRequest request, Model model) {
		System.out.println("Inside getAllUsers") ;
		session = request.getSession(false) ;
		if(session == null) {
			return "jsp/user/login" ;
		}
		if(! session.getAttribute("userType").equals(UserRoles.ADMIN)) {
			return "index" ;
		}
		else {
			User searchDetails = new User("", "", "", "", "", "", "", "") ;
			AdminService aService = new AdminService() ;
			ArrayList<User> users = aService.getUsers(jdbcTemplate, searchDetails) ;
			model.addAttribute("users", users) ;
			//session.setAttribute("users", users) ;
			return "jsp/admin/users" ;
		}
    }
	
	@RequestMapping(value = "/getUsers", method = RequestMethod.POST)
    public String getUsers(HttpServletRequest request, Model model) {
		System.out.println("Inside getUsers") ;
		session = request.getSession(false) ;
		if(session == null) {
			return "jsp/user/login" ;
		}
		if(! session.getAttribute("userType").equals(UserRoles.ADMIN)) {
			return "index" ;
		}
		else {
			System.out.println("Session working OK") ;
			String email = request.getParameter("userEmail") ;
			System.out.println("Email=" + email) ;
			String userType = request.getParameter("userType") ;
			String firstName = request.getParameter("firstName") ;
			String lastName = request.getParameter("lastName") ;
			String gender = request.getParameter("gender") ;
			String contactNo = request.getParameter("contactNo") ;
			String isActiveString = request.getParameter("isActive") ;
			String isApprovedString = request.getParameter("isApproved") ;
			
			User searchDetails = new User(userType, firstName, lastName, email, gender, contactNo, isActiveString, isApprovedString) ;
			AdminService aService = new AdminService() ;
			ArrayList<User> users = aService.getUsers(jdbcTemplate, searchDetails) ;
			model.addAttribute("users", users) ;
			//session.setAttribute("users", users) ;
			return "jsp/admin/users" ;
		}
    }
	
	@RequestMapping("/deleteUser")
	public String deleteUser(HttpServletRequest request) {
		String email = request.getParameter("email") ;
		System.out.println("User email*** = " + email) ;
		AdminService aService = new AdminService() ;
		boolean isDeleted = aService.deleteUser(jdbcTemplate, email) ;
		session.setAttribute("isDeleted", isDeleted) ;
		session.setAttribute("email", email) ;
		User user = new User() ;
		ArrayList<User> users = aService.getUsers(jdbcTemplate, user) ;
		session.setAttribute("users", users) ;
		return "jsp/admin/users" ;
	}
	
	@RequestMapping("/getSellerRequests")
    public String getSellerRequests(HttpServletRequest request) {
		session = request.getSession(false) ;
		if(session == null) {
			return "jsp/user/login" ;
		}
		if(! session.getAttribute("userType").equals(UserRoles.ADMIN)) {
			return "index" ;
		}
		else {
			AdminService aService = new AdminService() ;
			ArrayList<User> sellerRequests = aService.getSellerRequests(jdbcTemplate) ;
			session.setAttribute("sellerRequests", sellerRequests) ;
			return "jsp/admin/seller_requests" ;
		}
    }
	
	@RequestMapping("/approveSeller")
	public String approveSeller(HttpServletRequest request) {
		String email = request.getParameter("email") ;
		System.out.println("User email = " + email) ;
		AdminService aService = new AdminService() ;
		boolean isApproved = aService.approveSeller(jdbcTemplate, email) ;
		
		String message = email ;
		message += (isApproved) ? " approved sucessfully" : " couldn't be approved" ;
		if(session.getAttribute("message") != null) {
			session.removeAttribute("message") ;
		}
		session.setAttribute("message", message) ;
		
		ArrayList<User> sellerRequests = aService.getSellerRequests(jdbcTemplate) ;
		session.setAttribute("sellerRequests", sellerRequests) ;
		return "jsp/admin/seller_requests" ;
	}
	
	@RequestMapping("/rejectSeller")
	public String rejectSeller(HttpServletRequest request) {
		String email = request.getParameter("email") ;
		System.out.println("User email = " + email) ;
		AdminService aService = new AdminService() ;
		boolean isRejected = aService.rejectSeller(jdbcTemplate, email) ;
		
		String message = email ;
		message += (isRejected) ? " rejected sucessfully" : " couldn't be rejected" ;
		if(session.getAttribute("message") != null) {
			session.removeAttribute("message") ;
		}
		session.setAttribute("message", message) ;
		
		ArrayList<User> sellerRequests = aService.getSellerRequests(jdbcTemplate) ;
		session.setAttribute("sellerRequests", sellerRequests) ;
		return "jsp/admin/seller_requests" ;
	}
	
	@RequestMapping("/viewAllOrders")
	public String viewAllOrders(HttpServletRequest request, Model model) {
		System.out.println("Inside viewAllOrders") ;
		session = request.getSession(false) ;
		if(session == null) {
			System.out.println("Session is null");
			return "jsp/user/login" ;
		}
		if(! session.getAttribute("userType").equals(UserRoles.ADMIN)) {
			System.out.println("Usertype is not admin");
			return "index" ;
		}
		else {
			System.out.println("No problem with the session") ;
			Order order = new Order("", "", "", "") ;
			AdminService aService = new AdminService() ;
			ArrayList<Order> orders = aService.getOrders(jdbcTemplate, order) ;
			model.addAttribute("orders", orders) ;
			//session.setAttribute("orders", orders) ;
			return "jsp/admin/search_orders_admin" ;
		}
	}
	
	@RequestMapping(value="/searchOrders", method = RequestMethod.POST)
	public String searchOrders(HttpServletRequest request, Model model) {
		System.out.println("Inside searchOrders") ;
		session = request.getSession(false) ;
		if(session == null) {
			System.out.println("Session is null");
			return "jsp/user/login" ;
		}
		if(! session.getAttribute("userType").equals(UserRoles.ADMIN)) {
			System.out.println("Usertype is not admin");
			return "index" ;
		}
		else {
			System.out.println("No problem with the session") ;
			String orderIDString = request.getParameter("orderID") ;
			String userEmail = request.getParameter("userEmail") ;
			String transactionStatus = request.getParameter("transactionStatus") ;
			String contactNo = request.getParameter("contactNo") ;
			Order order = new Order(orderIDString, transactionStatus, userEmail, contactNo) ;
			AdminService aService = new AdminService() ;
			ArrayList<Order> orders = aService.getOrders(jdbcTemplate, order) ;
			model.addAttribute("orders", orders) ;
			//session.setAttribute("orders", orders) ;
			return "jsp/admin/search_orders_admin" ;
		}
	}
	
	@RequestMapping("/getOrderDetails")
	public String getOrderDetails(HttpServletRequest request) {
		System.out.println("Inside getOrderDetails") ;
		session = request.getSession(false) ;
		if(session == null) {
			System.out.println("Session is null");
			return "jsp/user/login" ;
		}
		if(! session.getAttribute("userType").equals(UserRoles.ADMIN)) {
			System.out.println("Usertype is not admin");
			return "index" ;
		}
		else {
			System.out.println("No problem with the session") ;
			String orderID = request.getParameter("orderID") ;
			AdminService aService = new AdminService() ;
			ArrayList<ViewOrder_Admin> viewOrderList = aService.getOrderDetails(jdbcTemplate, orderID) ;
			session.setAttribute("viewOrderList", viewOrderList) ;
			return "jsp/admin/orderdetails_admin" ;
		}
	}
	
	@RequestMapping("/getSalesByProductTypeAdmin")
	public String getSalesByProductTypeAdmin(HttpServletRequest request, Model model) {
		System.out.println("Inside getSalesByProductTypeAdmin") ;
		session = request.getSession(false) ;
		if(session == null) {
			System.out.println("Session is null");
			return "jsp/user/login" ;
		}
		if(! session.getAttribute("userType").equals(UserRoles.ADMIN)) {
			System.out.println("Usertype is not admin");
			return "index" ;
		}
		else {
			System.out.println("No problem with the session") ;
			String productType = request.getParameter("productType") ;
			AdminService aService = new AdminService() ;
			ArrayList<SalesByProductType> salesByProductType = aService.getSalesByProductTypeAdmin(jdbcTemplate, productType) ;
			model.addAttribute("salesByProductTypeAdmin", salesByProductType) ;
			
			String graphData = "" ;
			String graphLabels = "" ;
			for(int i=0 ; i<salesByProductType.size() ; i++) {
				graphLabels += salesByProductType.get(i).getProductType() ;
				graphData += salesByProductType.get(i).getSales() ;
				if(i < salesByProductType.size() - 1 ) {
					graphLabels += " , " ;
					graphData += " , " ;
				}
			}
			session.setAttribute("graphLabels", graphLabels) ;
			session.setAttribute("graphData", graphData) ;
			
			return "jsp/admin/getSalesByProductType_admin" ;
		}
	}
	
	@RequestMapping("/getSalesByProductCategoryAdmin")
	public String getSalesByProductCategoryAdmin(HttpServletRequest request) {
		System.out.println("Inside getSalesByProductCategoryAdmin") ;
		session = request.getSession(false) ;
		if(session == null) {
			System.out.println("Session is null");
			return "jsp/user/login" ;
		}
		if(! session.getAttribute("userType").equals(UserRoles.ADMIN)) {
			System.out.println("Usertype is not admin");
			return "index" ;
		}
		else {
			System.out.println("No problem with the session") ;
			String productCategory = request.getParameter("productCategory") ;
			AdminService aService = new AdminService() ;
			ArrayList<SalesByProductCategory> salesByProductCategory =
					aService.getSalesByProductCategoryAdmin(jdbcTemplate, productCategory) ;
			session.setAttribute("salesByProductCategoryAdmin", salesByProductCategory) ;
			return "jsp/admin/getSalesByProductCategory_admin" ;
		}
	}
}
