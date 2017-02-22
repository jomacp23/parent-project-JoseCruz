package com.springwebmvc.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.datamodel.dao.entities.Book;
import com.springservice.service.BookService;

@Controller
public class BuscarController {
	
	private static Logger LOGGER = LoggerFactory.getLogger(BuscarController.class);
	
	private String buscarPage = "crud/buscar";
	
	@Autowired
	private BookService bookService;

	@GetMapping	
	@RequestMapping(value = {"/buscar"})
	public String buscar(ModelMap model) {
		LOGGER.info("Buscra libro --------------------------------------------------");
		
		List<Book> books = bookService.findAll();
		
		model.addAttribute("books", books);
		model.addAttribute("book", new Book());
		
		return buscarPage;
	}
	
	@PostMapping
	@RequestMapping(value = {"/buscarPorTitulo"})
	public String buscarPorTitulo(@ModelAttribute Book book, ModelMap model) {
		LOGGER.info("Buscra libro por titulo  --------------------------------------");
		
		List<Book> books = bookService.findByTitle(book.getTitle());
		model.addAttribute("books", books);
		
		return buscarPage;
	}

}
