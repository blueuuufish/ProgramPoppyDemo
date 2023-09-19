package com.programpoppy.event;

import com.programpoppy.entity.EventDataDTO;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

public class MyEvent extends ApplicationEvent {
    @Getter
    private final EventDataDTO eventDataDTO;

    public MyEvent(Object source, EventDataDTO eventDataDTO) {
        super(source);
        this.eventDataDTO = eventDataDTO;
    }
}
