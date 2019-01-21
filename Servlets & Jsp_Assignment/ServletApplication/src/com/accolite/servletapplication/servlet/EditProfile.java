package com.accolite.servletapplication.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.accolite.servletapplication.db.DatabaseManager;
import com.accolite.servletapplication.log.ServletApplicationLogger;
import com.accolite.servletapplication.model.User;

/**
 * Servlet implementation class EditProfile
 */
@WebServlet("/EditProfile")
public class EditProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public EditProfile() {
        super();    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("index.jsp");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		if(session!=null) {
			User user=(User)(session.getAttribute("user"));		
			String userName=user.getUserName();
			String password=request.getParameter("password");
			String nickName=request.getParameter("nickname");
			DatabaseManager databaseManager=(DatabaseManager)getServletContext().getAttribute("databaseManager");
			int rowCount=databaseManager.updateUser(userName, password, nickName);
			User updatedUser=databaseManager.getUser(userName);
			session.setAttribute("user", updatedUser);
			if(rowCount==1) {
				ServletApplicationLogger.log(ServletApplicationLogger.TYPE_DATABASE,userName+" Data is updated in users table");
				session.setAttribute("message", "Your profile is updated");
				response.sendRedirect("profile.jsp");
			}
		}
		else
			response.sendRedirect("index.jsp");
	}

}
