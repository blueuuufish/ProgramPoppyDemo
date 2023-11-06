package com.programpoppy;

import com.programpoppy.entity.EventDataDTO;
import com.programpoppy.event.MyEvent;
import com.programpoppy.event.MyListenerOne;
import com.programpoppy.event.RechargeChangeEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class EventListenerApplication {
    public static void main(String[] args) {
        // 先获取 SpringApplication
        SpringApplication springApplication = new SpringApplication(EventListenerApplication.class);
        // 添加（注册）监听器
        springApplication.addListeners(new MyListenerOne());
        // 启动 Springboot 项目
        ApplicationContext applicationContext = springApplication.run(args);
        // 测试
        //test(applicationContext);
        applicationContext.publishEvent(new RechargeChangeEvent("有人充值了", 10086));
    }

    private static void test(ApplicationContext applicationContext) {
        // 在 Springboot 启动后就马上发布时间
        // 事件
        MyEvent myEven = new MyEvent("hu~~~wu~~~", new EventDataDTO());
        // 发布事件
        applicationContext.publishEvent(myEven);
    }
}



