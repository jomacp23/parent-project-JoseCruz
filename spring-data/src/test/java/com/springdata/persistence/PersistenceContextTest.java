package com.springdata.persistence;

import com.springdata.repository.BookRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * Created by jose.m.cruz.perez on 08/02/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PersistenceJPAConfig.class)
public class PersistenceContextTest {

    @Autowired
    protected BookRepository bookRepository;

    @Test
    public void instanceInjectedTest() {
        Assert.assertNotNull(bookRepository);
    }

}
