package com.springdata.repository;

import com.datamodel.dao.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by jose.m.cruz.perez on 07/02/2017.
 */
public interface BookRepository extends JpaRepository<Book, String> {

    List<Book> findByTitle(String title);

}
