package com.bookmyshow.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		PrintWriter out = resp.getWriter();
		
		String myname = req.getParameter("name");
		String myusername = req.getParameter("username");
		String myemail = req.getParameter("email");
		String mypassword = req.getParameter("password");
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmyshow","root","Niraj@199911");
            
            PreparedStatement ps = con.prepareStatement("INSERT INTO users (name, username, email, password) VALUES (?, ?, ?, ?)");
            ps.setString(1, myname);
            ps.setString(2, myusername);
            ps.setString(3, myemail);
            ps.setString(4, mypassword);
            
            int count = ps.executeUpdate();
            if (count > 0)
            {
            	resp.setContentType("text/html");
            	out.print("<h3 style='color:green'> user registered succesfullly</h3>");
            	RequestDispatcher rd = req.getRequestDispatcher("/register.jsp");
            	rd.include(req, resp);
            }
            else
            {
            	resp.setContentType("text/html");
            	out.print("<h3 style='color:red'> user not registered due to some error</h3>");
            	RequestDispatcher rd = req.getRequestDispatcher("/register.jsp");
            	rd.include(req, resp);
            }
            
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
			resp.setContentType("text/html");
        	out.print("<h3 style='color:red'> user not registered due to some error:"+e.getMessage()+"</h3>");
        	RequestDispatcher rd = req.getRequestDispatcher("/register.jsp");
        	rd.include(req, resp);
		}
	}
}

