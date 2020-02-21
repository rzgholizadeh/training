package com.mrghz.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mrghz.aopdemo.dao.AccountDAO;
import com.mrghz.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {

		// read spring configuration java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				DemoConfig.class);

		// get the beans from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

		// call the business method of account DAO
		Account theAccount = new Account();
		theAccount.setName("Jimmy");
		theAccount.setLevel("Platinum");
		theAccountDAO.addAccount(theAccount, false);
		theAccountDAO.doSomeWork();

		// call the business method of membership DAO
		theMembershipDAO.addMembership();
		theMembershipDAO.doSomeJob();

		// close the context
		context.close();

	}

}
