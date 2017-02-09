package com.springdata.repository;

import com.datamodel.dao.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by jose.m.cruz.perez on 07/02/2017.
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findByName(String name);

}
