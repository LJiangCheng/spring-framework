package com.ljc.learning.aop;

import com.ljc.learning.aop.bean.spec.Performance;
import com.ljc.learning.aop.config.AopConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class InitMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);

		Performance performance = context.getBean(Performance.class);
		performance.perform();

		context.close();

	}

}
