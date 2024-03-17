package com.loginpage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ValidateRegistration extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String name = req.getParameter("name");
        String pass = req.getParameter("password");
        String country = req.getParameter("country");
        String phone = req.getParameter("phone");
        PrintWriter pw= res.getWriter();
        int affected_row=0;
        try (Connection c = DbConnection.getConnection()) {
            String sql = "INSERT INTO user (Name, PassWord, Country, Phone) VALUES (?, ?, ?, ?)";
            try (PreparedStatement ps = c.prepareStatement(sql)) {
                ps.setString(1, name);
                ps.setString(2, pass);
                ps.setString(3, country);
                ps.setString(4, phone);
                affected_row=ps.executeUpdate();
            }
            if(affected_row>0) {
            	pw.println("<h1>You have successfully Registered goback and login</h1>");
            	pw.println("<form action='index.html'");
            	pw.println("<input type='submit' value='goback'");
            	pw.println("</form>");
            }
            

        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
}
    
