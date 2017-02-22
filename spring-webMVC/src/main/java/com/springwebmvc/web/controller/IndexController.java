package com.springwebmvc.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	private static Logger LOGGER = LoggerFactory.getLogger(IndexController.class);
	
	private String indexPage = "index";
	
	@GetMapping	
	@RequestMapping(value = {"/"})
	public String indexHome(ModelMap model) {
		LOGGER.info("Hello world");
		return indexPage;
	}
	
	
	
	
	
	
	
	

}
