package com.mrghz.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopDeclarations {
	@Pointcut("execution(* com.mrghz.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {
	}

	@Pointcut("execution(* com.mrghz.aopdemo.dao.*.get*(..))")
	public void getter() {
	}

	@Pointcut("execution(* com.mrghz.aopdemo.dao.*.set*(..))")
	public void setter() {
	}

	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterSetter() {
	}

}
