package com.infoSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.infoSystem.model.LimitModel;
import com.infoSystem.service.LimitService;
import com.infoSystem.service.UserService;

@Controller
@SessionAttributes({ "userId", "registrationNumber" })
@RequestMapping("/")
public class LimitController {

	@Autowired
	UserService userService;

	@Autowired
	LimitService limitService;

	@PostMapping("limit/{studentId}")
	public ModelAndView limitStudent(@PathVariable int studentId, @SessionAttribute("userId") String userId) {
		ModelAndView mav = new ModelAndView();
		LimitModel limitModel = new LimitModel();
		limitModel.setCreatedBy(Integer.parseInt(userId));
		limitModel.setUserId(studentId);
		limitService.putLimit(limitModel);
		mav.addObject("students", userService.getStudents());
		mav.setViewName("limitPage");
		return mav;
	}

	@GetMapping("limit_issues")
	public ModelAndView getStudentsList(@SessionAttribute("userId") String userId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("students", userService.getStudents());
		mav.setViewName("limitPage");
		return mav;
	}

}
