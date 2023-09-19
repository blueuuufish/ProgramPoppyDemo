package com.programpoppy.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MyListenerOne implements ApplicationListener<MyEvent> {
    @Override
    public void onApplicationEvent(MyEvent event) {
        // 当前事件对象携带的数据
        System.out.println(
                "线程：" + Thread.currentThread().getName() + "]]"
                + "监听器 => " + event
        );
    }
}
