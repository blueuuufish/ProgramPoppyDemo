package com.programpoppy.listener;

import com.programpoppy.event.MyTestEvent;
import org.springframework.context.ApplicationListener;

public class MyNoAnnotationListener implements ApplicationListener<MyTestEvent> {
    @Override
    public void onApplicationEvent(MyTestEvent event) {
        System.out.println("非注解监听器：" + event.getMsg());
    }
}
