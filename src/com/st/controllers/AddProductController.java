package com.st.controllers;

import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.beans.Feature;
import com.beans.FeatureIDValuePair;
import com.beans.ProductCategoryIDMap;
import com.service.AddProductService ;
import com.utils.UserRoles ;

@Controller
@RequestMapping("/addproduct")
public class AddProductController {
	
	@Autowired
    JdbcTemplate jdbcTemplate;
	
	@RequestMapping("/add")
	public String addProduct(HttpServletRequest request, Model model) {
		System.out.println("Request getting till here");
		HttpSession session = request.getSession(false ) ;
		
		if(session.getAttribute("userType") != null && session.getAttribute("userEmail") != null
				&& session.getAttribute("userType").toString().equalsIgnoreCase(UserRoles.SELLER) ) {
			String sellerId = session.getAttribute("userEmail").toString() ;
			String productName = request.getParameter("productname");
			String productDescription = request.getParameter("productdescription");
			String productCategory = request.getParameter("productCategory");
			System.out.println("productCategory = " + productCategory) ;
			String productQuantity = request.getParameter("productquantity");
			String productPrice = request.getParameter("productprice");
			String brandName = request.getParameter("productBrand");
			AddProductService adpService = new AddProductService();
			adpService.addProduct(jdbcTemplate, productName, sellerId, productCategory, productDescription,
					productQuantity, productPrice, brandName);
			
			ArrayList<Feature> featureTemplateList = adpService.getFeatures(jdbcTemplate, productCategory) ;
			model.addAttribute("featureTemplateList", featureTemplateList) ;
			if(featureTemplateList != null && featureTemplateList.size() > 0) {
				for(Feature thisFeature: featureTemplateList) {
					System.out.println("thisFeature.getFeatureID = " + thisFeature.getFeatureID() + 
							"\t thisFeature.getFeatureName = " + thisFeature.getFeatureName()) ;
				}
			}
			return "addFeatures";
		}
		else {
			return "jsp/user/login" ;
		}
	}
	
	@RequestMapping("/addProductsPage")
	public String getAddProductsPage(HttpServletRequest request, Model model) {
		AddProductService aService = new AddProductService() ;
		HttpSession session = request.getSession(false) ;
		
		if(session.getAttribute("userType") != null && session.getAttribute("userEmail") != null
				&& session.getAttribute("userType").toString().equalsIgnoreCase(UserRoles.SELLER) ) {
			String sellerEmail = (String)session.getAttribute("userEmail") ;
			boolean isApproved = aService.isAllowedToAddProduct(jdbcTemplate, sellerEmail) ;
			
			if(! isApproved) {
				String message = "You are not an approved Seller. Please contact administrator to add products" ;
				
				if(session.getAttribute("message") != null) {
					session.removeAttribute("message") ;
				}
				session.setAttribute("message", message) ;
				return "message" ;
			}
			ArrayList<ProductCategoryIDMap> productCategories = aService.getProductCategories(jdbcTemplate) ;
			if(productCategories != null && productCategories.size() > 0) {
				for(ProductCategoryIDMap productCategory : productCategories) {
					System.out.println("productCategory.getProductCategoryID = " + productCategory.getProductCategoryID() + 
							"\tproductCategory.getCategoryName = " + productCategory.getCategoryName()) ;
				}
				model.addAttribute("productCategories", productCategories) ;
			}
			
			System.out.println("Inside getAddProductsPage");
			return "addproduct";
		}
		else {
			return "jsp/user/login" ;
		}
	}
	
	@RequestMapping("/addFeatures")
	public String addFeatures(HttpServletRequest request, Model model) {
		System.out.println("Inside addFeatures");

		Enumeration<String> attributes = request.getParameterNames();
		ArrayList<FeatureIDValuePair> features = null ;
		String message = "" ;
		if(attributes != null) {
			features = new ArrayList<FeatureIDValuePair>();
			
			while (attributes.hasMoreElements()) {
				String featureID = attributes.nextElement();
				String featureValue = request.getParameter(featureID) ;
				
				FeatureIDValuePair feature = new FeatureIDValuePair(featureID, featureValue) ;
				features.add(feature);
			}
			
			if(features != null && features.size()>0) {
				System.out.println("Printing the input features:");
				for (FeatureIDValuePair tFeature : features) {
					System.out.println("Feature ID = " + tFeature.getFeatureID());
					System.out.println("Feature Value = " + tFeature.getFeatureValue());
				}
			}
			
			AddProductService aService = new AddProductService() ;
			boolean isAllInserted = aService.addFeatures(features, jdbcTemplate) ;
			
			if(isAllInserted) {
				message = "The product has been successfully added. "
						+ "Please click 'VIEW ADDED PRODUCTS' to view all your products." ;
			}
		}
		else {
			message = "Some problem occurred" ;
		}
		
		HttpSession session = request.getSession(false) ;
		if(session.getAttribute("message") != null) {
			session.removeAttribute("message") ;
		}
		session.setAttribute("message", message) ;
		return "message" ;
	}
}

