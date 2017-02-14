package com.springservice.context;

import com.springdata.persistence.PersistenceJPAConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by jose.m.cruz.perez on 14/02/2017.
 */
@Configuration
@Import(PersistenceJPAConfig.class)
@ComponentScan(basePackages = "com.springservice.service")
public class ServiceContext {
}
