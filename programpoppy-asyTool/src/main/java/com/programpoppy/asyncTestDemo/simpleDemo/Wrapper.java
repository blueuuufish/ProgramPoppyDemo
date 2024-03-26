package com.programpoppy.asyncTestDemo.simpleDemo;

import lombok.Data;

@Data
public class Wrapper {
    private String param;
    private Worker worker;
    private Listener listener;
    public void addListener(Listener listener) {
        this.listener = listener;
    }
}
