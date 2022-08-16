package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.Transaction;
import com.demo.model.UserAccount;
import com.demo.repository.TransactionRepo;
import com.demo.repository.UserAccountRepo;


@Service
public class TransactionServiceImpl implements TransactionService{

	@Autowired
	private TransactionRepo transRepo;
	
	@Autowired
	private UserAccountRepo userAccountRepo;
	
	@Override
	public List<Transaction> getTransactionBy(String userId) {
		return transRepo.findByUserAccountId(Integer.parseInt(userId));
	}

	@Override
	public boolean saveTransfer(Transaction transaction) {
		Optional<UserAccount> userAccount = userAccountRepo.findById(transaction.getUserAccountId());
		Long newbal = userAccount.get().getTotalBal();
		if(newbal > transaction.getTransferAmount()) {
			Long currentBal = newbal - transaction.getTransferAmount();
			userAccount.get().setTotalBal(currentBal);
			transRepo.save(transaction);
		}else {
			return false;
		}
		return true;
	}
	@Override
	public boolean saveDeposit(Transaction transaction) {
		Optional<UserAccount> userAccount = userAccountRepo.findById(transaction.getUserAccountId());
		Long newbal = userAccount.get().getTotalBal();
			Long currentBal = newbal + transaction.getTransferAmount();
			userAccount.get().setTotalBal(currentBal);
			transRepo.save(transaction);
		return true;
	}

}
