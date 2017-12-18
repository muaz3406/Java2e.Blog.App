package com.springblog.controller.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springblog.controller.BaseController;
import com.springblog.model.Post;
import com.springblog.model.PostRepository;
import com.springblog.util.AjaxResult;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
@RequestMapping("api/post")
@ResponseBody
public class ApiPostController extends BaseController{
	private static final Logger logger = LoggerFactory.getLogger(ApiPostController.class);
	
	@Autowired
	private PostRepository postRepository;
	
	public Page<Post> list(Pageable pageable){
		return postRepository.findByTitleOrContent(pageable, "");
	}
	
	@RequestMapping(method = GET)
	public Page<Post> list(@PageableDefault
			(sort = {"id"}, direction = Sort.Direction.DESC, size = 5)Pageable pageable,
			@RequestParam(value= "search", required = false, defaultValue = "") 
	String search){
		return postRepository.findByTitleOrContent(pageable, search);
	}
	
	@RequestMapping(method = POST)
	public AjaxResult add(Post post){
		return AjaxResult.create(postRepository.saveAndFlush(post).getId());
	}
	
	@RequestMapping(value = "{id}", method = GET)
	public Post get(@PathVariable("id") Long id){
		return postRepository.findOne(id);
	}
	
	@RequestMapping(value = "{id}", method = PUT)
	public AjaxResult update(@PathVariable("id") Long id, Post post){
		final Post fetch = postRepository.getOne(id);
		fetch.update(post);
		postRepository.save(fetch);
		postRepository.flush();
		return AjaxResult.create();
	}
	
	@RequestMapping(value = "{id}", method = DELETE)
	public AjaxResult delete(@PathVariable("id") Long id, Post post){
		postRepository.delete(id);
		postRepository.flush();
		return AjaxResult.create();
	}

}
