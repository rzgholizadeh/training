package com.mrghz.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public boolean addMembership() {
		System.out.println(getClass() + ": Doing stuff : Adding a membership account");
		return true;
	}

	public void doSomeJob() {
		System.out.println(getClass() + ": doSomeJob()");
	}

}
