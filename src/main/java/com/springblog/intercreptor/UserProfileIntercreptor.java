package com.springblog.intercreptor;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class UserProfileIntercreptor extends HandlerInterceptorAdapter {
	
	private static Logger logger = LoggerFactory.getLogger(UserProfileIntercreptor.class);
	private ConnectionRepository connectionRepository;
	public UserProfileIntercreptor(ConnectionRepository connectionRepository) {
		this.connectionRepository = connectionRepository;
	}	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, 
			Object handler) throws Exception {
		Connection<Facebook> connection;
		
		try {
			connection = connectionRepository.findPrimaryConnection(Facebook.class);
		} catch (Exception e) {
			connection = null;
		}
		if (connection != null) {
			UserProfile profile = connection.fetchUserProfile();
			request.setAttribute("_USER", profile);
			logger.trace("login: "+ profile.getEmail());
		}
		return true;
	}
	
	

}
