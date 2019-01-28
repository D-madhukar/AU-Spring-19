package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.sql.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JdbcDemo
 */
@WebServlet(
		urlPatterns = { "/JdbcDemo" }, 
		initParams = { 
				@WebInitParam(name = "driver", value = "com.mysql.jdbc.Driver"), 
				@WebInitParam(name = "url", value = "jdbc:mysql://localhost:3306/emp_db"), 
				@WebInitParam(name = "username", value = "root"), 
				@WebInitParam(name = "password", value = "root")
		})
public class JdbcDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection connection=null;
    public JdbcDemo() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init(ServletConfig config) throws ServletException{
    	try {
    		Class.forName(config.getInitParameter("driver"));
    		connection=DriverManager.getConnection(config.getInitParameter("url"),config.getInitParameter("username"),config.getInitParameter("password"));
    	}
    	catch(Exception e) {System.out.println(e);}
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		try{
			Statement s=connection.createStatement();
			ResultSet rs =s.executeQuery("select * from employee");
			out.println("<table><tr><th>id</th><th>name</th><th>salary</th></tr>");
			while(rs.next()) {
				out.println("<tr>");
				out.println("<td>"+rs.getString("id")+"</td>");
				out.println("<td>"+rs.getString("name")+"</td>");
				out.println("<td>"+rs.getString("salary")+"</td>");
				out.println("</tr>");
			}
			out.println("</table>");
			connection.close();
		}
		catch(Exception e) {System.out.println(e);}
	}

}
