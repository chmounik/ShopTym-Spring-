package com.utils;

import java.util.Comparator ;
import com.st.beans.Product ;

public class ProductNameComparator implements Comparator<Product> {

	@Override
	public int compare(Product product1, Product product2) {
		return product1.getProductName().compareToIgnoreCase(product2.getProductName()) ;
	}

}
