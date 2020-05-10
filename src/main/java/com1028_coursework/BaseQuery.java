package com1028_coursework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseQuery {
	protected Connection connect;
	private final String data_base = "jdbc:mysql://localhost:3306/classicmodels";
	
	
	public BaseQuery(String user, String pass){
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver ());
            connect = DriverManager.getConnection( data_base, user, pass);
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
	
	protected String selectPriceAbove100() throws SQLException{
		
		String query = "select * from payments where amount > 100000;";
		Statement statement = connect.createStatement();
		ResultSet resultSet = statement.executeQuery(query);
		while(resultSet.next()) {
			int customer_number = resultSet.getInt("customerNumber");
			String check_number = resultSet.getString("checkNumber");
			String payment_date = resultSet.getString("paymentDate");
			double order_amount = resultSet.getDouble("amount");
			System.out.println(customer_number + "\t" + check_number + "\t" + payment_date + "\t" + order_amount);
		}
		return "";
				
	}
	
	protected String selectProductNotSold() throws SQLException{
		String query = "SELECT P.productName "
				+ "FROM products P "
				+ "WHERE NOT EXISTS "
				+ "(SELECT 1 FROM orderdetails S WHERE S.productcode = P.productcode);";
		Statement statement = connect.createStatement();
		ResultSet resultSet = statement.executeQuery(query);
		while (resultSet.next()) {
			String product_name = resultSet.getString("productName");
			System.out.println(product_name + "\t");
		}
		return "";
		
		
	}
	
	protected String selectProfitEachLine() throws SQLException{
		String query = "SELECT SUM(buyPrice * quantityInStock) AS 'Total Cost', "
				+ "SUM(MSRP * quantityInStock) AS 'Total Revenue', "
				+ "SUM((MSRP * quantityInStock) - (buyPrice * quantityInStock)) AS 'Total Profit' "
				+ "FROM products;";
		Statement statement = connect.createStatement();
		ResultSet resultSet = statement.executeQuery(query);
		while (resultSet.next()) {
			double total_cost = resultSet.getDouble("Total Cost");
			double total_revenue = resultSet.getDouble("Total Revenue");
			double total_profit = resultSet.getDouble("Total profit");
			System.out.println(total_cost + "\t" + total_revenue + "\t" + total_profit + "\t");
		}
		return "";
	}
}
