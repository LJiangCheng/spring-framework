package com.ljc.learning.ioc.events.event;

import com.ljc.learning.ioc.bean.User;
import org.springframework.context.ApplicationEvent;

public class DemoEvent extends ApplicationEvent {
	private static final long serialVersionUID = 7099057708183571937L;
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public DemoEvent(User source) {
        super(source);
    }
}
