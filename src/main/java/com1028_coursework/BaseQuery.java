package com1028_coursework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class BaseQuery {
	protected Connection connect;
	private final String data_base = "jdbc:mysql://localhost:3306/classicmodels";
	private String user = "root";
	private String password = "";
	
	
	public BaseQuery() {
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver ());
            connect = DriverManager.getConnection( data_base, user, password);
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
	
	public List<Products> getProducts(){
		ArrayList<Products> products = new ArrayList<Products>();
		try {
			String query = "SELECT * FROM products";
			
			Statement statement = connect.createStatement();
			
			ResultSet resultSet = statement.executeQuery(query);
			
			while(resultSet.next()) {
				
				String product_code = resultSet.getString("productCode");
				String product_name = resultSet.getString("productName");
				String product_line = resultSet.getString("productLine");
				int quantity_in_stock = resultSet.getInt("quantityInStock");
				double buy_price = resultSet.getDouble("buyPrice");
				double msrp = resultSet.getDouble("MSRP");	
				
				products.add(new Products(product_code, product_name,product_line, quantity_in_stock, buy_price, msrp));
			}

		}
		catch (SQLException e) {
			System.out.println("SQL exception");
			throw new RuntimeException(e);
		}
		return products;
		
	}
	
	public List<Payments> getPayments(){
		ArrayList<Payments> payments = new ArrayList<Payments>();
		try {
			String query = "SELECT * FROM payments";
			
			Statement statement = connect.createStatement();
			
			ResultSet resultSet = statement.executeQuery(query);
			
			while(resultSet.next()) {
				
				int customer_number = resultSet.getInt("customerNumber");
				String check_number = resultSet.getString("checkNumber");
				Date payment_date = resultSet.getDate("paymentDate");
				double amount = resultSet.getDouble("amount");
				
				payments.add(new Payments(customer_number, check_number, payment_date, amount));
		
			}

		}
		catch (SQLException e) {
			System.out.println("SQL exception");
			throw new RuntimeException(e);
		}
		return payments;
		
	}
	
	public List<Orderdetails> getOrderdetails(){
		ArrayList<Orderdetails> orderdetails = new ArrayList<Orderdetails>();
		try {
			String query = "SELECT * FROM orderdetails";
			
			Statement statement = connect.createStatement();
			
			ResultSet resultSet = statement.executeQuery(query);
			
			while(resultSet.next()) {
				
				String product_code = resultSet.getString("productCode");
				int quantity_ordered = resultSet.getInt("quantityOrdered");
				double price_each = resultSet.getDouble("priceEach");
				
				orderdetails.add(new Orderdetails(product_code, quantity_ordered, price_each));
		
			}

		}
		catch (SQLException e) {
			System.out.println("SQL exception");
			throw new RuntimeException(e);
		}
		return orderdetails;
		
	}
	
	public List<ProductLine> getProductLine(){
		ArrayList<ProductLine> productLine = new ArrayList<ProductLine>();
		try {
			String query = "SELECT * FROM productLines";
			
			Statement statement = connect.createStatement();
			
			ResultSet resultSet = statement.executeQuery(query);
			
			while(resultSet.next()) {
				
				String product_line = resultSet.getString("productLine");
							
				productLine.add(new ProductLine(product_line));
		
			}

		}
		catch (SQLException e) {
			System.out.println("SQL exception");
			throw new RuntimeException(e);
		}
		return productLine;
		
	}
	
}
