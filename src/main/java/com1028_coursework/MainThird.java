package com1028_coursework;

public class MainThird {

	public static void main(String[] args) throws Exception{
		
		BaseQuery bq = new BaseQuery("root", "Parsa80");
		System.out.println(bq.selectProfitEachLine());

	}

}
