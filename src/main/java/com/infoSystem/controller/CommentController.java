package com.infoSystem.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.infoSystem.model.CommentModel;
import com.infoSystem.service.CommentService;
import com.infoSystem.service.IssueService;

@Controller
@SessionAttributes({ "userId", "registrationNumber" })
@RequestMapping("/")
public class CommentController {

	@Autowired
	CommentService commentService;

	@Autowired
	IssueService issueService;

	@ResponseBody
	@PostMapping("comment/{issueId}")
	public String validateUser(@PathVariable int issueId, @Valid @RequestBody String comment,
			@SessionAttribute("userId") String userId) {
		CommentModel commentModel = new CommentModel();
		commentModel.setCommentText(comment);
		commentModel.setCreatedBy(Integer.parseInt(userId));
		commentModel.setIssueId(issueId);
		int response = commentService.postComment(commentModel);
		if (response > 0) {
			return "{\"msg\":\"success\"}";
		} else {
			return "{\"msg\":\"failed\"}";
		}
	}

}
