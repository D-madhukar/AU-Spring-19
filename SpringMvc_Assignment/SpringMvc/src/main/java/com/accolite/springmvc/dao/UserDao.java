package com.accolite.springmvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.accolite.springmvc.indto.LoginUserDto;
import com.accolite.springmvc.model.User;

@Repository
public class UserDao {

	public static final String INSERT_QUERY="INSERT INTO user(username,password,age,email) values(?,?,?,?)";
	public static final String USER_VALIDATE_QUERY="SELECT username,password,age,email FROM user WHERE username=? and password=?";
	public static final String SELECT_ALL_QUERY="SELECT username,password,age,email FROM user"; 
	public static final String UPDATE_USER_QUERY="UPDATE user set age=?,email=? where username=?";
	Connection connection;
	String driver;
	String url;
	String userName;
	String password;
	public UserDao() {
		
	}
	public UserDao(String driver,String url,String userName,String password){
		this.driver=driver;
		this.url=url;
		this.userName=userName;
		this.password=password;
		init();
	}
	public void init() {
		try {
			Class.forName(this.driver);
			connection=DriverManager.getConnection(this.url,this.userName,this.password);
		}
		catch(Exception e) {e.printStackTrace();}
	}
	public boolean register(User user) {
		try {
			PreparedStatement ps=connection.prepareStatement(INSERT_QUERY);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassword());
			ps.setInt(3, user.getAge());
			ps.setString(4, user.getEmail());
			int noRows=ps.executeUpdate();
			if(noRows==1)
				return true;
		}
		catch(Exception e) {e.printStackTrace();}
		return false;
	}
	public User validateUser(LoginUserDto loginUserDto) {
		
		try {
			PreparedStatement ps=connection.prepareStatement(USER_VALIDATE_QUERY);
			ps.setString(1, loginUserDto.getUserName());
			ps.setString(2, loginUserDto.getPassword());
			ResultSet rs=ps.executeQuery();
			User user=null;
			if(rs.next()) {
				user=new User();
				user.setUserName(rs.getString(1));
				user.setPassword(rs.getString(2));
				user.setAge(Integer.parseInt(rs.getString(3)));
				user.setEmail(rs.getString(4));
			}
			return user;
		}
		catch(Exception e) {}
		return null;
	}
	public List<User> getAll(){
		List<User> users=new ArrayList<User>();
		try {
			Statement st=connection.createStatement();
			ResultSet rs=st.executeQuery(SELECT_ALL_QUERY);
			while(rs.next()) {
				User user=new User();
				user.setUserName(rs.getString(1));
				user.setPassword(rs.getString(2));
				user.setAge(rs.getInt(3));
				user.setEmail(rs.getString(4));
				users.add(user);
			}
			
		}
		catch(Exception e) {e.printStackTrace();}
		return users;
	}
	public void update(User user) {
		try {
			PreparedStatement ps=connection.prepareStatement(UPDATE_USER_QUERY);
			ps.setInt(1, user.getAge());
			ps.setString(2, user.getEmail());
			ps.setString(3,user.getUserName());
			int i=ps.executeUpdate();
			if(i==1)
				System.out.println("updated");
			else
				System.out.println("no user");
		}
		catch(Exception e){e.printStackTrace();}
	}
	
	
	
	
}
