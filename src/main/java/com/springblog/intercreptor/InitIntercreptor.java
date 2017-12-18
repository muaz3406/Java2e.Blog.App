package com.springblog.intercreptor;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.springblog.model.BlogMeta;

public class InitIntercreptor extends BaseIntercreptor {

	@Autowired
	private BlogMeta meta;
	
	@Autowired
	private ServletContext servletContext;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, 
			Object handler) throws Exception {
		final String contextPath = servletContext.getContextPath();
		final String uri = request.getRequestURI().substring(contextPath.length());
		final String metaInitUri = "/meta/init";
		
		if (!uri.contains(metaInitUri) && !uri.contains("/error")) {
			if (!meta.isInitialized()) {
				redirect(response, contextPath + metaInitUri);
				return false;
			}
		}
		return true;
	}
}
