package com.infoSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.infoSystem.model.LoginModel;
import com.infoSystem.service.LoginService;
import com.infoSystem.service.NotificationService;

@Controller
@SessionAttributes("userId")
@RequestMapping("/")
public class LoginController {

	@Autowired
	LoginService loginService;

	@Autowired
	NotificationService notificationService;

	@GetMapping("login")
	public ModelAndView viewLoginPage() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("credentials", new LoginModel());
		mav.setViewName("loginPage");
		return mav;
	}

	@PostMapping("validate_user")
	public ModelAndView validateUser(@ModelAttribute LoginModel loginModel) {
		ModelAndView mav = new ModelAndView();
		String response = loginService.validateUser(loginModel);
		if (response != "INVALID") {
			System.out.println("Success");
			mav.addObject("userId", response);
			mav.addObject("notifications", notificationService.getAllNotifications());
			mav.setViewName("notificationsPage");
		} else {
			System.out.println("Not available");
			mav.addObject("credentials", new LoginModel());
			mav.setViewName("loginPage");
		}
		return mav;
	}

	@GetMapping("validate_user")
	public ModelAndView viewLoginPage(@ModelAttribute LoginModel loginModel) {
		ModelAndView mav = new ModelAndView();
		System.out.println("Not available");
		mav.addObject("credentials", new LoginModel());
		mav.setViewName("loginPage");
		return mav;
	}

}
