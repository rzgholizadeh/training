package com.mrghz.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.mrghz.aopdemo.Account;

@Component
public class AccountDAO {

	private String name;
	private String serviceCode;

	public void addAccount(Account theAccount, boolean flag) {
		System.out.println(getClass() + ": Doing DB work: Adding an account");
	}

	public boolean doSomeWork() {
		System.out.println(getClass() + ": doSomeWork()");
		return true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

}
