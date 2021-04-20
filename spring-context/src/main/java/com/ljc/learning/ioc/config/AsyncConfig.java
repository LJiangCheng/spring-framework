package com.ljc.learning.ioc.config;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class AsyncConfig implements AsyncConfigurer {
	/**
	 * 自定义异步线程池，若不重写会使用默认的线程池
	 */
	@Override
	public Executor getAsyncExecutor() {
		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
		// 核心线程数
		taskExecutor.setCorePoolSize(2);
		// 最大线程数
		taskExecutor.setMaxPoolSize(10);
		// 队列大小
		taskExecutor.setQueueCapacity(15);
		// 线程名的前缀
		taskExecutor.setThreadNamePrefix("async-thread-");
		taskExecutor.initialize();
		return taskExecutor;
	}

	/**
	 * 捕捉IllegalArgumentException异常
	 */
	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		return new MyAsyncExceptionHandler();
	}

	class MyAsyncExceptionHandler implements AsyncUncaughtExceptionHandler {
		@Override
		public void handleUncaughtException(Throwable throwable, Method method, Object... objects) {
			for (Object param : objects) {
			}
		}
	}
}