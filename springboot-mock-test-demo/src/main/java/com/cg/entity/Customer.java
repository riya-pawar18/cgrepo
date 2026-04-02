package com.cg.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer phoneNo;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(Integer phoneNo) {
		this.phoneNo = phoneNo;
	}

	public void display()
	{
		System.out.println("Display method");
	}


}
