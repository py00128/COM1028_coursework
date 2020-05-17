package com1028_coursework;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.security.auth.login.FailedLoginException;

import org.junit.Test;

public class Testing {
	
	protected Connection connect;
	private final String data_base = "jdbc:mysql://localhost:3306/classicmodels";
	private String user = "root";
	private String password = "Parsa80";
	
	@Test 
	public void wrongUsername() throws FailedLoginException{
		BaseQuery query = new BaseQuery ("software", "Parsa80");
	}
	
	@Test 
	public void wrongPass() throws FailedLoginException {
		BaseQuery query = new BaseQuery ("root", "password");
	}
	
	
	@Test
	public void dbconnect() throws FailedLoginException{
		BaseQuery db = new BaseQuery ("root", "Parsa80");
		
	}
	
	@Test
	public void testAbove100000() throws SQLException{
		final ByteArrayOutputStream stream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(stream));
		Requirement1 db = new Requirement1();
		db.s1();
		try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver ());
            connect = DriverManager.getConnection( data_base, user, password);
        }
        catch(Exception e) {
            System.out.println(e);
        }
		String query = "SELECT customerNumber, amount FROM payments WHERE amount > 100000;";
		Statement statement = connect.createStatement();
		ResultSet resultSet = statement.executeQuery(query);
		String results = "";
		while(resultSet.next()) {
			int customer_number = resultSet.getInt("customerNumber");
			double order_amount = resultSet.getDouble("amount");
			results = results + "Customer number: " + customer_number + "\t" + "Amount: " + order_amount + "\n";
		}
		
		assertEquals(results, stream.toString());
	}
	
	@Test
	public void productNotSold() throws SQLException{
		final ByteArrayOutputStream stream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(stream));
		Requirement2 db = new Requirement2();
		db.s2();
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver ());
            connect = DriverManager.getConnection( data_base, user, password);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		String query = "SELECT P.productName FROM products P WHERE NOT EXISTS (SELECT productName FROM orderdetails S WHERE S.productcode = P.productcode);";
		Statement statement = connect.createStatement();
		ResultSet resultSet = statement.executeQuery(query);
		String results = "";
		while(resultSet.next()) {
			String product_name = resultSet.getString("productName");
			results = results + "Product Name: " + product_name;
		}
		
		assertEquals(results, stream.toString());
	}
	
	@Test
	public void profitProductLine() throws SQLException{
		final ByteArrayOutputStream stream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(stream));
		Requirement3 db = new Requirement3();
		db.s3();
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver ());
            connect = DriverManager.getConnection( data_base, user, password);
		}
		catch(Exception e){
            System.out.println(e);
		}
		String query = "SELECT products.productLine, SUM(orderdetails.quantityOrdered*(orderdetails.priceEach-products.buyPrice)) AS 'Profit'  FROM orderdetails INNER JOIN products ON orderdetails.productCode=products.productCode GROUP BY products.productLine;";
		Statement statement = connect.createStatement();
		ResultSet resultSet = statement.executeQuery(query);
		String results = "";
		while(resultSet.next()) {
			String product_line = resultSet.getString("productLine");
			double profit = resultSet.getDouble("Profit");
			results = results + "Product Line: " + product_line + "\t" + "Profit: " + profit + "\n";
		}
		assertEquals(results, stream.toString());
	}

}
