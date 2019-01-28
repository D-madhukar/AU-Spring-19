package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/PostDemo")
public class PostDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String INSERTQUERY="insert into employee values(?,?,?,?)";
    public PostDemo() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		Employee e=new Employee();
		e.setId(Integer.parseInt(request.getParameter("id")));
		e.setName(request.getParameter("name"));
		e.setSalary(Float.parseFloat(request.getParameter("salary")));
		try {
			MySqlConnector mysqlconn=new MySqlConnector();
			Connection connection=mysqlconn.getConnection();
			PreparedStatement ps=connection.prepareStatement(INSERTQUERY);
			
			ps.setInt(1,e.getId());
			ps.setString(2,e.getName());
			ps.setFloat(3, e.getSalary());
			ps.setInt(4,e.getDept_id());
			if(ps.executeUpdate()==1) {
				System.out.println("1 row inserted");
				out.println("<h6>1 row inserted</h6>");
//				HttpSession session=request.getSession();
//				System.out.println(session.getId());
//				request.getRequestDispatcher("ServletTest").forward(request, response);
//				response.sendRedirect("https://beginnersbook.com/2013/05/servlet-cookies/");
				response.sendRedirect("ServletTest");
			}
			
		}
		catch(Exception exception) {System.out.println(exception);}
	}

}
