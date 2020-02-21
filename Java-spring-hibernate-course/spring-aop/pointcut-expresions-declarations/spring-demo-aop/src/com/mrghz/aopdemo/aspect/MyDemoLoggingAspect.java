package com.mrghz.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	// @Before advice
	// @Before("execution(public void
	// com.mrghz.aopdemo.dao.AccountDAO.addAccount())")
	// @Before("execution(* add*())")
	// @Before("execution(* add*(com.mrghz.aopdemo.Account))")
	// @Before("execution(* add*(com.mrghz.aopdemo.Account, ..))")
	// @Before("execution(* add*(..))")
	// @Before("execution(* com.mrghz.aopdemo.dao.*.*(..))")

	// pointcut: include package
	@Pointcut("execution(* com.mrghz.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {
	}

	// pointcut for getter methods
	@Pointcut("execution(* com.mrghz.aopdemo.dao.*.get*(..))")
	private void getter() {
	}

	// pointcut for setter methods
	@Pointcut("execution(* com.mrghz.aopdemo.dao.*.set*(..))")
	private void setter() {
	}

	// pointcut: include package ... exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNoGetterSetter() {
	}

	// using the declared pointcut
	@Before("forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n=====>>> Executing @Before advice on addAccount()");
	}

	@Before("forDaoPackageNoGetterSetter()")
	public void performApiAnalytics() {
		System.out.println("\n=====>>> Performing API analytics");
	}

}
