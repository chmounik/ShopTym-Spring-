package com.st.dao;

import java.util.List;

import com.st.beans.Cart;
import com.st.beans.Product;


public interface CartDAO {

	public List<Cart> getCartList() throws Exception;
	public Cart getCartbyId(int Id);
	public void addProductToCart(Product product);
	public void delProductFromCart(Product product);
	public void delAllProductFromCart();
	public void editProductInCart(Product product, int qty);
}
