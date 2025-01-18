package com.bookmyshow.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		PrintWriter out = resp.getWriter();
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmyshow","root","Niraj@199911");
            
            String myusername = req.getParameter("username");
            String mypassword = req.getParameter("password");
            
            PreparedStatement ps = con.prepareStatement("select username from users where username=? and password=?");
           
            ps.setString(1, myusername);
           
            ps.setString(2, mypassword);
            
            ResultSet rs= ps.executeQuery();
            if (rs.next())
            {
            	//resp.setContentType("text/html");
            	//out.print("<h3 style='color:green'> user registered succesfullly</h3>");
            	RequestDispatcher rd = req.getRequestDispatcher("/movies.jsp");
            	//rd.include(req, resp);
            	rd.forward(req, resp);
            }
            else
            {
            	resp.setContentType("text/html");
            	out.print("<h3 style='color:red'> login failed due to some error</h3>");
            	RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
            	rd.include(req, resp);
            }
            
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
			resp.setContentType("text/html");
        	out.print("<h3 style='color:red'> user can't login due to some error:"+e.getMessage()+"</h3>");
        	RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
        	rd.include(req, resp);
		}
	}

}
