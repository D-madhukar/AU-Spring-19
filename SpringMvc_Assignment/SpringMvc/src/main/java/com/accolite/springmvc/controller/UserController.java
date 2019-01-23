package com.accolite.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.accolite.springmvc.indto.LoginUserDto;
import com.accolite.springmvc.model.User;
import com.accolite.springmvc.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public ModelAndView registerUser(HttpServletRequest request,HttpServletResponse response) {
		User user=new User();
		user.setUserName(request.getParameter("userName"));
		user.setPassword(request.getParameter("password"));
		user.setAge(Integer.parseInt(request.getParameter("age")));
		user.setEmail(request.getParameter("email"));
		boolean isInserted=userService.register(user);
		if(isInserted)
			return new ModelAndView("index.jsp","message","Successfully register ....Login Now");
		else
			return new ModelAndView("error.jsp","message","Problem in registration process");
	}
	@RequestMapping(value="/loginprocess",method=RequestMethod.POST)
	public ModelAndView loginUser(HttpServletRequest request,@RequestParam("userName") String userName
			,@RequestParam("password") String password ) {
		LoginUserDto loginUser=new LoginUserDto();
		loginUser.setUserName(userName);
		loginUser.setPassword(password);
		User user=userService.authenticate(loginUser);
		if(user!=null) {
			HttpSession session=request.getSession();
			session.setAttribute("user", user);
			return new ModelAndView("profile.jsp");
		}
		else
			return new ModelAndView("login.jsp","message","Invalid Username or password");
	}
	@RequestMapping(value="/logout",method=RequestMethod.POST)
	public ModelAndView logoutUser(HttpServletRequest request) {
		HttpSession session=request.getSession(false);
		if(session!=null)
			session.invalidate();
		return new ModelAndView("login.jsp","message","logged out successfully");
	}
	
	@RequestMapping(value="/users",method=RequestMethod.GET)
	public ModelAndView getUsers() {
		ModelAndView mv=new ModelAndView("index.jsp");
		List<User> users=new ArrayList<User>();
		users=userService.getAllUsers();
		mv.addObject("users", users);
		return mv;
		
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public ModelAndView updateUser(HttpServletRequest request) {
		User user=new User();
		user.setUserName(request.getParameter("userName"));
		System.out.println(request.getParameter("userName")+" in contoller ");
		user.setAge(Integer.parseInt(request.getParameter("age")));
		user.setEmail(request.getParameter("email"));
		userService.updateUser(user);
		ModelAndView mv=new ModelAndView("index.jsp","message","updated");
		List<User> users=new ArrayList<User>();
		users=userService.getAllUsers();
		mv.addObject("users", users);
		return mv;
		
	}
}
