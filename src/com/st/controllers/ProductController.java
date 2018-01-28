package com.st.controllers;

import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.beans.Feature;
import com.dao.FeatureDAO;
import com.utils.PriceComparator;
import com.utils.ProductNameComparator;
import com.utils.ReversePriceComparator;
import com.st.beans.Cart;
import com.utils.ReverseProductNameComparator;
import com.st.beans.Product;
import com.st.beans.Review;
import com.st.dao.DAOImpl.CartDAOImpl;
import com.st.dao.DAOImpl.OrderDAOImpl;
import com.st.dao.DAOImpl.PaymentDAOImpl;
import com.st.dao.DAOImpl.ProductCategoryDAOImpl;
import com.st.dao.DAOImpl.ProductDAOImpl;
import com.st.dao.DAOImpl.ReviewDAOImpl;
import com.st.dao.DAOImpl.ReviewReplyDAOImpl;
import com.st.dao.DAOImpl.ShipmentDAOImpl;
import com.st.dao.DAOImpl.TrackDAOImpl;
import com.st.services.MailService;
import com.utils.UserRoles;
import com.service.CustomerService ;
import com.service.SellerService ;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductDAOImpl productService;

	@Autowired
	JdbcTemplate jdbcTemplate;

	public ProductDAOImpl getProductService() {
		return productService;
	}

	public void setProductService(ProductDAOImpl productService) {
		this.productService = productService;
	}

	@Autowired
	private ReviewDAOImpl reviewService;

	public ReviewDAOImpl getReviewService() {
		return reviewService;
	}

	public void setReviewService(ReviewDAOImpl reviewService) {
		this.reviewService = reviewService;
	}

	@Autowired
	private ProductCategoryDAOImpl productCategoryService;

	public ProductCategoryDAOImpl getProductCategoryService() {
		return productCategoryService;
	}

	public void setProductCategoryService(ProductCategoryDAOImpl productCategoryService) {
		this.productCategoryService = productCategoryService;
	}

	@Autowired
	private ReviewReplyDAOImpl reviewReplyService;

	public ReviewReplyDAOImpl getReviewReplyService() {
		return reviewReplyService;
	}

	public void setReviewReplyService(ReviewReplyDAOImpl reviewReplyService) {
		this.reviewReplyService = reviewReplyService;
	}
	
	@Autowired
	private CartDAOImpl cartService;
	
	public CartDAOImpl getCartService() {
		return cartService;
	}

	public void setCartService(CartDAOImpl cartService) {
		this.cartService = cartService;
	}
	
	@Autowired
	private PaymentDAOImpl paymentService;
	

	public PaymentDAOImpl getPaymentService() {
		return paymentService;
	}

	public void setPaymentService(PaymentDAOImpl paymentService) {
		this.paymentService = paymentService;
	}
	
	@Autowired
	private ShipmentDAOImpl shipmentService;
	

	public ShipmentDAOImpl getShipmentService() {
		return shipmentService;
	}

	public void setShipmentService(ShipmentDAOImpl shipmentService) {
		this.shipmentService = shipmentService;
	}
	
	@Autowired
	private TrackDAOImpl trackService;
	

	public TrackDAOImpl getTrackService() {
		return trackService;
	}

	public void setTrackService(TrackDAOImpl trackService) {
		this.trackService = trackService;
	}
	@Autowired
	public OrderDAOImpl orderService;
	
	public OrderDAOImpl getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderDAOImpl orderService) {
		this.orderService = orderService;
	}
	@Autowired
	private MailService mailService;

	@RequestMapping(value = "/jsp")
	public String forgotPassword() {
		return "forgotpassword";
	}

	@RequestMapping("/productList/all")
	public String getProducts(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession(false) ;
		
		if(session.getAttribute("productCategoryFromSession") != null) {
			session.removeAttribute("productCategoryFromSession") ;
		}
		if(session.getAttribute("brandsFromSession") != null) {
			session.removeAttribute("brandsFromSession") ;
		}
		if(session.getAttribute("featuresFromSession") != null) {
			session.removeAttribute("featuresFromSession") ;
		}
		
		List<Product> products = productService.getProductList();
		//model.addAttribute("products", products);
		session.setAttribute("productsFromSession", products);
		return "productList";
	}

	@RequestMapping("/productList/search")
	public String getProductsBySearch(Model model) {
		List<Product> products = productService.getProductList();
		model.addAttribute("products", products);
		return "productList";
	}

	@RequestMapping("/productList/productFilter/{productCategory}")
	public String getProductsbyCategory(@PathVariable String productCategory, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		System.out.println("Inside getProductsbyCategory");
		List<Product> products = productService.getProductsbyCategory(productCategory);
		// model.addAttribute("products", products);
		session.setAttribute("productsFromSession", products);
		FeatureDAO fDao = new FeatureDAO();

		ArrayList<Feature> features = fDao.getFeaturesForProductCategory(jdbcTemplate, productCategory);

		for (Feature feature : features) {
			System.out.println("feature.getFeatureID = " + feature.getFeatureID());
			System.out.println("feature.getFeatureName = " + feature.getFeatureName());

			for (String featureValue : feature.getFeatureValues()) {
				System.out.println("featureValue = " + featureValue);
			}
		}
		ArrayList<String> brands = fDao.getBrands(jdbcTemplate, productCategory);

		// model.addAttribute("brands", brands) ;
		session.setAttribute("brandsFromSession", brands);

		// model.addAttribute("productCategoryForFilter", productCategory) ;
		session.setAttribute("productCategoryFromSession", productCategory);

		// model.addAttribute("features", features);
		session.setAttribute("featuresFromSession", features);

		return "productList";
	}
	
	@RequestMapping("/productList/getSellerProducts")
	public String getSellerProducts(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		System.out.println("Inside getSellerProducts");
		
		if(session.getAttribute("userType") != null && session.getAttribute("userEmail") != null && 
				session.getAttribute("userType").toString().equalsIgnoreCase(UserRoles.SELLER)) {
			String sellerID = (String)session.getAttribute("userEmail") ;
			List<Product> products = productService.getProductsbySellerID(sellerID) ;
			// model.addAttribute("products", products);
			session.setAttribute("productsFromSession", products) ;
			return "productList";
		}
		else {
			return "jsp/user/login" ;
		}
	}

	@RequestMapping(value="/productList/filterProducts", method = RequestMethod.POST)
	public String filterProducts(HttpServletRequest request, Model model) {
		System.out.println("Inside filterProducts");
		HttpSession session = request.getSession(false);
		String productCategory = request.getParameter("productCategoryForFilter");
		
		String[] brandsArr = request.getParameterValues("brands");
		ArrayList<String> brands = null ;
		if(brandsArr != null && brandsArr.length > 0) {
			brands = new ArrayList<String>(Arrays.asList(brandsArr));
			System.out.println("Displaying brands");
			for (String brand : brands) {
				System.out.println(brand);
			}
		}

		Enumeration<String> attributes = request.getParameterNames();
		ArrayList<Feature> features = null ;
		if(attributes != null) {
			features = new ArrayList<Feature>();
			
			while (attributes.hasMoreElements()) {
				String featureID = attributes.nextElement();
				String[] featureV = request.getParameterValues(featureID);
				ArrayList<String> featureValues = new ArrayList<String>(Arrays.asList(featureV));
				Feature feature = new Feature(featureID, featureValues);
				features.add(feature);
			}
			
			features.remove(0); // The first feature will be product category ID
			if(brands!= null && brands.size()>0 && features.size()>0) {
				features.remove(0); // The second feature will be brands
			}
			
			if(features != null && features.size()>0) {
				System.out.println("Printing the input features:");
				for (Feature tFeature : features) {
					System.out.println("Feature ID = " + tFeature.getFeatureID());
					for (String tFeatureValue : tFeature.getFeatureValues()) {
						System.out.println("Feature Value = " + tFeatureValue);
					}
				}
			}

		}

		List<Product> products = productService.getFilteredProducts(productCategory, brands, features);

		System.out.println("Printing products:");

		for (Product product : products) {
			System.out.println("Product ID = " + product.getProductId());
			System.out.println("Product name = " + product.getProductName());
		}

		//model.addAttribute("products", products);
		session.setAttribute("productsFromSession", products);
		
		FeatureDAO fDao = new FeatureDAO();
		System.out.println("productCategory inside filterProducts = " + productCategory);
		ArrayList<Feature> featureList = fDao.getFeaturesForProductCategory(jdbcTemplate, productCategory);
		
		//model.addAttribute("features", featureList);
		session.setAttribute("featuresFromSession", featureList);
		
		ArrayList<String> brandsToBeSet = fDao.getBrands(jdbcTemplate, productCategory);
		//model.addAttribute("brands", brandsToBeSet);
		session.setAttribute("brandsFromSession", brandsToBeSet);
		
		//model.addAttribute("productCategoryForFilter", productCategory);
		session.setAttribute("productCategoryFromSession", productCategory);
		
		return "productList";
	}
	
	@RequestMapping(value="/productList/sortProducts", method = RequestMethod.POST)
	public String sortProducts(HttpServletRequest request, Model model) {
		System.out.println("Inside sortProducts") ;
		HttpSession session = request.getSession(false) ;
		String productSortBy = request.getParameter("productSortBy") ;
		System.out.println("productSortBy = " + productSortBy) ;
		
		@SuppressWarnings("unchecked")
		ArrayList<Product> products = (ArrayList<Product>) session.getAttribute("productsFromSession") ;
		
		if(productSortBy.equalsIgnoreCase("HIGH")) {
			Collections.sort(products, new ReversePriceComparator()) ;
		}
		else if(productSortBy.equalsIgnoreCase("LOW")) {
			Collections.sort(products, new PriceComparator()) ;
		}
		else if(productSortBy.equalsIgnoreCase("A2Z")) {
			Collections.sort(products, new ProductNameComparator()) ;
		}
		else if(productSortBy.equalsIgnoreCase("Z2A")) {
			Collections.sort(products, new ReverseProductNameComparator()) ;
		}
		model.addAttribute("productSortBy", productSortBy) ;
		
		session.removeAttribute("productsFromSession") ;
		session.setAttribute("productsFromSession", products) ;
		return "productList";
	}
	
	@RequestMapping("/recentlyViewedProducts")
	public String getRecentlyViewedProducts(HttpServletRequest request, Model model) {
		System.out.println("Inside getRecentltViewedProducts") ;
		HttpSession session = request.getSession(false) ;
		
		if(session.getAttribute("userType") != null && session.getAttribute("userEmail") != null && 
				session.getAttribute("userType").toString().equalsIgnoreCase(UserRoles.CUSTOMER)) {
			String customerEmail = (String)session.getAttribute("userEmail") ;
			List<Product> recentlyViewedProducts = productService.getRecentlyViewedProducts(customerEmail) ;
			model.addAttribute("recentlyViewedProducts", recentlyViewedProducts) ;
			return "recentlyViewedProducts_customer" ;
		}
		else {
			return "jsp/user/login" ;
		}
	}
	
	@RequestMapping("/deleteProduct")
	public String deleteProduct(HttpServletRequest request, Model model) {
		String productID = request.getParameter("productID") ;
		System.out.println("Inside deleteProduct") ;
		HttpSession session = request.getSession(false) ;
		
		if(session.getAttribute("userType") != null && session.getAttribute("userEmail") != null && 
				(session.getAttribute("userType").toString().equalsIgnoreCase(UserRoles.SELLER) ||
				 session.getAttribute("userType").toString().equalsIgnoreCase(UserRoles.ADMIN ) ) ) {
			int deletedFeatureCount = productService.deleteFeatures(productID) ;
			int deletedProductCount = productService.deleteProduct(productID) ;
			
			System.out.println("deletedFeatureCount = " + deletedFeatureCount) ;
			System.out.println("deletedProductCount = " + deletedProductCount) ;
			if(session.getAttribute("message") != null) {
				session.removeAttribute("message") ;
			}
			
			if(deletedProductCount > 0) {
				session.setAttribute("message", "Product Deleted Successfully") ;
			}
			else {
				session.setAttribute("message", "Some error occurred") ;
			}
			return "message" ;
		}
		else {
			return "jsp/user/login" ;
		}
	}
	
	@RequestMapping(value = "/modifyProduct", method = RequestMethod.POST)
	public String modifyProduct(HttpServletRequest request, Model model) {
		System.out.println("Inside modifyProduct") ;
		HttpSession session = request.getSession(false) ;
		
		String productIDStr = request.getParameter("productID") ;
		int productID = Integer.parseInt(productIDStr) ;

		if(session.getAttribute("userType") != null && session.getAttribute("userEmail") != null && 
				(session.getAttribute("userType").toString().equalsIgnoreCase(UserRoles.SELLER) ||
				 session.getAttribute("userType").toString().equalsIgnoreCase(UserRoles.ADMIN ) ) ) {
			String productName = request.getParameter("productName") ;
			String productDescription = request.getParameter("productDescription") ;
			
			String productQuantityStr = request.getParameter("productQuantity") ;
			int productQuantity = Integer.parseInt(productQuantityStr) ;
			
			String productPriceStr = request.getParameter("productPrice") ;
			double productPrice = Double.parseDouble(productPriceStr) ;
			
			System.out.println("productID = " + productID) ;
			System.out.println("productName = " + productName) ;
			System.out.println("productQuantity = " + productQuantity) ;
			System.out.println("productDescription = " + productDescription) ;
			System.out.println("productPrice = " + productPrice) ;
			
			Product product = new Product(productID, productName, productQuantity, productDescription, productPrice) ;
			int rowCount = productService.modifyProduct(product) ;
			
			if(rowCount > 0) {
				model.addAttribute("message", "Product modified Successfully") ;
			}
			else {
				model.addAttribute("message", "Some error occurred") ;
			}
			
			Product productToBeSet = productService.getProductbyId(productID);
			List<Review> reviewList = reviewService.getReviewsList(productID);
			model.addAttribute("product", productToBeSet) ;
			FeatureDAO fDao = new FeatureDAO();
			List<Feature> featureList = fDao.getProductDescription(jdbcTemplate, productID);
			model.addAttribute("descriptionFeatureList", featureList);
			model.addAttribute("reviewList", reviewList);
			model.addAttribute("grantEditPermission", true) ;
			return "viewProduct";
		}
		else {
			return "jsp/user/login" ;
		}
	}

	@RequestMapping("/viewProduct/{productId}")
	public String viewProduct(@PathVariable int productId, Model model, HttpSession session) throws Exception {
		FeatureDAO fDao = new FeatureDAO();
		Product product = productService.getProductbyId(productId);
		List<Review> reviewList = reviewService.getReviewsList(productId);
		List<Product> recommendedProducts = productService
				.getProductsbyCategory(productCategoryService.getProductType(product.getProductCategoryId()));
		model.addAttribute("product", product);
		System.out.println(session.getAttribute("userType"));
		List<Feature> featureList = fDao.getProductDescription(jdbcTemplate, productId);
		model.addAttribute("descriptionFeatureList", featureList);
		model.addAttribute("recommendedProducts", recommendedProducts);
		model.addAttribute("reviewList", reviewList);
		
		//Changes for adding Viewed Products start and enabling Admin and seller to update item details
		if(session.getAttribute("userType") != null && session.getAttribute("userEmail") != null) {
			String userType = (String)session.getAttribute("userType") ;
			String userEmail = (String)session.getAttribute("userEmail") ;
			boolean grantEditPermission = false ;
			
			if(userType.equals(UserRoles.CUSTOMER)) {
				CustomerService cService = new CustomerService() ;
				boolean isInserted = cService.addRecentlyViewedProduct(jdbcTemplate, userEmail, productId) ;
				System.out.println("isInserted = " + isInserted) ;
			}
			else if(userType.equals(UserRoles.ADMIN)) {
				grantEditPermission = true ;
			}
			else if(userType.equals(UserRoles.SELLER)) {
				SellerService sService = new SellerService() ;
				boolean isSellerForProduct = sService.isSellerForProduct(jdbcTemplate, userEmail, productId) ;
				if(isSellerForProduct) {
					grantEditPermission = true ;
				}
			}
			
			if(grantEditPermission) {
				model.addAttribute("grantEditPermission", grantEditPermission) ;
			}
		}
		//Changes for adding Viewed Products start
		
		if ((UserRoles.SELLER.equalsIgnoreCase((String) session.getAttribute("userType")))
				&& (product.getSellerId().equalsIgnoreCase((String) session.getAttribute("userEmail"))))
			model.addAttribute("flag", true);
		if ((productService.getOrders(product.getProductId(), (String) session.getAttribute("userEmail")) > 0))
			model.addAttribute("flagreviewadd", true);
		return "viewProduct";
	}
	
	

	@RequestMapping("/writeReview/{productId}")
	public String writeReview(@PathVariable int productId, Model model, HttpServletRequest request, HttpSession session)
			throws Exception {
		System.out.println("productId------------" + productId + "----" + request.getParameter("review"));
		int flag = reviewService.writeReview(productId, request.getParameter("review"),
				(String) session.getAttribute("userEmail"));
		if (flag != 0)
			return viewProduct(productId, model, session);
		else
			return "error";
	}

	@RequestMapping("/writeReviewReply/{reviewId}")
	public String writeReviewReply(@PathVariable int reviewId, Model model, HttpServletRequest request,
			HttpSession session) throws Exception {
		System.out.println("reviewId------------" + reviewId + "----" + request.getParameter("reply") + "-----product"
				+ request.getParameter("userEmail"));
		int flag = reviewReplyService.SaveReviewReply(reviewId, (String) session.getAttribute("userEmail"),
				request.getParameter("reply"));
		if (flag != 0)
			return viewProduct(Integer.valueOf(request.getParameter("productId")), model, session);
		else
			return "error";
	}

	@RequestMapping("/faq")
	public String viewFAQ(Model model) {
		return "faq";
	}
	
	@RequestMapping("/cartList")
    public String getCart(Model model){
		List<Cart> cartItems = cartService.getCartList();
		if(cartItems.isEmpty())
			return "checkoutempty";
		model.addAttribute("cartItems", cartItems);        
		return "checkout";
    }
	
	  
	  @RequestMapping("/checkout/{productId}")
	    public String addProductToCart(@PathVariable int productId, Model model, HttpSession session) throws IOException{
		  Product product = productService.getProductbyId(productId); 
		  String useremail = (String)session.getAttribute("userEmail");
		  //String useremail = "abc@gmail.com";
		  if(useremail==null){
			  return "jsp/user/login";
		  }
		  	cartService.addProductToCart(product);
	        List<Cart> cartItems = cartService.getCartList();
	        model.addAttribute("cartItems", cartItems);
	        //model.addAttribute("cart", cart);
	        return "checkout";
	    }
	  
	  @RequestMapping("/remove/{productId}")
	    public String deleteProductfromCart(@PathVariable int productId, Model model) throws IOException{
		  Product product = productService.getProductbyId(productId);  
		  	cartService.delProductFromCart(product);
	        List<Cart> cartItems = cartService.getCartList();
	        if(cartItems.isEmpty())
				return "checkoutempty";
	        model.addAttribute("cartItems", cartItems);
	        //model.addAttribute("cart", cart);
	        return "checkout";
	    }

	  
	  @RequestMapping("/update/")
	    public String updateProductfromCart(Model model, HttpServletRequest request) throws IOException{
		  System.out.println("updateProductfromCart***") ;
		  //Product product = productService.getProductbyId(productId);
		  System.out.println(request.getParameter("qty"));
		  	//cartService.editProductInCart(product,Integer.parseInt(request.getParameter("qty")));
	        List<Cart> cartItems = cartService.getCartList();
	        System.out.println(cartItems);
	        String [] quantity = request.getParameterValues("qty");
	        for(int i =0; i<cartItems.size(); i++){
	        	cartItems.get(i).setQuantity(Integer.parseInt(quantity[i]));
	        }
	        model.addAttribute("cartItems", cartItems);
	        return "checkout";
	    }
	  
	  @RequestMapping("/paymentpage/")
	    public String payment(Model model) throws IOException{
		  	List<Cart> cartItems = cartService.getCartList();
		  	model.addAttribute("cartItems", cartItems);
	        return "payment";
	    }

	@RequestMapping("/payment/")
	public String makepayment(Model model, HttpServletRequest request, HttpSession session) throws IOException {

		@SuppressWarnings("unused")
		String cardnumber = request.getParameter("cardnumber");
		@SuppressWarnings("unused")
		int cvc = Integer.parseInt(request.getParameter("cvc"));
		@SuppressWarnings("unused")
		String expdate = request.getParameter("expyear") + "-" + request.getParameter("expmonth") + "-" + "01";
		// double amount = Double.parseDouble(request.getParameter("amount")) ;
		@SuppressWarnings("unused")
		String fname = request.getParameter("fname");
		@SuppressWarnings("unused")
		String lname = request.getParameter("lname");
		String billaddress = request.getParameter("billaddress");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String country = request.getParameter("country");
		String number = request.getParameter("number");
		int zipCode = Integer.parseInt(request.getParameter("zip"));
		// System.out.println(cardnumber+"cvv"+cvc+"expdate"+expdate+"amount"+amount+"fname"+fname+"lname"+lname+"billaddress"+billaddress);
		// Payment payment = new Payment(13333,cardnumber, expdate, cvc, amount,
		// fname, lname, billaddress) ;
		// paymentService.addPaymentDetails(cardnumber,expdate,cvc,fname,lname,billaddress);
		// model.addAttribute("cart", cart);
		String costumerId = (String) session.getAttribute("userEmail");

		orderService.insertOrder(billaddress, city, state, country, zipCode, costumerId, number);
		// shipmentService.addShipmentDetails();
		cartService.delAllProductFromCart();
		// mailService.sendMail(costumerId);

		return "message1";
	}
	  
	  @RequestMapping("/track")
	  public String trackingOrdersPage(Model model)
	  {
		  return "track";
	  }
	  
	  @RequestMapping("/tracking")
	  public String trackingOrders(Model model, HttpServletRequest request)
	  {
		  HttpSession session = request.getSession(false) ;
		  int id = Integer.parseInt(request.getParameter("trackid"));
		  System.out.println("id = " + id) ;
		  String shipment = trackService.trackOrder(id);
		  session.setAttribute("shipmentStatus", shipment) ;
		  return "trackorder";
	  }
	  @RequestMapping("/trackingbyId/{productId}")
	  public String trackingOrdersbyId(@PathVariable int productId,Model model, HttpServletRequest request,HttpSession session)
	  {
		 // int id = Integer.parseInt(request.getParameter("trackid"));
		  //System.out.println("id = " + id) ;
		  String shipment = trackService.trackOrder(productId);
		  System.out.println(shipment);
		  session.setAttribute("shipmentStatus", shipment) ;
		  return "trackorder";
	  }
	public MailService getMailService() {
		return mailService;
	}

	public void setMailService(MailService mailService) {
		this.mailService = mailService;
	}
}
