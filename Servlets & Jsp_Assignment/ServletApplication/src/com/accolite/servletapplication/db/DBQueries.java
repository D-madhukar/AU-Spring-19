/**
 * 
 */
package com.accolite.servletapplication.db;

/**
 * @author Madhukar
 *
 */
public class DBQueries {
	public static final String USERS_TABLE_CREATE_QUERY="CREATE TABLE IF NOT EXISTS users(username varchar(100)"
														+ ",password varchar(20),nickname varchar(50),"
														+ "	city varchar(50))";
	public static final String USER_AUTHENTICATION_QUERY="SELECT username,password,nickname,city FROM users where username=? and password=?";
	public static final String INSERT_USER_QUERY="INSERT INTO users values(?,?,?,?)";
	public static final String UPDATE_USER_QUERY="UPDATE users SET password=?,nickname=? where username=?";
	public static final String GET_USER_QUERY="SELECT password,nickname,city from users  where username=?";
	public static final String DELETE_USERS_TABLE_QUERY="DELETE from users";
}
