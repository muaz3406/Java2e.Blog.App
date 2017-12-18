package com.springblog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.springblog.intercreptor.InitIntercreptor;
import com.springblog.intercreptor.UserProfileIntercreptor;

public class WebMvcConfig extends WebMvcConfigurerAdapter {

	@Autowired
	private ConnectionRepository connectionRepository;
	
	@Bean
	public InitIntercreptor initIntercreptor(){
		return new InitIntercreptor();
	}
	
	public void addIntercreptors(InterceptorRegistry registry){
		registry.addInterceptor(new UserProfileIntercreptor(connectionRepository));
		registry.addInterceptor(initIntercreptor());
		super.addInterceptors(registry);
	}
}
