package com.demo.controller;

import java.util.Objects;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.model.User;
import com.demo.repository.UserRepository;

@Controller
public class RegisterController {
	
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("/register")
	public String registerPage() {
		return "register";
	}

	@PostMapping("/register-user")
	public String validateUser(HttpSession session, @ModelAttribute("user") User user,
			 @ModelAttribute("password2") String password2,
			Model model) {
		if(user.getPassword().equals(password2) && Objects.nonNull(model)) {
			
			userRepo.save(user);
			
	     	System.out.print(user);
		}else {
			model.addAttribute("message", "Please retype password");
			return "/register";
		}
	     
		return "login";
	}
}
