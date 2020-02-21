package com.mrghz.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.mrghz.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

	// add a new advice for @After on the findAccounts method
	@After("execution(* com.mrghz.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFindAccountAdvice(JoinPoint theJoinPoint) {

		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n=====>>> Executing @After (finally) on method: " + method);

	}

	@AfterThrowing(pointcut = "execution(* com.mrghz.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "theExc")
	public void afterThrowingFindAccountAdvice(JoinPoint theJoinPoint, Throwable theExc) {

		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n=====>>> Executing @AfterThrowing on method: " + method);

		// log the exception
		System.out.println("\n=====>>> The exception is: " + theExc);

	}

	@AfterReturning(pointcut = "execution(* com.mrghz.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n=====>>> Executing @AfterReturning on method: " + method);

		// print out the result of the method call
		System.out.println("\n=====>>> result is: " + result);

		// modify the returning value
		convertAccountNamesToUpperCase(result);

	}

	private void convertAccountNamesToUpperCase(List<Account> result) {
		for (Account tempAccount : result) {
			tempAccount.setName(tempAccount.getName().toUpperCase());
		}
	}

	@Before("com.mrghz.aopdemo.aspect.AopDeclarations.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJointPoint) {
		System.out.println("\n=====>>> Executing @Before advice on addAccount()");

		// display the method signature
		MethodSignature methodSig = (MethodSignature) theJointPoint.getSignature();
		System.out.println("Method: " + methodSig);

		// display method arguments

		// get args
		Object[] args = theJointPoint.getArgs();

		// loop through args
		for (Object tempArg : args) {
			System.out.println(tempArg);
		}

	}

}
