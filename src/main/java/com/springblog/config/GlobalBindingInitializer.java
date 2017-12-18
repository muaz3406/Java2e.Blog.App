package com.springblog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.springblog.model.BlogMeta;
import com.springblog.util.TagExtender;

@ControllerAdvice
public class GlobalBindingInitializer {
	@Autowired
	private BlogMeta meta;
	
	@Autowired
	private TagExtender tagExtender;
	
	@ModelAttribute("meta")
	public BlogMeta meta(){
		return meta;
	}
	
	@ModelAttribute
	public TagExtender tagExtender(){
		return tagExtender;
	}
	

}
