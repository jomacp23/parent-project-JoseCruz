package com.springwebmvc.web.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
public class DarDeAltaController {
	
	private static Logger LOGGER = LoggerFactory.getLogger(DarDeAltaController.class);
	
	private String darDeAltaPage = "crud/darDeAlta";
	
	@Autowired
	private BookService bookService;
	
	@GetMapping	
	@RequestMapping(value = {"/darDeAlta"})
	public String darDeAlta(ModelMap model) {
		LOGGER.info("Dar de alta un libro");
		model.addAttribute("book", new Book());
		return darDeAltaPage;
	}
	
	@PostMapping	
	@RequestMapping(value = {"/darDeAltaLibro"})
	public String darDeAltaLibro(String isbn, String title, String dateOfPublication, ModelMap model) {
		LOGGER.info("Dar de alta un libro ----------------------------------------->");
		
		boolean transaccionExitosa;
		
		Date dop = formatearFecha(dateOfPublication);
		
		Book book = new Book();
		book.setIsbn(isbn);
		book.setTitle(title);
		book.setDateOfPublication(dop);
		
		LOGGER.info("El libro a dar de alta es: " + book.toString());
		
		try {
			bookService.AddBook(book);
			transaccionExitosa = true;
		} catch (Exception e) {
			LOGGER.error("Error al dar de alta un libro: ", e.getMessage());
			transaccionExitosa = false;
		}
		
		model.addAttribute("book", new Book());
		model.addAttribute("bookAdded", transaccionExitosa);
		
		return darDeAltaPage;
	}
	
	private Date formatearFecha(String fecha) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dop = null;
		try {
			dop = sdf.parse(fecha);
		} catch (ParseException e) {
			LOGGER.error(e.getMessage());
		}
		return dop;
	}

}
