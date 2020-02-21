package com.mrghz.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.mrghz.aopdemo.Account;

@Component
public class AccountDAO {

	private String name;
	private String serviceCode;

	// add a new method: findAccounts()
	public List<Account> findAccounts(boolean tripWire) {

		// simulate and exception
		if (tripWire) {
			throw new RuntimeException("Simulated exception.");
		}

		List<Account> myAccounts = new ArrayList<Account>();

		// create sample accounts
		Account temp1 = new Account("John", "Gold");
		Account temp2 = new Account("Jimmy", "Platinum");
		Account temp3 = new Account("Lebron", "Silver");

		// add accounts to the accounts list
		myAccounts.add(temp1);
		myAccounts.add(temp2);
		myAccounts.add(temp3);

		return myAccounts;
	}

	public void addAccount(Account theAccount, boolean flag) {
		System.out.println(getClass() + ": Doing DB work: Adding an account");
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
