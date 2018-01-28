package com.st.services;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	
	@Autowired
	private JavaMailSender mailSender;
	
	public JavaMailSender getMailSender() {
		return mailSender;
	}

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void sendMail(String emailId)
	{
		MimeMessage message =  this.mailSender.createMimeMessage();
		MimeMessageHelper mimeHelper;
		try {
			mimeHelper = new MimeMessageHelper(message,true);
			mimeHelper.setTo(emailId);
			mimeHelper.setFrom("shoptym@gmail.com");
			mimeHelper.setSubject("Order Confirmation");
			mimeHelper.setText("<html><body>hi,<br/><a href='http://localhost:8080/ShopTym/forgotPassword/newPassword/"+emailId+"/'> Click here</a> to reset password</body></html>",true);
			mailSender.send(message);
		} catch (MessagingException e) {
			System.out.println("Error Sending email "+ e.getMessage());
		}
		
	}

	public void sendMailForPayment(String costumerid, String productName, double d, int shoppingcartproductid) {
		MimeMessage message =  this.mailSender.createMimeMessage();
		MimeMessageHelper mimeHelper;
		try {
			mimeHelper = new MimeMessageHelper(message,true);
			mimeHelper.setTo(costumerid);
			mimeHelper.setFrom("shoptym@gmail.com");
			mimeHelper.setSubject("Password Reset");
			mimeHelper.setText("<html><body>Hi, Thank you for shopping with us. You ordered '"+productName+"'. We’ll send a confirmation when your items ship.<br/><a href='http://localhost:8080/ShopTym/product/trackingbyId/"+shoppingcartproductid+"/'> Click here</a> to Track your Product</body></html>",true);
			mailSender.send(message);
		} catch (MessagingException e) {
			System.out.println("Error Sending email "+ e.getMessage());
		}
		
		
	}
}
