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
import com.demo.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String logPage() {
		return "login";
	}
	
	@PostMapping("/validate")
	public String validateUser(HttpSession session, @RequestParam("userName") String userName,
			@RequestParam("password") String password, @ModelAttribute("user") User user,
			Model model) {
	     User oauthUser = userService.findByUserNameAndPassword(user.getUserName(), user.getPassword());
	  
	     System.out.print(oauthUser);
	     
	     if(Objects.nonNull(oauthUser))
	     {
	    	 session.setAttribute("user", user);
	     }else {
			model.addAttribute("message", "Invalid username or password");
			
			return "login";
		}
		return "redirect:/useraccount";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
	    session.invalidate();
	    return "redirect:/";
	} 
}
