package com1028_coursework;

public class Orderdetails {
	
	
	private String productCode = null;
	private int quantityOrdered = 0;
	private double priceEach = 0;
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
