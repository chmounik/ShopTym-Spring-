package com.shoptym;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import com.beans.Order;
import com.beans.ViewOrder;
import com.service.CustomerService;
import com.utils.UserRoles;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
    JdbcTemplate jdbcTemplate;
	
	private HttpSession session ;
	
	@RequestMapping("/getCustomerOrders")
    public String getCustomerOrders(HttpServletRequest request, Model model) {
		session = request.getSession(false) ;
		if(session == null) {
			return "jsp/user/login" ;
		}
		else if(! session.getAttribute("userType").equals(UserRoles.CUSTOMER) || session.getAttribute("userType") == null) {
			return "index" ;
		}
		else {
			String email = session.getAttribute("userEmail").toString() ;
			CustomerService cService = new CustomerService() ;
			ArrayList<Order> customerOrders = cService.getOrders(jdbcTemplate, email) ;
			//session.setAttribute("customerOrders", customerOrders) ;
			model.addAttribute("customerOrders", customerOrders) ;
			return "jsp/customer/customer_orders" ;
		}
    }
	
	@RequestMapping("/getCustomerOrderDetails")
    public String getCustomerOrderDetails(HttpServletRequest request, Model model) {
		session = request.getSession(false) ;
		if(session == null) {
			return "jsp/user/login" ;
		}
		else if(! session.getAttribute("userType").equals(UserRoles.CUSTOMER) || session.getAttribute("userType") == null) {
			return "index" ;
		}
		else {
			String orderIDStr = request.getParameter("orderID") ;
			CustomerService cService = new CustomerService() ;
			ArrayList<ViewOrder> orderDetails = cService.getOrderDetails(jdbcTemplate, orderIDStr) ;
			model.addAttribute("orderDetails", orderDetails) ;
			//session.setAttribute("orderDetails", orderDetails) ;
			System.out.println("Returning to customer_order_details") ;
			return "jsp/customer/customer_order_details" ;
		}
    }
}
