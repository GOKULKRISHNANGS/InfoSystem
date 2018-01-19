package com.infoSystem.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.infoSystem.model.LoginModel;
import com.infoSystem.model.UserModel;
import com.infoSystem.service.LoginService;
import com.infoSystem.service.NotificationService;
import com.infoSystem.service.UserService;

@Controller
@SessionAttributes("userId")
@RequestMapping("/")
public class LoginController {

	@Autowired
	LoginService loginService;

	@Autowired
	NotificationService notificationService;

	@Autowired
	UserService userService;

	@GetMapping("login")
	public ModelAndView viewLoginPage() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("credentials", new LoginModel());
		mav.setViewName("loginPage");
		return mav;
	}

	@PostMapping("get_notifications")
	public ModelAndView validateUser(@ModelAttribute LoginModel loginModel, HttpServletResponse httpServletResponse) {
		ModelAndView mav = new ModelAndView();
		String response = loginService.validateUser(loginModel);
		if (response != "INVALID") {
			UserModel userModel = userService.getUser(loginModel.getUserRegistrationNumber());
			if (userModel.getRole().toLowerCase().equals("director")) {
				mav.addObject("isDirector", true);
			}
			mav.addObject("userId", response);
			mav.addObject("notifications", notificationService.getAllNotifications());
			mav.setViewName("notificationsPage");
			return mav;
		} else {
			return new ModelAndView("redirect:" + "/login_error");
		}
	}

	@GetMapping("login_error")
	public ModelAndView viewLoginPage(@ModelAttribute LoginModel loginModel) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("loginError", true);
		mav.addObject("credentials", new LoginModel());
		mav.setViewName("loginPage");
		return mav;
	}

}
