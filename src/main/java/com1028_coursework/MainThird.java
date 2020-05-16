package com1028_coursework;

import java.util.List;

public class MainThird {

	public static void main(String[] args) throws Exception{
		
		s3();

	}
	
	public static String s3() {
		BaseQuery bq = new BaseQuery();
		List<ProductLine> productLine = bq.getProductLine();
		List<Products> products = bq.getProducts();
		List<Orderdetails> orderdetails = bq.getOrderdetails();
		
		for (ProductLine prodline : productLine) {
			for(Products prod : products) {
				if(prodline.getProductLine().equals(prod.getProductLine())) {
					int count = 0;
					double profit = 0;
					for(Orderdetails order : orderdetails) {
						if(order.getProductCode().equals(prod.getProductCode())) {
							profit = profit + (order.getQuantityOrdered()*(order.getPriceEach() - prod.getBuyPrice())); 
						}
					}
					prodline.addProfit(profit);
					
			
				}
			}
		System.out.println("Product Line: " + prodline.getProductLine() + "\t" + "Profit: " + prodline.getProfit());	
		
		}
		return "";
	}
}
