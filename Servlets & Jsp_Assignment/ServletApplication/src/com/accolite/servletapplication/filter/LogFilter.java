package com.accolite.servletapplication.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.accolite.servletapplication.log.ServletApplicationLogger;

@WebFilter("/LogFilter")
public class LogFilter implements Filter {
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String addr=request.getRemoteAddr();
		String hostName=request.getRemoteHost();
		ServletApplicationLogger.log(ServletApplicationLogger.TYPE_REQUEST, "login request from  "+hostName);	
		chain.doFilter(request, response);
	}

}
