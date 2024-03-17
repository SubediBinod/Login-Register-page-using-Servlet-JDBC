package com.loginpage;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


@SuppressWarnings("serial")
public class Controllers extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String  Name= request.getParameter("username");
		String pass= request.getParameter("password");
		boolean flag=false;
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		try {
			 flag=ValidateLogin.Validate(Name,pass);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(flag) {
			response.sendRedirect("https://www.youtube.com/watch?v=dQw4w9WgXcQ&ab_channel=RickAstley");
			
			
		}
		else {
			pw.println("<h1>Who are you ?? what you are doing here????");
			pw.println("You wanna Register yourself???");
			pw.println("goback and register yourself and come</h1>");
			pw.println("<form action='index.html'");
        	pw.println("<input type='submit' value='goback_to_register'");
        	pw.println("</form>");
		}
	}

}
