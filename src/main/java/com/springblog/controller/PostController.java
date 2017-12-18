package com.springblog.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import com.springblog.controller.api.ApiPostController;
import com.springblog.model.Post;

@Controller
@RequestMapping(value = "post", method = GET)
public class PostController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(PostController.class);
	
	@Autowired
	private ApiPostController apiController;
	
	@RequestMapping("add")
	public String reqAdd(@ModelAttribute Post post){
		return "post/form";
		
	}
	
	@RequestMapping("{id}/modify")
	public String reqModify(Model model, @PathVariable("id") Long id){
		model.addAttribute("post", apiController.get(id));
		return "post/form";
	}
	
	@RequestMapping("{id}")
	public String reqPost(Model model, @PathVariable("id") Long id){
		model.addAttribute("post", apiController.get(id));
		return "post/post";
	}
	
	@RequestMapping("list")
	public String reqList(Model model, @RequestParam(value = "search", required = false)
					String search){
		model.addAttribute("search", search);
		return "post/list";
	}
	
	@RequestMapping("list-index.section")
	public String reqListSection(Model model, 
			@PageableDefault(sort ={"id"}, direction = Sort.Direction.DESC, size = 3) 
	Pageable pageable){
		model.addAttribute("posts", apiController.list(pageable));
		return "post/list-index.section";
	}
	
	@RequestMapping("list.section")
	public String reqListSection(Model model, 
			@PageableDefault(sort ={"id"}, direction = Sort.Direction.DESC, size = 5) 
	Pageable pageable, @RequestParam(value = "search", 
	required = false, defaultValue = "") String search){
		model.addAttribute("search", search);
		model.addAttribute("posts", apiController.list(pageable, search));
		return "post/list.section";
	}

}
