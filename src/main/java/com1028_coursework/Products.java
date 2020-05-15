package com1028_coursework;

public class Products {
	
	private String productCode = null;
	private String productName = null;
	private String productLine = null;
	private String productScale = null;
	private String productVendor = null;
	private String productDescription = null;
	private int quantityInStock = 0;
	private double buyPrice = 0;
	private double msrp = 0;
	
	
	public Products(String productCode, String productName, String productLine, String productScale,
			String productVendor, String productDescription, int quantityInStock, double buyPrice, double msrp) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.productLine = productLine;
		this.productScale = productScale;
		this.productVendor = productVendor;
		this.productDescription = productDescription;
		this.quantityInStock = quantityInStock;
		this.buyPrice = buyPrice;
		this.msrp = msrp;
	}
	
	public String getProductCode() {
		return this.productCode;
	}
	
	
	
	

}
