package com.cg;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import com.cg.entity.Account;
import com.cg.exceptions.AccNotFoundException;
import com.cg.exceptions.InsufficientFundException;
import com.cg.repo.AccountRepo;
import com.cg.service.AccountService;

@SpringBootTest
public 
class TransferFundTest 
{
	private Optional<Account> optAcc1,optAcc2,optAcc3;
	@MockitoBean
	private AccountRepo repo;
	@Autowired
	private AccountService accService;
	@BeforeEach
	public void beforeEach()
	{
		Account acc1= new Account(101,"John",5000.0);
		Account acc2= new Account(102,"Sam",7000.0);
		
		optAcc1= Optional.ofNullable(acc1);
		optAcc2= Optional.ofNullable(acc2);
		optAcc3= Optional.empty();
	}
	@Test
	public void testTransferFund()
	{
		Mockito.when(repo.findById(101)).thenReturn(optAcc1);
		Mockito.when(repo.findById(102)).thenReturn(optAcc2);
		Mockito.when(repo.save(Mockito.any(Account.class))).thenReturn(new Account());
		Assertions.assertTrue(accService.transferFund(101, 102, 2000.0));
		Mockito.verify(repo).findById(101);
		Mockito.verify(repo).findById(102);
		Mockito.verify(repo).save(Mockito.any(Account.class));
	}
	@Test
	public void testTransferFund2()
	{
		Mockito.when(repo.findById(101)).thenReturn(optAcc1);
		Mockito.when(repo.findById(103)).thenReturn(optAcc3);
		assertThrows(AccNotFoundException.class,()->accService.transferFund(101, 103, 3000.0));
		Mockito.verify(repo).findById(101);
		Mockito.verify(repo).findById(103);
	}
	@Test
	public void testTransferFund3()
	{
		Mockito.when(repo.findById(101)).thenReturn(optAcc1);
		Mockito.when(repo.findById(102)).thenReturn(optAcc2);
		assertThrows(InsufficientFundException.class,()->accService.transferFund(101, 102, 70000.0));
		Mockito.verify(repo).findById(101);
		Mockito.verify(repo).findById(102);
	}
}
