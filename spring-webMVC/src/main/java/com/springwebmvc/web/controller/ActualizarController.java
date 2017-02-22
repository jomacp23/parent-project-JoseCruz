package com.springwebmvc.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ActualizarController {
	
	private static Logger LOGGER = LoggerFactory.getLogger(ActualizarController.class);
	
	private String actualizarPage = "crud/actualizar";
	
	@GetMapping	
	@RequestMapping(value = {"/actualizar"})
	public String actualizar(ModelMap model) {
		LOGGER.info("Actualizar informacion de libro");
		return actualizarPage;
	}

}
