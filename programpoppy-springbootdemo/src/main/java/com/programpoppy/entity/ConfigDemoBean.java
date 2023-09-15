package com.programpoppy.entity;

import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Data
public class ConfigDemoBean {
    private String type = "ConfigDemoBean";

    public String getName(String name) {
        return name + "_" + type;
    }
}

