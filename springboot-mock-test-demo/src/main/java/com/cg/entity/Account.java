package com.cg.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Account 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer accountId;
	private String custName;
	private Double amt;
	
	public Account()
	{
		
	}
	public Account(Integer accountId, String custName, Double amt) {
		super();
		this.accountId = accountId;
		this.custName = custName;
		this.amt = amt;
	}
	public Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public Double getAmt() {
		return amt;
	}
	public void setAmt(Double amt) {
		this.amt = amt;
	}
	public void display()
	{
		System.out.println("Account");
		System.out.println("Account details upto date");
	}
	

}
