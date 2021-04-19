package com.ljc.learning;

import com.ljc.learning.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class InitAnalyze {

	public static void main(String[] args) {
		//初始化容器
		AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext("com.ljc.learning");
		//发布事件(同步还是异步取决于是否配置了线程池，默认同步)
		//applicationContext.publishEvent(new DemoEvent(new User("StartEvent", 22)));
		//获取Bean
		UserService userService = (UserService) applicationContext.getBean("userService");
		//使用Bean
		userService.toSay();
	}

}
