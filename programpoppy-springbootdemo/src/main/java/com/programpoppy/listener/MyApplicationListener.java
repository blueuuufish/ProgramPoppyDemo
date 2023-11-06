package com.programpoppy.listener;

import com.programpoppy.event.RechargeChangeEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationListener{

    @EventListener(classes = {RechargeChangeEvent.class})
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("需要发送邮件 --> 事件触发："+event.getClass().getName());
    }
}
