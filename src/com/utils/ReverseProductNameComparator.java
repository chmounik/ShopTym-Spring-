package com.utils;

import java.util.Comparator ;
import com.st.beans.Product ;

public class ReverseProductNameComparator implements Comparator<Product> {

	@Override
	public int compare(Product product1, Product product2) {
		return product2.getProductName().compareToIgnoreCase(product1.getProductName()) ;
	}

}
