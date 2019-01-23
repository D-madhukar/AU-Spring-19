package com.accolite.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.accolite.springmvc.dao.UserDao;
import com.accolite.springmvc.indto.LoginUserDto;
import com.accolite.springmvc.model.User;

@Service
public class UserService {
	@Autowired
	@Qualifier("userdao")
	UserDao userDao;
	
	public UserService(){
		
	}
	public boolean register(User user) {
		
		return userDao.register(user);
	}
	public User authenticate(LoginUserDto loginUserDto) {
		return userDao.validateUser(loginUserDto);
	}
	public List<User> getAllUsers(){
		return userDao.getAll();
	}
	public void updateUser(User user) {
		userDao.update(user);
	}
}
