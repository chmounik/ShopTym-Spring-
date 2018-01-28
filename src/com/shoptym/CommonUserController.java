package com.shoptym;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import com.beans.User;
import com.exceptions.RegistrationException;
import com.exceptions.UserAlreadyRegistered;
import com.service.CommonUserService;

@Controller
@RequestMapping("/commonUser")
public class CommonUserController {
	
	@Autowired
    JdbcTemplate jdbcTemplate;
	
	@RequestMapping("/getGraph")
    public String getGraph() {
        return "jspbarchart" ;
    }
	
	@RequestMapping("/index")
    public String getIndex() {
        return "index" ;
    }
	
	@RequestMapping("/register")
    public String getRegister() {
        return "jsp/user/register" ;
    }
	
	@RequestMapping("/login")
    public String getLogin() {
        return "jsp/user/login" ;
    }
	
	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public String registerUser(HttpServletRequest request) {
		if(jdbcTemplate != null)
			System.out.println("jdbcTemplate inside controller is not null") ;
		String firstName = request.getParameter("firstName") ;
		String lastName = request.getParameter("lastName") ;
		String email = request.getParameter("email") ;
		String password = request.getParameter("password") ;
		String userType = request.getParameter("userType") ;
		String gender = request.getParameter("gender") ;
		String contactNo = request.getParameter("contactNo") ;
		User user = new User(userType, firstName, lastName, email, password, gender, contactNo) ;
		
		CommonUserService cuService = new CommonUserService() ;
		String message= "" ;
		try {
			cuService.registerUser(user, jdbcTemplate) ;
			message = "Registration successful" ;
		}
		catch(UserAlreadyRegistered uar) {
			message = "This email is already registered. Please try with a different email ID" ;
		}
		catch (RegistrationException e) {
			message = "Registration Failed. Please try after some time" ;
		}
		HttpSession session = request.getSession() ;
		session.setAttribute("message", message) ;
		
		return "jsp/user/message" ; 
	}
	
	@RequestMapping("/validateUser")
    public String validateUser(HttpServletRequest request) {
		String email= request.getParameter("email") ;
		String password = request.getParameter("password") ;
		String userType = request.getParameter("userType") ;
		CommonUserService cuService = new CommonUserService() ;
		HttpSession session = request.getSession() ;

		String message = cuService.isValidUser(email, password, userType, jdbcTemplate) ;
		boolean isLoggedIn = message.equalsIgnoreCase("CORRECT") ;
		System.out.println("Is logged in = " + isLoggedIn) ;
		if(isLoggedIn) {
			session.setAttribute("userEmail", email) ;
			session.setAttribute("userType", userType) ;
			return "index" ;
		}
		else
			session.setAttribute("error", message) ;
			return "jsp/user/login" ;
    }
	
	@RequestMapping("/logOut")
    public String logOut(HttpServletRequest request) {
		HttpSession session = request.getSession(false) ;
		session.invalidate() ;
        return "jsp/user/login" ;
    }
}
