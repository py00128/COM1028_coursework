package com1028_coursework;

import java.util.List;

public class Requirement1 {

	public static void main(String[] args) throws Exception {
		
		s1();
		
	}
	public static String s1() {
		BaseQuery dao = new BaseQuery();
		
		List<Payments> payments = dao.getPayments();
		
		String results = "";
		for (Payments paym : payments) {			
			if(paym.getAmount() > 100000) {
				System.out.print("Customer number: " + paym.getCustomerNumber() + "\t" + "Amount: " + paym.getAmount() + "\n");
				}
			
		}
		
		return results;
		
		
	}

}
