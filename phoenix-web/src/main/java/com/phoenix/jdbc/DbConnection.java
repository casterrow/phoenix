package com.phoenix.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	
	
	public DbConnection() throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
	}
	
	
	public void connect(String url, String user, String password) throws SQLException {
		Connection conn = DriverManager.getConnection(url, user, password);
		
		
		
		System.out.println(conn);
	}
}
