package com.loginpage;
import java.sql.*;
public class DbConnection {
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","root");
		
		return c;
		
	}
	
	

}
