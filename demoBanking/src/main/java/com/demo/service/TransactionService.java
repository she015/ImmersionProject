package com.demo.service;

import java.util.List;

import com.demo.model.Transaction;

public interface TransactionService {

	List<Transaction> getTransactionBy(String userId);
	boolean saveTransfer(Transaction transaction);
	boolean saveDeposit(Transaction transaction);
}
