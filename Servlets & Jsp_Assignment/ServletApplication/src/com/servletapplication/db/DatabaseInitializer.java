/**
 * 
 */
package com.servletapplication.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import com.servletapplication.log.ServletApplicationLogger;

/**
 * @author Madhukar
 *
 */
public class DatabaseInitializer {
	DatabaseManager databaseManager;
	public DatabaseInitializer (DatabaseManager databaseManager){
		this.databaseManager=databaseManager;
	}
	public void createTables() {
		try {
			Connection connection=this.databaseManager.getConnection();
			Statement st=connection.createStatement();
			st.executeUpdate(DBQueries.USERS_TABLE_CREATE_QUERY);
			ServletApplicationLogger.log(ServletApplicationLogger.TYPE_DATABASE,"users table is created");
		}
		catch(Exception e) {e.printStackTrace();}
	}
	public void insertDefaultRow() {
		try {
			Connection connection=this.databaseManager.getConnection();
			PreparedStatement ps=connection.prepareStatement(DBQueries.INSERT_USER_QUERY);
			ps.setString(1,"D-madhukar");
			ps.setString(2,"madhukar");
			ps.setString(3,"madhu");
			ps.setString(4,"Bheerpur");
			ps.executeUpdate();
			ServletApplicationLogger.log(ServletApplicationLogger.TYPE_DATABASE, "Default user is created in users table with username="
										+"D-madhukar & password=madhukar");
		}
		catch(Exception e) {e.printStackTrace();}
	}

}
