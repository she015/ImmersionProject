package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.User;
import com.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public User findByUserNameAndPassword(String userName, String password) {
		return userRepo.findByUserNameAndPassword(userName, password);
	}

	@Override
	public void save(User newUser) {
		userRepo.save(newUser);
		
	}
	
}
