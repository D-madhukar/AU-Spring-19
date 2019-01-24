package com.accolite.springmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.accolite.springmvc.dao.UserDao;

@Configuration
@ComponentScan("com.accolite.springmvc.dao")
@PropertySource("classpath:properties/db.properties")
public class DaoBeanConfig {
	
	@Bean
	
	public UserDao userdao() {
		return new UserDao(env.getProperty("db.driver"),env.getProperty("db.url"),env.getProperty("db.userName"),env.getProperty("db.password"));
	}
}
