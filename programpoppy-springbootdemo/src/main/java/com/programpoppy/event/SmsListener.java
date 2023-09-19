package com.programpoppy.event;

import org.springframework.context.ApplicationListener;

public class SmsListener implements ApplicationListener<RechargeChangeEvent> {
    @Override
    public void onApplicationEvent(RechargeChangeEvent event) {

    }
}
