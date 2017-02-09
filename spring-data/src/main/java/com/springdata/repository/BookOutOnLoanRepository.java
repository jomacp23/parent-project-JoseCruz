package com.springdata.repository;

import com.datamodel.dao.entities.BookOutOnLoan;
import com.datamodel.dao.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by jose.m.cruz.perez on 07/02/2017.
 */
public interface BookOutOnLoanRepository extends JpaRepository<BookOutOnLoan, Long> {

    List<BookOutOnLoan> findByStudent(Student student);

}
