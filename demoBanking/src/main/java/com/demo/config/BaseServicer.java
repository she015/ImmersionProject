package com.demo.config;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import com.demo.model.User;

@Component
public class BaseServicer {
	
   public User getCurrentUserInfo(HttpSession session){
	   User user = (User)session.getAttribute("user");
	   if(user !=null){
			  System.out.println("Current Session: " + user.getUserName());
	   }
	  return user;
   }


}