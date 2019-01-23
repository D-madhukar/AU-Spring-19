package com.accolite.springmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.accolite.springmvc.service.UserService;

@Configuration
@ComponentScan("com.accolite.springmvc.service")
public class ServiceBeanConfig {

	@Bean
	public UserService userService() {
		return new UserService();
	}
}
