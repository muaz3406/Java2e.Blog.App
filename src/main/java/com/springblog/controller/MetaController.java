package com.springblog.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.springblog.model.BlogMeta;
import com.springblog.model.BlogMetaRepository;

@Controller
@RequestMapping("meta")
public class MetaController extends BaseController {
	
	private static final Logger logger = LoggerFactory.getLogger(MetaController.class);
	
	@Autowired
	private BlogMeta meta;
	
	@Autowired
	private BlogMetaRepository metaRepository;
	
	@RequestMapping(value="init", method = RequestMethod.GET)
	public String reqInit(Model model){
		model.addAttribute("meta", meta);
		return "meta/init";
	}
	
	@RequestMapping(value="init", method = RequestMethod.POST)
	public String reqInit(BlogMeta meta){
		List<BlogMeta> metas = metaRepository.findAll();
		if (metas.size() == 0) {
			BlogMeta blogMeta = metaRepository.saveAndFlush(meta);
			this.meta.set(blogMeta);
		}else{
			BlogMeta blogMeta = metas.get(metas.size() - 1);
			blogMeta.set(meta);
			metaRepository.saveAndFlush(blogMeta);
			this.meta.set(blogMeta);
		}
		return "redirect:/";
	}

}
