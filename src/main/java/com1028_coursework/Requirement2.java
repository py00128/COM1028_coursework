package com1028_coursework;

import java.util.List;

public class Requirement2 {

	public static void main(String[] args) throws Exception {
		
		s2();
	}
	
	public static String s2() {
		BaseQuery dao = new BaseQuery("root", "Parsa80");
		List<Products> products = dao.getProducts();
		List<Orderdetails> orderdetails = dao.getOrderdetails();
		

		for (Products prod : products) {
			int count = 0;
			
			for (Orderdetails order : orderdetails) {
				
				if(prod.getProductCode().equals(order.getProductCode())) {
					count++;
					
				}
			}
			if(count == 0) {
				System.out.print("Product Name: " + prod.getProductName());
				
			}
		}
		return "";
	}

}
