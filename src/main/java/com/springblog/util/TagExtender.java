package com.springblog.util;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TagExtender {
	@Autowired
	HttpServletRequest httpServletRequest;
	
	public void stackBody(String sourceName, String bucketName){
		final String body = (String) httpServletRequest.getAttribute(sourceName);
		if (body == null) {
			return;
		}
		httpServletRequest.removeAttribute(sourceName);
		getBody(bucketName).add(body);
	}
	
	public List<String> getBody(String bucketName){
		@SuppressWarnings("unchecked") final ArrayList<String> object = 
				(ArrayList<String>) httpServletRequest.getAttribute(bucketName);
		if (object==null) {
			final List<String> list = new ArrayList<>();
			httpServletRequest.setAttribute(bucketName, list);
			return list;
		}
		return object;	
	}
	
	public List<String> getScriptTags(){
		return getBody("TAG_SCRIPTS_LIST");
	}

}
