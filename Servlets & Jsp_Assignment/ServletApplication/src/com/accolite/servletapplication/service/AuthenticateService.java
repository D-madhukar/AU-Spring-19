/**
 * 
 */
package com.accolite.servletapplication.service;

import javax.servlet.ServletContext;

import com.accolite.servletapplication.db.DBQueries;
import com.accolite.servletapplication.db.DatabaseManager;
import com.accolite.servletapplication.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author Madhukar
 *
 */
public class AuthenticateService {
	ServletContext servletContext;
	public AuthenticateService(ServletContext servletContext) {
		this.servletContext=servletContext;
	}
	public User authenticateUser(String userName,String password) {
		try {
			Connection cn=((DatabaseManager)servletContext.getAttribute("databaseManager")).getConnection();
			PreparedStatement ps=cn.prepareStatement(DBQueries.USER_AUTHENTICATION_QUERY);	
			ps.setString(1, userName);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			User user=null;
			if(rs.next()) {
				user=new User();
				user.setUserName(rs.getString(1));
				user.setPassword(rs.getString(2));
				user.setNickName(rs.getString(3));
				user.setCity(rs.getString(4));
			}
			return user;
		}
		catch(Exception e) {e.printStackTrace();}
		return null;
	} 
}
