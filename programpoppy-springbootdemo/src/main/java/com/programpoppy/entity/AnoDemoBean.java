package com.programpoppy.entity;

import org.springframework.stereotype.Component;

@Component
public class AnoDemoBean {
    private String type = "AnoDemoBean";

    public String getName(String name) {
        return name + "_" + type;
    }
}
