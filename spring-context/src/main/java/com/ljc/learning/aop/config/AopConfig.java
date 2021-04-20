package com.ljc.learning.aop.config;

import com.ljc.learning.aop.aspect.AudienceAdvice;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.ljc.learning.aop")
public class AopConfig {

	@Bean
	public AudienceAdvice audience() {
		return new AudienceAdvice();
	}

}
