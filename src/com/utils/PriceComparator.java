package com.utils;

import java.util.Comparator ;
import com.st.beans.Product ;

public class PriceComparator implements Comparator<Product> {

	@Override
	public int compare(Product product1, Product product2) {
		if(product1.getProductCost() > product2.getProductCost()) {
			return 1 ;
		}
		else if(product1.getProductCost() < product2.getProductCost()) {
			return -1 ;
		}
		else {
			return 0 ;
		}
	}

}
