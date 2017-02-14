package com.springdata.repository;

import com.datamodel.dao.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by jose.m.cruz.perez on 07/02/2017.
 */
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByFirstName(String firstName);

}
