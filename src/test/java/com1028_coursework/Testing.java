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
		Main db = new Main();
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
		BaseQuery db = new BaseQuery ("root", "Parsa80");
		db.selectProductNotSold();
		assertEquals("1985 Toyota Supra" + "\t", stream.toString());
	}
	
	@Test
	public void profitProductLine() throws SQLException{
		final ByteArrayOutputStream stream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(stream));
		BaseQuery db = new BaseQuery("root", "Parsa80");
		db.selectProfitEachLine();
		assertEquals("Classic Cars	14059337.71	25631556.38	11572218.67	\r\n" + 
				"Motorcycles	3565714.18	6919282.43	3353568.25	\r\n" + 
				"Planes	3099282.76	5670231.92	2570949.16	\r\n" + 
				"Ships	1239140.43	2342604.92	1103464.49	\r\n" + 
				"Trains	727251.77	1281248.24	553996.47	\r\n" + 
				"Trucks and Buses	2139329.56	3875532.70	1736203.14	\r\n" + 
				"Vintage Cars	5704259.82	10567510.68	4863250.86	", stream.toString());
	}

}
