package com.st.dao.DAOImpl;

import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.st.beans.Product;
import com.st.dao.OrderDAO;
import com.st.services.MailService;
@Component
public class OrderDAOImpl implements OrderDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Autowired
	private ProductDAOImpl productService;
	
	public ProductDAOImpl getProductService() {
		return productService;
	}

	public void setProductService(ProductDAOImpl productService) {
		this.productService = productService;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	@Autowired
	private MailService mailService;

	public MailService getMailService() {
		return mailService;
	}

	public void setMailService(MailService mailService) {
		this.mailService = mailService;
	}

	@Override
	public void insertOrder(String addr1,String city,String state,String country,int zip,String costumerid,String number) {
		try {
			String addrsquery="INSERT INTO ADDRESS(addressline1,city,state,country,zipcode) VALUES('"+addr1+"','"+city+"','"+state+"','"+country+"','"+zip+"')";
			jdbcTemplate.update(addrsquery);
			String addrsidquery="SELECT addressid FROM ADDRESS ORDER BY addressid DESC LIMIT 1";
			int addrsid=jdbcTemplate.queryForInt(addrsidquery);
			System.out.println(addrsid);
			String query = "INSERT INTO ORDERS ( customerid , transactionstatus,shippingaddressid,contactno ) VALUES ( ? , ?, ?, ? ) ";
			Object[] queryObjects = {costumerid,1,addrsid,number} ;
			int[] types = new int[] {Types.VARCHAR,Types.INTEGER,Types.INTEGER,Types.VARCHAR  } ;
			jdbcTemplate.update(query, queryObjects, types) ;
			String query2 = "SELECT ORDERID FROM ORDERS ORDER BY ORDERID DESC LIMIT 1";
			int orderid = jdbcTemplate.queryForInt(query2);
			System.out.println(orderid);
			String productidquery="SELECT productid FROM SHOPPINGCART ORDER BY cartid DESC LIMIT 1";
			int productid = jdbcTemplate.queryForInt(productidquery);
			System.out.println(productid);
			String quantityquery="SELECT quantity FROM SHOPPINGCART ORDER BY cartid DESC LIMIT 1";
			int quantity = jdbcTemplate.queryForInt(quantityquery);
			System.out.println(quantity);
			String query3="INSERT INTO SHOPPINGCARTPRODUCT(orderid,productid,quantity) VALUES (?, ?, ? ) ";
			Object[] queryObjects3 = {orderid,productid,quantity} ;
			int[] types3 = new int[] {Types.INTEGER,Types.INTEGER,Types.INTEGER} ;
			jdbcTemplate.update(query3, queryObjects3, types3) ;
			String shoppingcartproductidquery="SELECT shoppingcartproductid FROM SHOPPINGCARTPRODUCT ORDER BY shoppingcartproductid DESC LIMIT 1";
			int shoppingcartproductid=jdbcTemplate.queryForInt(shoppingcartproductidquery);
			
			String query4 = "INSERT INTO SHIPMENT (shoppingcartproductid,shipmentstatus) VALUES (?, ?) ";
			Object[] queryObjects4 = {shoppingcartproductid,"Ordered"} ;
			int[] types4 = new int[] { Types.INTEGER, Types.VARCHAR } ;
			jdbcTemplate.update(query4, queryObjects4, types4) ;
			System.out.println(query);
			System.out.println(query);
			Product product=productService.getProductbyId(productid);
			mailService.sendMailForPayment(costumerid,product.getProductName(),quantity*product.getProductCost(),shoppingcartproductid);
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}

}
