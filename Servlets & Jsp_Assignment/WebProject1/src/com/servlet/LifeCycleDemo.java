package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifeCycleDemo
 */
@WebServlet(
		description = "Life cycle demo", 
		urlPatterns = { "/LifeCycleDemo" }, 
		initParams = { 
				@WebInitParam(name = "connection", value = "oracle.jdbc.driver.OracleDriver")
		})
public class LifeCycleDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String driver;
    public LifeCycleDemo() {
        super();
    }
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		driver=config.getInitParameter("connection");
		System.out.println("in init driver="+driver);
	}
	public void destroy() {
		System.out.println("Destroy method is called");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		out.println("<h1>Init Parameter:"+driver+"</h1>");
		out.println("<h4>"+getServletConfig().getInitParameter("connection")+"</h4>");
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
