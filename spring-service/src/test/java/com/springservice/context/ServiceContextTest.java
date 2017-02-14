package com.springservice.context;

import com.springservice.service.BookService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by jose.m.cruz.perez on 14/02/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ServiceContext.class)
public class ServiceContextTest {

    @Autowired
    protected BookService bookService;

    @Test
    public void instanceInjectedTest() {
        Assert.assertNotNull(bookService);
    }

}
