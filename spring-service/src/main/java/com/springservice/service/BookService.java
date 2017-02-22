package com.springservice.service;

import com.datamodel.dao.entities.Book;

import java.util.List;

/**
 * Created by jose.m.cruz.perez on 14/02/2017.
 */
public interface BookService {

    List<Book> findByTitle(String title);
    
    List<Book> findAll();
    
    Book AddBook(Book book);

}
