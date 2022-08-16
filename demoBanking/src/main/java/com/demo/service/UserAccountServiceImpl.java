package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.UserAccount;
import com.demo.repository.UserAccountRepo;

@Service
public class UserAccountServiceImpl implements UserAccountService{

	@Autowired
	private UserAccountRepo userAccountRepo;
	
	@Override
	public List<UserAccount> findByUserName(String userName) {
		return userAccountRepo.findByUserName(userName);
	}

	@Override
	public void saveUserAccount(UserAccount userAccount) {
		this.userAccountRepo.save(userAccount);
	}

}
