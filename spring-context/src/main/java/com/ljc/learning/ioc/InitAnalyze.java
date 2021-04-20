package com.ljc.learning.ioc;

import com.ljc.learning.ioc.bean.User;
import com.ljc.learning.ioc.config.IocConfig;
import com.ljc.learning.ioc.events.event.DemoEvent;
import com.ljc.learning.ioc.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class InitAnalyze {

	public static void main(String[] args) {
		//初始化容器
		AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext(IocConfig.class);
		//发布事件(同步还是异步取决于是否配置了线程池，默认同步，使用异步需要在配置类上加@EnableAsync注解开启Spring的异步能力)
		long t1 = System.currentTimeMillis();
		applicationContext.publishEvent(new DemoEvent(new User("StartEvent", 22)));
		long t2 = System.currentTimeMillis();
		System.out.println("事件耗时：" + (t2 - t1) / 1000 + "秒");
		//获取Bean
		UserService userService = (UserService) applicationContext.getBean("userService");
		//使用Bean
		userService.toSay();
		//上面使用了线程池，需要手动关闭掉，否则程序不会终止
		// TODO
	}

}
