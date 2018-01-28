package com.st.controllers;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.st.beans.Product;
import com.st.dao.DAOImpl.ProductDAOImpl;

@Controller
@RequestMapping("/myImage")
public class ImageController {

	@Autowired
	private ProductDAOImpl itemService;

	@RequestMapping(value = "/imageDisplay", method = RequestMethod.GET)
	public void showImage(@RequestParam("id") Integer itemId, HttpServletResponse response, HttpServletRequest request)
			throws ServletException, IOException, SQLException {
		Product item = itemService.getProductbyId(itemId);
		response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
		Blob blob = item.getProductImage();
		int blobLength = 0;
		try {
			blobLength = (int) blob.length();
		}
		catch (Exception e) {}
		System.out.println("*********************************************************" + itemId);
		byte[] blobAsBytes = null ;
		
		try {
			blobAsBytes = blob.getBytes(1, blobLength);
		}
		catch(Exception e) {}
		
		response.getOutputStream().write(blobAsBytes);
		response.getOutputStream().close();
		blob.free();
	}
}