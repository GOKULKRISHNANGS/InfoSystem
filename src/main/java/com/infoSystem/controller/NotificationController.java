package com.infoSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.infoSystem.model.NotificationModel;
import com.infoSystem.service.NotificationService;

@Controller
@SessionAttributes("userId")
@RequestMapping("/")
public class NotificationController {

	@Autowired
	NotificationService notificationService;

	@GetMapping("get_notifications")
	public ModelAndView viewLoginPage() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("notifications", notificationService.getAllNotifications());
		mav.setViewName("notificationsPage");
		return mav;
	}

	@GetMapping("new_notification")
	public ModelAndView createNotification() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("notifications", new NotificationModel());
		mav.setViewName("postNotificationPage");
		return mav;
	}

	@PostMapping("post_notification")
	public ModelAndView postNotification(@ModelAttribute NotificationModel notificationModel,
			@SessionAttribute("userId") String userId) {
		ModelAndView mav = new ModelAndView();
		notificationModel.setCreatedBy(Integer.parseInt(userId));
		notificationService.createNotification(notificationModel);
		mav.addObject("notifications", notificationService.getAllNotifications());
		mav.setViewName("notificationsPage");
		return mav;
	}

	@GetMapping("post_notification")
	public ModelAndView newNotification() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("notifications", new NotificationModel());
		mav.setViewName("postNotificationPage");
		return mav;
	}

}
