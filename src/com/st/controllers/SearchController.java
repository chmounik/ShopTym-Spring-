package com.st.controllers;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.st.beans.Product;
import com.service.SearchProductService;

@Controller
@RequestMapping("/search")
public class SearchController {
	
	@RequestMapping("/searchProducts")
	protected String searchProducts(HttpServletRequest request , Model model) {
		HttpSession session = request.getSession(false) ;
		System.out.println("Inside searchProducts") ;
		String key = request.getParameter("key");
		//String type = request.getParameter("type");
		String productType=request.getParameter("PRODUCTTYPE");
		SearchProductService spService = new SearchProductService();
		ArrayList<Product> products = spService.searchProduct(key,productType) ;
		//model.addAttribute("products", products) ;
		session.setAttribute("productsFromSession", products);
		return "productList";
	}

}
