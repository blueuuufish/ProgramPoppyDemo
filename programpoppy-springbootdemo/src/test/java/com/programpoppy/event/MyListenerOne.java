package com.programpoppy.event;

import com.programpoppy.entity.EventDataDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public class MyListenerOne {
    @Autowired
    ApplicationContext applicationContext;

    @Test
    void contextLoads() {
        MyEvent myEven = new MyEvent("hu~~~wu~~~ 起飞", new EventDataDTO());
        applicationContext.publishEvent(myEven);

    }
}
