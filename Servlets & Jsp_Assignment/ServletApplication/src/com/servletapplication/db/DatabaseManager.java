/**
 * 
 */
package com.servletapplication.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.servletapplication.model.User;



/**
 * @author Madhukar
 *
 */
public class DatabaseManager {
		String driver;
		String dbUrl;
		String dbName;
		String userName;
		String password;
		Connection connection;
		public DatabaseManager(String driver,String dbUrl,String dbName,String userName,String password){
			this.driver=driver;
			this.dbUrl=dbUrl;
			this.dbName=dbName;
			this.userName=userName;
			this.password=password;
			establishConnection();
		}
		public void establishConnection() {
			try {
				Class.forName(this.driver);
				this.connection=DriverManager.getConnection(this.dbUrl+"/"+this.dbName, this.userName, this.password);
			}
			catch(Exception e) {e.printStackTrace();}
		}
		public Connection getConnection() {
			return this.connection;
		}
		public int updateUser(String userName,String password,String nickName) {
			try {
				PreparedStatement ps=connection.prepareStatement(DBQueries.UPDATE_USER_QUERY);
				ps.setString(1, password);
				ps.setString(2, nickName);
				ps.setString(3, userName);
				int n=ps.executeUpdate();
				return n;
			}
			catch(Exception e) {e.printStackTrace();}
			return 0;
		}
		public User getUser(String userName) {
			try {
				User user=new User();
				PreparedStatement ps=connection.prepareStatement(DBQueries.GET_USER_QUERY);
				ps.setString(1, userName);
				ResultSet rs=ps.executeQuery();
				if(rs.next()) {
					user.setUserName(userName);
					user.setPassword(rs.getString(1));
					user.setNickName(rs.getString(2));
					user.setCity(rs.getString(3));
					return user;
				}
				
			}
			catch(Exception e) {e.printStackTrace();}
			return null;
		}
		public void deleteUsersData() {
			try {
				Statement st=connection.createStatement();
				st.executeUpdate(DBQueries.DELETE_USERS_TABLE_QUERY);
			}
			catch(Exception e) {e.printStackTrace();}
		}
	
}
