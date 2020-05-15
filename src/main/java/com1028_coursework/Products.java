package com1028_coursework;

public class Products {
	
	private String productCode = null;
	private String productName = null;
	private String productLine = null;
	private int quantityInStock = 0;
	private double buyPrice = 0;
	private double msrp = 0;
	
	
	public Products(String productCode, String productName, String productLine,
			int quantityInStock, double buyPrice, double msrp) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.productLine = productLine;
		this.quantityInStock = quantityInStock;
		this.buyPrice = buyPrice;
		this.msrp = msrp;
	}
	
	public String getProductCode() {
		return this.productCode;
	}
	
	public String getProductName() {
		return this.productName;
	}
	
	public double getBuyPrice() {
		return this.buyPrice;
	}
	
	public int getQuantityInStock() {
		return this.quantityInStock;
	}
	
	public double getMSRP() {
		return this.msrp;
	}
	

}
