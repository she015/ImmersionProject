package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.Transaction;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Integer>{
		List<Transaction> findByUserAccountId(Integer userId);
}
