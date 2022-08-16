package com.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserAccount {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String userName;
	private String firstName;
	private String lastName;
	private Integer contactNo;
	private Long totalBal;
	
	public Long getTotalBal() {
		return totalBal;
	}
	public void setTotalBal(Long totalBal) {
		this.totalBal = totalBal;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Integer getContactNo() {
		return contactNo;
	}
	public void setContactNo(Integer contactNo) {
		this.contactNo = contactNo;
	}
	
	

}
