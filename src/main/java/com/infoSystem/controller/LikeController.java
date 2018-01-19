package com.infoSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.infoSystem.model.LikeModel;
import com.infoSystem.service.IssueService;
import com.infoSystem.service.LikeService;

@Controller
@SessionAttributes("userId")
@RequestMapping("/")
public class LikeController {

	@Autowired
	LikeService likeService;

	@Autowired
	IssueService issueService;

	@PostMapping("vote/{issueId}")
	public ModelAndView validateUser(@PathVariable int issueId, @SessionAttribute("userId") String userId) {
		ModelAndView mav = new ModelAndView();
		System.out.println("Issue Id : "+issueId);
		LikeModel likeModel = new LikeModel();
		likeModel.setIssueId(issueId);
		likeModel.setCreatedBy(Integer.parseInt(userId));
		likeService.voteIssue(likeModel);
		mav.addObject("issues", issueService.getAllIssues());
		mav.setViewName("issuePage");
		return mav;
	}

}
