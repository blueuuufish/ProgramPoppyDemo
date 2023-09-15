package com.programpoppy.entity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBeanConfiguration {
    @Bean(name = "myBean")
    public MyBean initMyBean() {
        return new MyBean(11, "fk");
    }
}
