package com.ljc.learning.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * 观众
 * 使用@Aspect注解定义为切面
 */
@Aspect
public class AudienceAdvice {

	/**
	 * 定义可复用的切点
	 * 切点表达式：任意返回值 全限定名.方法名(任意参数)
	 */
	@Pointcut("execution(* com.ljc.learning.aop.bean.spec.Performance.perform(..))")
	public void perform() {
	}

	/**
	 * 前置：观众就座
	 */
	@Before("perform()")
	public void takeSeats() {
		System.out.println("观众就座");
	}

	/**
	 * 前置：手机静音
	 */
	@Before("perform()")
	public void silenceCellPhones() {
		System.out.println("手机静音");
	}

	/**
	 * 后置：不管方法成功或失败都会执行
	 */
	@After("perform()")
	public void finish() {
		System.out.println("方法执行完（成功或者失败）");
	}

	/**
	 * 要执行的方法返回之后
	 */
	@AfterReturning("perform()")
	public void applause() {
		System.out.println("方法执行成功!");
	}

	/**
	 * 异常
	 */
	@AfterThrowing("perform()")
	public void demandRefund() {
		System.out.println("方法执行失败，异常！");
	}

	/**
	 * 环绕
	 */
	@Around("perform()")
	public void watchPerform(ProceedingJoinPoint joinPoint) {
		try {
			System.out.println("环绕：前置1");
			System.out.println("环绕：前置2");

			joinPoint.proceed();

			System.out.println("环绕：方法执行成功");
		} catch (Throwable throwable) {
			System.out.println("环绕：异常");
		} finally {
			System.out.println("环绕：finally执行完成");
		}
	}

}
