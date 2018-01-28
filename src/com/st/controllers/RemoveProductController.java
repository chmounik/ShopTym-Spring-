package com.st.controllers;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.service.*;

@Controller
@RequestMapping("/removeproduct")

public class RemoveProductController  {
	@RequestMapping("/remove")
	protected String changePassword(HttpServletRequest request, Model model) {
		    System.out.println("Request is getting till here");
			String productId = request.getParameter("productid") ;
			String sellerId = request.getParameter("sellerid") ;
			RemoveProductService rpService = new RemoveProductService() ;
			rpService.RemoveProduct(sellerId,productId) ;
			return "removeproduct";
		}
	}
