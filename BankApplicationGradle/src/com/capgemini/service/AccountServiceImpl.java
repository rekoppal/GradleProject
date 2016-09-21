package com.capgemini.service;

import com.capgemini.exceptions.InsufficientInitialBalanceException;
import com.capgemini.exceptions.InvalidAccountNumberException;
import com.capgemini.model.Account;
import com.capgemini.repository.AccountRepositoryImpl;

public class AccountServiceImpl implements AccountService{
	AccountRepositoryImpl accountRepository;
	public AccountServiceImpl(AccountRepositoryImpl accountRepository){
		this.accountRepository= accountRepository;
	}
	
	@Override
	public Account createAccount(int accountNumber, int amount) throws InsufficientInitialBalanceException {
		Account account=new Account(accountNumber, amount);
		if(amount<500){
			throw new InsufficientInitialBalanceException();
		}
		
		if(accountRepository.save(account)){
			return account;
		}
		return null;
		
	}

	@Override
	public int showBalance(int accountNUmber) throws InvalidAccountNumberException {
		// TODO Auto-generated method stub
		return 0;
	}

}
