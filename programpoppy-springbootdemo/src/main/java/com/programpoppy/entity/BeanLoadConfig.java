package com.programpoppy.entity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanLoadConfig {
    @Bean
    public ConfigDemoBean configDemoBean() {
        return new ConfigDemoBean();
    }
}
