package com.mrghz.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloundLogAsyncAspect {

	@Before("com.mrghz.aopdemo.aspect.AopDeclarations.forDaoPackageNoGetterSetter()")
	public void loggingToCloudAsync() {
		System.out.println("\n=====>>> Logging to Clound in async fashion");
	}
}
