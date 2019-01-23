package com.accolite.springmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.accolite.springmvc.dao.UserDao;

@Configuration
@ComponentScan("com.accolite.springmvc.dao")
public class DaoBeanConfig {
	
	@Bean
	
	public UserDao userdao() {
		return new UserDao("com.mysql.jdbc.Driver","jdbc:mysql://localhost:3306/springmvc","root","root");
	}
}
