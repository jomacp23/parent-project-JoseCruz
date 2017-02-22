package com.springwebmvc.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EliminarController {
	
	private static Logger LOGGER = LoggerFactory.getLogger(EliminarController.class);
	
private String eliminarPage = "crud/eliminar";
	
	@GetMapping	
	@RequestMapping(value = {"/eliminar"})
	public String darDeAlta(ModelMap model) {
		LOGGER.info("Eliminar libro");
		return eliminarPage;
	}
	
}
