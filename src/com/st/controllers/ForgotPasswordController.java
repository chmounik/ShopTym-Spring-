package com.st.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.st.dao.DAOImpl.ProductDAOImpl;
import com.st.services.MailService;

@Controller
@RequestMapping("/forgotPassword")
public class ForgotPasswordController {
	@Autowired
	private MailService mailService;
	@Autowired
	private ProductDAOImpl productService;

	@RequestMapping(value = "/jsp")
	public String forgotPassword() {
		return "forgotpassword";
	}

	@RequestMapping("/resetPassword")
	public String resetRequest(@RequestParam(value = "email") String email, Map<String, String> model) {
		String msg = null;
		int flag = productService.isvalidId(email);
		if (flag > 0) {
			mailService.sendMail(email);
			msg = "Please check your email " + email + " for a password reset link";
			model.put("msg", msg);
		} else {
			msg = "Please enter a valid email with which you have registered to our website";
			model.put("msg", msg);
		}
		System.out.println(msg);
		return "checkMail";
	}

	@RequestMapping(value = "/newPassword/{email}")
	public String resetPassword(@PathVariable String email, Map<String, String> model) {
		// check if the email id is valid and registered with us.
		model.put("emailid", email);
		return "newPassword";
	}

	@RequestMapping(value = "/reenter/{email}")
	public String rePassword(@PathVariable String email, Map<String, String> model, HttpServletRequest request) {
		System.out.println(email);
		System.out.println(request.getParameter("password"));
		@SuppressWarnings("unused")
		int flag = productService.updatePassword(email + ".com", request.getParameter("password"));
		return "/jsp/user/login";
	}

	public ProductDAOImpl getProductService() {
		return productService;
	}

	public void setProductService(ProductDAOImpl productService) {
		this.productService = productService;
	}
}
