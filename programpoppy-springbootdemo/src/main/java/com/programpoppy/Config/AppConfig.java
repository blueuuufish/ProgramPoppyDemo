package com.programpoppy.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:app-config.properties")
public class AppConfig {

    @Value("${app.name}")
    private String appName;
}
