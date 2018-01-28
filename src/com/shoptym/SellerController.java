package com.shoptym;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import com.beans.PendingOrder;
import com.beans.SalesByProductCategory;
import com.beans.SalesByProductType;
import com.service.SellerService;
import com.utils.UserRoles;

@Controller
@RequestMapping("/seller")
public class SellerController {
	
	@Autowired
    JdbcTemplate jdbcTemplate;
	
	private HttpSession session ;
	
	@RequestMapping("/viewSalesSeller")
    public String viewSalesSeller() {
        return "jsp/seller/viewsales_seller" ;
    }
	
	@RequestMapping("/getPendingOrders")
	public String getPendingOrders(HttpServletRequest request, Model model) {
		session = request.getSession(false) ;
		if(session == null) {
			return "jsp/user/login" ;
		}
		if(! session.getAttribute("userType").equals(UserRoles.SELLER)) {
			return "index" ;
		}
		else {
			String email = session.getAttribute("userEmail").toString() ;
			System.out.println("jsp/seller Email = " + email) ;
			SellerService sService = new SellerService() ;
			ArrayList<PendingOrder> pendingOrderList = sService.getOrders(jdbcTemplate, email) ;
			//session.setAttribute("pendingOrderList", pendingOrderList) ;
			model.addAttribute("pendingOrderList", pendingOrderList) ;
			return "jsp/seller/viewSellerPendingOrders" ;
		}
	}
	
	@RequestMapping("/getSalesByProductTypeSeller")
	public String getSalesByProductTypeSeller(HttpServletRequest request, Model model) {
		System.out.println("Inside getSalesByProductTypeSeller") ;
		session = request.getSession(false) ;
		if(session == null) {
			System.out.println("Session is null");
			return "jsp/user/login" ;
		}
		if(! session.getAttribute("userType").equals(UserRoles.SELLER)) {
			System.out.println("Usertype is not seller");
			return "index" ;
		}
		else {
			System.out.println("No problem with the session") ;
			String productType = request.getParameter("productType") ;
			String sellerEmail = (String)session.getAttribute("userEmail") ;
			System.out.println("jsp/seller email = " + sellerEmail) ;
			SellerService sService = new SellerService() ;
			ArrayList<SalesByProductType> salesByProductType =
					sService.getSalesByProductTypeSeller(jdbcTemplate, productType, sellerEmail) ;
			//session.setAttribute("salesByProductTypeSeller", salesByProductType) ;
			model.addAttribute("salesByProductTypeSeller", salesByProductType) ;
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
			return "jsp/seller/getSalesByProductType_seller" ;
		}
	}
	
	@RequestMapping("/getSalesByProductCategorySeller")
	public String getSalesByProductCategorySeller(HttpServletRequest request, Model model) {
		System.out.println("Inside getSalesByProductCategorySeller") ;
		session = request.getSession(false) ;
		if(session == null) {
			System.out.println("Session is null");
			return "jsp/user/login" ;
		}
		if(! session.getAttribute("userType").equals(UserRoles.SELLER)) {
			System.out.println("Usertype is not seller");
			return "index" ;
		}
		else {
			System.out.println("No problem with the session") ;
			String productCategory = request.getParameter("productCategory") ;
			String sellerEmail = (String)session.getAttribute("userEmail") ;
			SellerService sService = new SellerService() ;
			ArrayList<SalesByProductCategory> salesByProductCategory =
					sService.getSalesByProductCategorySeller(jdbcTemplate, productCategory, sellerEmail) ;
			model.addAttribute("salesByProductCategorySeller", salesByProductCategory) ;
			//session.setAttribute("salesByProductCategorySeller", salesByProductCategory) ;
			return "jsp/seller/getSalesByProductCategory_seller" ;
		}
	}
}
