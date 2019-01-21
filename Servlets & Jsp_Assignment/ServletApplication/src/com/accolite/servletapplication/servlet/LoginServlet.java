package com.accolite.servletapplication.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.accolite.servletapplication.log.ServletApplicationLogger;
import com.accolite.servletapplication.model.User;
import com.accolite.servletapplication.service.AuthenticateService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.getRequestDispatcher("index.jsp").forward(request, response);
		response.sendRedirect("index.jsp");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		if(userName!=null && password!=null) {
			AuthenticateService authenticateService=new AuthenticateService(request.getServletContext());
			User user=authenticateService.authenticateUser(userName, password);
			if(user!=null) {
				HttpSession session=request.getSession();
				session.setAttribute("user", user);
				response.sendRedirect("profile.jsp");
			}
			else{
//				HttpSession session=request.getSession();
//				session.setAttribute("errormessage", "Invalid username or password");
				request.setAttribute("errormessage", "Invalid username or password");
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
		}
		else {
			response.sendRedirect("index.jsp");
		}
	}

}
