package com1028_coursework;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BaseQuery bq = new BaseQuery("root", "Parsa80");
		System.out.println(bq.selectPriceAbove100());

	}

}
