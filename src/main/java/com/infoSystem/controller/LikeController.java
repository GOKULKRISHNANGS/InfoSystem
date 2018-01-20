package com.infoSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.infoSystem.model.LikeModel;
import com.infoSystem.service.IssueService;
import com.infoSystem.service.LikeService;

@Controller
@SessionAttributes({ "userId", "registrationNumber" })
@RequestMapping("/")
public class LikeController {

	@Autowired
	LikeService likeService;

	@Autowired
	IssueService issueService;

	@ResponseBody
	@PostMapping("vote/{issueId}")
	public String validateUser(@PathVariable int issueId, @SessionAttribute("userId") String userId) {
		LikeModel likeModel = new LikeModel();
		likeModel.setIssueId(issueId);
		likeModel.setCreatedBy(Integer.parseInt(userId));
		int response = likeService.voteIssue(likeModel);
		if (response > 0) {
			return "{\"msg\":\"success\"}";
		} else {
			return "{\"msg\":\"failed\"}";
		}

	}

}
