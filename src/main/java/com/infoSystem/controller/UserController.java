package com.infoSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.infoSystem.service.UserService;

@Controller
@SessionAttributes("userId")
@RequestMapping("user")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("users")
	public void getAllArticles() {
		userService.getUser();
	}

}
