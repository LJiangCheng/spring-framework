package com.ljc.learning.ioc.config;

import org.jetbrains.annotations.NotNull;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;

/**
 * 启用spring异步机制
 * 同时自定义异步线程池，若不重写会使用Spring默认的线程池
 */
@Configuration
@EnableAsync
public class AsyncConfig implements AsyncConfigurer {

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

	static class MyAsyncExceptionHandler implements AsyncUncaughtExceptionHandler {
		@Override
		public void handleUncaughtException(@NotNull Throwable throwable, @NotNull Method method, Object... objects) {
			for (Object param : objects) {
				System.out.println(throwable.getCause() + method.getName() + param.toString());
			}
		}
	}
}