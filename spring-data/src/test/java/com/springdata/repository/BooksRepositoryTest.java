package com.springdata.repository;

import com.datamodel.dao.entities.Book;
import com.springdata.persistence.PersistenceContextTest;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by jose.m.cruz.perez on 08/02/2017.
 */
public class BooksRepositoryTest extends PersistenceContextTest {

    @Test
    public void count(){
        long numberBooks = bookRepository.count();
        System.out.println("Number of books: " + numberBooks);
        Assert.assertTrue(numberBooks >= 0);
    }

    @Test
    public void findAllBooks(){
        List<Book> books = bookRepository.findAll();
        for (Book book : books) {
            if (book.getBooksOutOnLoan().isEmpty()) {
                System.out.println("Books Out On Loan Empty");
            }
            System.out.println(book.toString());
        }
        Assert.assertFalse(books.isEmpty());
    }

    @Test
    public void findByTitle(){
        String titleExpected = "Java";
        List<Book> books = bookRepository.findByTitle(titleExpected);
        String titleActual = books.get(0).getTitle();
        System.out.println("The book obtained is: " + titleActual);
        Assert.assertTrue(titleActual.contains(titleExpected));
    }
}
