package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HeadersDemo
 */
//@WebServlet("/HeadersDemo")
public class HeadersDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HeadersDemo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Enumeration<String> headers=request.getHeaderNames();

		out.println("<table><tr><th>name</th><th>value</th>");
		while(headers.hasMoreElements()) {
			String name=headers.nextElement();
			out.println("<tr><td>"+name+"</td><td><b>"+request.getHeader(name)+"</b></td></tr>");
		}
		out.println("</table>");
		
	}

}
