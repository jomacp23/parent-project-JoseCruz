package com.springservice.service;

import com.datamodel.dao.entities.Book;
import com.springservice.context.ServiceContextTest;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by jose.m.cruz.perez on 14/02/2017.
 */
public class BookServiceTest extends ServiceContextTest {

    @Test
    public void findByTitleTest() {
        final String titleExpected = "Java";
        List<Book> bookList = bookService.findByTitle(titleExpected);

        for (Book book: bookList) {
            String titleActual = book.getTitle();
            System.out.println(titleActual);
            Assert.assertTrue(titleActual.contains(titleExpected));
        }

    }

}
