package com.springdata.repository;

import com.datamodel.dao.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by jose.m.cruz.perez on 07/02/2017.
 */
public interface AuthorRepository extends JpaRepository<Author, Long> {

    List<Author> findByLastName(String lastName);
}
