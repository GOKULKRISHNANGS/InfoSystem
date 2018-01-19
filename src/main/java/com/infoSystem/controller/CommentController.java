package com.infoSystem.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.infoSystem.model.CommentModel;
import com.infoSystem.service.CommentService;
import com.infoSystem.service.IssueService;

@Controller
@SessionAttributes("userId")
@RequestMapping("/")
public class CommentController {

	@Autowired
	CommentService commentService;

	@Autowired
	IssueService issueService;

	@PostMapping("comment/{issueId}")
	public ModelAndView validateUser(@PathVariable int issueId, @Valid @RequestBody String comment,
			@SessionAttribute("userId") String userId) {
		ModelAndView mav = new ModelAndView();
		System.out.println("Comment text : " + comment);
		CommentModel commentModel = new CommentModel();
		commentModel.setCommentText(comment);
		commentModel.setCreatedBy(Integer.parseInt(userId));
		commentModel.setIssueId(issueId);
		commentService.postComment(commentModel);
		mav.addObject("issues", issueService.getAllIssues());
		mav.setViewName("issuePage");
		return mav;
	}

}
