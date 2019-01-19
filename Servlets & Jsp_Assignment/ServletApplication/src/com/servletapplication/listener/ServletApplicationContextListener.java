/**
 * 
 */
package com.servletapplication.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.servletapplication.db.DatabaseInitializer;
import com.servletapplication.db.DatabaseManager;
import com.servletapplication.log.ServletApplicationLogger;

/**
 * @author Madhukar
 *
 */
public class ServletApplicationContextListener implements ServletContextListener {
	public void contextInitialized(ServletContextEvent servletContextEvent ) {
		ServletContext servletContext=servletContextEvent.getServletContext();
		String logFilePath=servletContext.getInitParameter("logfilepath");
		ServletApplicationLogger log=new ServletApplicationLogger(logFilePath);
		
			
		ServletApplicationLogger.log(ServletApplicationLogger.TYPE_SERVER, "ServletApplicationLogger is loaded");
		
		String driver=servletContext.getInitParameter("driver");
		String dbUrl=servletContext.getInitParameter("url");
		String userName=servletContext.getInitParameter("username");
		String password=servletContext.getInitParameter("password");
		String dbName=servletContext.getInitParameter("dbname");
		DatabaseManager databaseManager=new DatabaseManager(driver,dbUrl,dbName,userName,password);
		servletContext.setAttribute("databaseManager", databaseManager);
		ServletApplicationLogger.log(ServletApplicationLogger.TYPE_DATABASE,"DataBase Connection is established");
		
		DatabaseInitializer di=new DatabaseInitializer(databaseManager);
		di.createTables();
		di.insertDefaultRow();
	}
	public void contextDestroyed(ServletContextEvent servletContextEvent ) {
		ServletApplicationLogger.log(ServletApplicationLogger.TYPE_SERVER,"Application is closed");
		ServletContext servletContext=servletContextEvent.getServletContext();
		DatabaseManager databaseManager=(DatabaseManager)servletContext.getAttribute("databaseManager");
		databaseManager.deleteUsersData();
	}
}
