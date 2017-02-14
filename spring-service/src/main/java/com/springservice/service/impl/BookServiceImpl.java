package com.springservice.service.impl;

import com.datamodel.dao.entities.Book;
import com.springdata.repository.BookRepository;
import com.springservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jose.m.cruz.perez on 14/02/2017.
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> findByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

}
