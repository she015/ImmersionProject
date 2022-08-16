package com.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.demo.model.Transaction;
import com.demo.service.TransactionService;

@Controller
public class TransactionController {

	@Autowired
	private TransactionService tranService;
	
	Transaction transaction = new Transaction();
	
		//new transaction
		@GetMapping("/newtransaction/{userAccountId}")
		public String newTransaction(@PathVariable("userAccountId") String userId, Model model) {
			transaction.setUserAccountId(Integer.parseInt(userId));
			model.addAttribute("transaction", transaction);
			return "new_transaction";
		}
		//new deposit
		@GetMapping("/newdeposit/{userAccountId}")
		public String newDeposit(@PathVariable("userAccountId") String userId, Model model) {
			transaction.setUserAccountId(Integer.parseInt(userId));
			model.addAttribute("transaction", transaction);
			return "new_deposit";
		}
		
		//save transaction
		@PostMapping("/transfer")
		public String saveTransfer(@ModelAttribute("transaction") Transaction transaction) {
			tranService.saveTransfer(transaction);
			return "redirect:/useraccount";
		}
		
		//save deposit
		@PostMapping("/deposit")
		public String saveDeposit(@ModelAttribute("transaction") Transaction transaction) {
			tranService.saveDeposit(transaction);
			return "redirect:/useraccount";
		}
		
		@GetMapping("/transactionhistory/{userAccountId}")
		public String viewTransactionHistory(@PathVariable("userAccountId") String userId, Model model) {
			model.addAttribute("listTransaction", tranService.getTransactionBy(userId));
			return "transaction";
		}
}
