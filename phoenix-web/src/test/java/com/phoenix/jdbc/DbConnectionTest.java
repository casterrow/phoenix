package com.phoenix.jdbc;

import org.junit.Test;

public class DbConnectionTest {

	private String url = "jdbc:mysql://nurator:3306/phoenix?characterEncoding=UTF-8";
	private String user = "root";
	private String password = "nurator#2015";
	
	@Test
	public void testConn() throws Exception {
		DbConnection connection = new DbConnection();
		connection.connect(url, user, password);
	}
}
