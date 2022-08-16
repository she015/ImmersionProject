package com.demo.service;

import java.util.List;
import com.demo.model.UserAccount;

public interface UserAccountService {

	List<UserAccount> findByUserName(String userName);
	void saveUserAccount(UserAccount userAccount);

}
