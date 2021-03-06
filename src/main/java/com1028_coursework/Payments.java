package com1028_coursework;

import java.util.Date;

public class Payments {
	
	private int customerNumber = 0;
	private String checkNumber = null;
	private Date paymentDate;
	private double amount = 0;
	
	
	public Payments(int customerNumber, String checkNumber, Date paymentDate, double amount) {
		super();
		this.customerNumber = customerNumber;
		this.checkNumber = checkNumber;
		this.paymentDate = paymentDate;
		this.amount = amount;
	}


	public int getCustomerNumber() {
		return this.customerNumber;
	}


	public String getCheckNumber() {
		return this.checkNumber;
	}


	public Date getPaymentDate() {
		return this.paymentDate;
	}


	public double getAmount() {
		return this.amount;
	}
	
	

}
