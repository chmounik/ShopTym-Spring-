package com.st.controllers;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.service.*;

@Controller
@RequestMapping("/changepassword")
public class ChangepasswordController { 
	
	@RequestMapping("/password")
	protected String changePassword(HttpServletRequest request, Model model) {
		System.out.println("Request getting till here");
			String email = request.getParameter("email") ;
			String password = request.getParameter("password") ;
			@SuppressWarnings("unused")
			String repassword = request.getParameter("repassword") ;
			LoginService lServ = new  LoginService() ;
			Boolean fl=lServ.changePassword(password,email) ;
			String msg="Password Changed Successfully";
			if(fl==true)
				model.addAttribute("msg",msg);
			return "ChangePassword";
		//doGet(request, response);
	}

}