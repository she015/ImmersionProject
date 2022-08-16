package com.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Integer userAccountId; //sample for accountno
	private Integer toUserAccountId; // sample for whom to send
	private Long transferAmount;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserAccountId() {
		return userAccountId;
	}
	public void setUserAccountId(Integer userAccountId) {
		this.userAccountId = userAccountId;
	}
	public Integer getToUserAccountId() {
		return toUserAccountId;
	}
	public void setToUserAccountId(Integer toUserAccountId) {
		this.toUserAccountId = toUserAccountId;
	}
	public Long getTransferAmount() {
		return transferAmount;
	}
	public void setTransferAmount(Long transferAmount) {
		this.transferAmount = transferAmount;
	}
	
}
