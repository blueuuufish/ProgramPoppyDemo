package com.programpoppy.listener;

import com.programpoppy.event.MyEvent;
import com.programpoppy.event.MyListenerOne;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MyListenerTwo {

    @EventListener
    public void doListener(MyEvent myEvent) {
        System.out.println("线程：" + Thread.currentThread().getName() + "]]" + "监听器 => " + myEvent);
    }
}
