package com.capgemini.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.capgemini.exceptions.InsufficientInitialBalanceException;
import com.capgemini.model.Account;
import com.capgemini.repository.AccountRepositoryImpl;
import com.capgemini.service.AccountService;
import com.capgemini.service.AccountServiceImpl;

public class AccountTest {

	@Mock
	AccountRepositoryImpl accountRepository;
	
	AccountService accountService;
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		accountService= new AccountServiceImpl(accountRepository);
	}
	@Test(expected= com.capgemini.exceptions.InsufficientInitialBalanceException.class)
	public void insufficientBalance() throws InsufficientInitialBalanceException{
			accountService.createAccount(12344555, 200);
			//System.out.println(account.getAccountNumber());
		
	}
	@Test
	public void validAccount() throws InsufficientInitialBalanceException{
		Account account=new Account();
		account.setAccountNumber(123456);
		account.setAmount(1000);
		Mockito.when(accountRepository.save(account)).thenReturn(true);
	assertEquals(account, accountService.createAccount(123456,1000));
		
		
	}

}
