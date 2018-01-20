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

import com.infoSystem.model.IssueModel;
import com.infoSystem.service.IssueService;
import com.infoSystem.service.LimitService;

@Controller
@SessionAttributes({"userId", "registrationNumber"})
@RequestMapping("/")
public class IssueController {

	@Autowired
	IssueService issueService;

	@Autowired
	LimitService limitService;

	@GetMapping("get_issues")
	public ModelAndView viewIssues(@SessionAttribute("userId") String userId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("isLimited", limitService.getLimit(userId));
		mav.addObject("issues", issueService.getAllIssues());
		mav.setViewName("issuePage");
		return mav;
	}

	@GetMapping("new_issue")
	public ModelAndView createIssues() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("issues", new IssueModel());
		mav.setViewName("postIssue");
		return mav;
	}

	@PostMapping("post_issue")
	public ModelAndView postIssue(@ModelAttribute IssueModel issueModel, @SessionAttribute("userId") String userId) {
		ModelAndView mav = new ModelAndView();
		issueModel.setCreatedBy(Integer.parseInt(userId));
		int response = issueService.postIssue(issueModel);
		if (response > 0) {
			mav.addObject("postSuccess", true);
			mav.addObject("issues", new IssueModel());
			mav.setViewName("postIssue");
		} else {
			mav.addObject("issues", new IssueModel());
			mav.setViewName("postIssue");
		}
		return mav;
	}

}
