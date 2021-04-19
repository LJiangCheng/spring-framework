package com.ljc.learning.events.listeners;

import com.ljc.learning.bean.User;
import com.ljc.learning.events.event.DemoEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class DemoListener implements ApplicationListener<DemoEvent> {

    public void onApplicationEvent(DemoEvent event) {
        User source = (User) event.getSource();
        System.out.println(source);
    }
}
