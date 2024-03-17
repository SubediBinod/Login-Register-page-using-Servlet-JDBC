package com.loginpage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ValidateLogin {
public static boolean Validate(String name,String pass) throws ClassNotFoundException, SQLException {
	Connection c= DbConnection.getConnection();
	PreparedStatement pst=c.prepareStatement("Select PassWord from user where Name= ? ");
	pst.setString(1, name);
	ResultSet r= pst.executeQuery();
	
	 if (r.next()) { // Move the cursor to the first row
         String passFromDb = r.getString(1);
         if (pass.equals(passFromDb)) {
             return true;
         }
     }
	return false;
	
	
}
}
