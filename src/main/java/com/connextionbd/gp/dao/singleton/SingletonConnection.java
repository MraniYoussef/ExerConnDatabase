package com.connextionbd.gp.dao.singleton;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingletonConnection {
	private static Connection connection;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/exreconproduits","root","aaaaaa");
		}catch(Exception e) {
			e.printStackTrace();
	    }
  }
	public static Connection getConnection() {
		return connection;
	}

}
