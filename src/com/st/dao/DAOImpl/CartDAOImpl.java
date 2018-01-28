
package com.st.dao.DAOImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;import org.springframework.stereotype.Component;

import com.st.beans.Cart;
import com.st.beans.Product;
import com.st.dao.CartDAO;

import java.sql.Types;
@Component
public class CartDAOImpl implements CartDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	
	@Override
	public List<Cart> getCartList(){
		// TODO Auto-generated method stub
		String query="SELECT c.cartid,c.productname,c.productid,c.quantity,c.picture,c.cost FROM shoppingcart as c,product as p where c.productid = p.productid"; 
		System.out.println(query);
		System.out.println(jdbcTemplate.isResultsMapCaseInsensitive());
		return jdbcTemplate.query(query, new MyrowMapperCart());
	}

	@Override
	public Cart getCartbyId(int Id) {
		String query="select * from shoppingcart where productid='"+Id+"'";
		System.out.println(query);
		return jdbcTemplate.queryForObject(query, new MyrowMapperCart());
	}

	@Override
	public void addProductToCart(Product product) {
		try{
		String query = "INSERT INTO SHOPPINGCART(productname,productid,quantity,picture,cost) VALUES (?, ?, ?, ?, ?)";
		jdbcTemplate.update(query,new Object[] {product.getProductName(), product.getProductId(), 1, product.getProductImage(), product.getProductCost() });
		System.out.println(query);
		}
		catch(Exception e){
			System.out.println("Item already in cart");
		}
		
	}

	@Override
	public void delProductFromCart(Product product) {
		String query = "delete from shoppingcart where productid=" + product.getProductId();
		System.out.println(query);
		jdbcTemplate.update(query);

	}
	
	@Override
	public void delAllProductFromCart() {
		String query = "delete from shoppingcart";
		System.out.println(query);
		jdbcTemplate.update(query);

	}

	@Override
	public void editProductInCart(Product product, int qty) {
		String query = "update shoppingcart set quantity=? where productid=?" ;
		System.out.println(query);
		int[] types = new int[]{Types.INTEGER, Types.INTEGER} ;
		Object[] queryObjects = new Object[] {qty, product.getProductId()} ;
		jdbcTemplate.update(query, queryObjects, types) ;
	}

}