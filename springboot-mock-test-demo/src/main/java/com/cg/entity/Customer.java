package com.cg.entity;

public class Customer 
{
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
