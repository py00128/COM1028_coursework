package com1028_coursework;

public class Orderdetails {
	
	
	private String productCode;
	private int quantityOrdered;
	private double priceEach;
	public Orderdetails(String productCode, int quantityOrdered, double priceEach) {
		super();
		this.productCode = productCode;
		this.quantityOrdered = quantityOrdered;
		this.priceEach = priceEach;
	}
	public String getProductCode() {
		return productCode;
	}
	public int getQuantityOrdered() {
		return quantityOrdered;
	}
	public double getPriceEach() {
		return priceEach;
	}
	
	

}
