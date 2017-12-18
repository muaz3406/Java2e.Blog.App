package com.springblog.config;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.springblog.model.BlogMeta;
import com.springblog.model.BlogMetaRepository;

public class PostInitRunner implements CommandLineRunner {

	private static Logger logger = LoggerFactory.getLogger(PostInitRunner.class);
	
	@Autowired
	private BlogMetaRepository metaRepository;
	
	@Autowired
	private BlogMeta meta;
	
	@Override
	public void run(String... args) throws Exception {
		List<BlogMeta> all = metaRepository.findAll();
		if (all.size() > 0) {
			BlogMeta meta = all.remove(all.size() - 1);
			metaRepository.delete(all);
			this.meta.set(meta);
		}
		
	}



}
