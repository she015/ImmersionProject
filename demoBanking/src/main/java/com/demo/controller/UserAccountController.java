package com.demo.controller;

import java.util.Objects;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.model.User;
import com.demo.model.UserAccount;
import com.demo.service.UserAccountService;

@Controller
public class UserAccountController {

	@Autowired
	private UserAccountService userAccountService;
	
	String userAName;
	
	//view useraccounts
	@GetMapping("/useraccount")
	public String userInfo(HttpSession session, Model model) {
		User user = (User)session.getAttribute("user");
		model.addAttribute("listUserAccount", userAccountService.findByUserName(user.getUserName()));		
		return "useraccount";
	}

	//add new user
	@GetMapping("/new")
	public String newUserAccount(HttpSession session, Model model) {
		UserAccount userAccount= new UserAccount();
		User user = (User)session.getAttribute("user");
		
		if(Objects.isNull(user)) {
			return "redirect:/";
		}
		userAccount.setUserName(user.getUserName());
		model.addAttribute("useraccount", userAccount);
		return "new_useraccount";
	}
	@RequestMapping("/save")
	public String saveUserAccount(@ModelAttribute("useraccount") UserAccount userAccount) {
		userAccountService.saveUserAccount(userAccount);
		return "redirect:/useraccount";
	}
	
}
