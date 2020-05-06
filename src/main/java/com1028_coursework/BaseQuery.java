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
			double price_each = resultSet.getDouble("priceEach");
			int order_number = resultSet.getInt("orderNumber");
			System.out.println(order_number + "\t" + price_each);
		}
		return "";
				
	}
	
	protected String selectProductNotSold() throws SQLException{
		String query = "select * from products where quantityInStock > 0";
		Statement statement = connect.createStatement();
		ResultSet resultSet = statement.executeQuery(query);
	}
}
