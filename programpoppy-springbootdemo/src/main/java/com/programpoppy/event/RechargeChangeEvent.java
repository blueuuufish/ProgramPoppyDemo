package com.programpoppy.event;

import com.programpoppy.entity.User;
import org.springframework.context.ApplicationEvent;

public class RechargeChangeEvent extends ApplicationEvent {
    private Integer giftActivityId;


    public RechargeChangeEvent(Object source, Integer giftActivityId) {
        super(source);
        this.giftActivityId = giftActivityId;
    }

    public Integer getGiftActivityId() {
        return giftActivityId;
    }

    public void setGiftActivityId(Integer giftActivityId) {
        this.giftActivityId = giftActivityId;
    }

}
