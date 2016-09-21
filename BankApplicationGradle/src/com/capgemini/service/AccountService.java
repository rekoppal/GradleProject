package com.capgemini.service;

import com.capgemini.exceptions.InsufficientInitialBalanceException;
import com.capgemini.exceptions.InvalidAccountNumberException;
import com.capgemini.model.Account;

public interface AccountService {
	public Account createAccount(int accountNumber,int amount) throws InsufficientInitialBalanceException;
	public int showBalance(int accountNUmber) throws InvalidAccountNumberException;
}
