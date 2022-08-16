package com.demo.service;

import com.demo.model.User;

public interface UserService {
	
	User findByUserNameAndPassword(String userName, String password);
	void save(User newUser);
}
