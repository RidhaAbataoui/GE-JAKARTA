package com.educationalsystem.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static Connection con;
	public static void getConnection() throws ClassNotFoundException {
		try {
			String dbName ="";
			String password = "";
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbName,"root",password);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
