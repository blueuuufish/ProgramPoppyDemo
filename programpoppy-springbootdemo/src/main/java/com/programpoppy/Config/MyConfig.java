package com.programpoppy.Config;

import com.programpoppy.event.RechargeChangeEvent;
import jakarta.annotation.Resource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class MyConfig {
    @Resource
    private ApplicationContext context;

    //@EventListener(classes = {ApplicationEvent.class})
    //public void listener(ApplicationEvent event) {
    //    System.out.println("注解形式 ---> 创建初始event： "+event.getClass().getName());
    //    // 注意:这个方法会导致循环!!!
    //    // 因为你的监听器正在监听所有的 ApplicationEvent 事件，
    //    // 这意味着它也会监听到自己发布的 RechargeChangeEvent（因为 RechargeChangeEvent 也是 ApplicationEvent 的子类）。
    //    context.publishEvent(new RechargeChangeEvent("发布事件了", 10086));
    //}
}
