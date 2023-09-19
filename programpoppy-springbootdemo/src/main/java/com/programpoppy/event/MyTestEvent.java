package com.programpoppy.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.context.ApplicationEvent;

import java.io.Serial;
import java.time.Clock;

@Getter
public class MyTestEvent extends ApplicationEvent {
    @Serial
    private static final long serialVersionUID = 1L;

    private String msg ;

    public MyTestEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }
}
