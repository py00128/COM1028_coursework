package com1028_coursework;

public class ProductLine {
	
	private String productLine = null;
	private double profit = 0;

	public ProductLine(String productLine) {
		super();
		this.productLine = productLine;
		
	}

	public String getProductLine() {
		return productLine;
	}
	
	public void addProfit(double profit) {
		this.profit = this.profit + profit;
	}
	
	public double getProfit() {
		return profit;
	}
	
	

}
