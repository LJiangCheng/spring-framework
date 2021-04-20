package com.ljc.learning.ioc.events.listeners;

import com.ljc.learning.ioc.bean.User;
import com.ljc.learning.ioc.events.event.DemoEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class DemoListener implements ApplicationListener<DemoEvent> {

	@Async
    public void onApplicationEvent(DemoEvent event) {
        User source = (User) event.getSource();
		System.out.println("事件：" + source);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
