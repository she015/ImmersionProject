package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.UserAccount;

@Repository
public interface UserAccountRepo extends JpaRepository<UserAccount, Integer>{

	List<UserAccount> findByUserName(String userName);

}
