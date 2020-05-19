package com1028_coursework;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Requirement3 {

	public static void main(String[] args) throws Exception{
		
		s3();

	}
	
	public static String s3() {
		BaseQuery bq = new BaseQuery("root", "");
		List<ProductLine> productLine = bq.getProductLine();
		List<Products> products = bq.getProducts();
		List<Orderdetails> orderdetails = bq.getOrderdetails();
		
		for (ProductLine prodline : productLine) {
			for(Products prod : products) {
				if(prodline.getProductLine().equals(prod.getProductLine())) {
					double profit = 0.00;
					for(Orderdetails order : orderdetails) {
						if(order.getProductCode().equals(prod.getProductCode())) {
							profit = profit + (order.getQuantityOrdered()*(order.getPriceEach() - prod.getBuyPrice())); 
						}
					}
					prodline.addProfit(profit);
					
			
				}
			}
		System.out.printf("Product Line: " + prodline.getProductLine() + "\t" + "Profit: %.2f" + "\n", prodline.getProfit());	
		
		}
		return "";
	}
}
