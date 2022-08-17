package com.demo.controller;


import java.util.Objects;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.demo.model.Transaction;
import com.demo.model.User;
import com.demo.service.TransactionService;

@Controller
public class TransactionController {

	@Autowired
	private TransactionService tranService;
	
	Transaction transaction = new Transaction();
	
		//new transaction
		@GetMapping("/newtransaction/{userAccountId}")
		public String newTransaction(HttpSession session, @PathVariable("userAccountId") String userId, Model model) {
			User user = (User)session.getAttribute("user");
			if(Objects.isNull(user)) {
				return "redirect:/";
			}
			transaction.setUserAccountId(Integer.parseInt(userId));
			model.addAttribute("transaction", transaction);
			return "new_transaction";
		}
		//new deposit
		@GetMapping("/newdeposit/{userAccountId}")
		public String newDeposit(HttpSession session, @PathVariable("userAccountId") String userId, Model model) {
			User user = (User)session.getAttribute("user");
			if(Objects.isNull(user)) {
				return "redirect:/";
			}
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
		public String viewTransactionHistory(HttpSession session, @PathVariable("userAccountId") String userId, Model model) {
			User user = (User)session.getAttribute("user");
			if(Objects.isNull(user)) {
				return "redirect:/";
			}
			model.addAttribute("listTransaction", tranService.getTransactionBy(userId));
			return "transaction";
		}
}
