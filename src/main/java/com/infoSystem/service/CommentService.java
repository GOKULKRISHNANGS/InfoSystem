package com.infoSystem.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infoSystem.dao.CommentDao;
import com.infoSystem.dao.IssueDao;
import com.infoSystem.entity.CommentEntity;
import com.infoSystem.model.CommentModel;

@Service
public class CommentService {

	@Autowired
	CommentDao commentDao;

	@Autowired
	IssueDao issueDao;

	public int postComment(CommentModel commentModel) {
		CommentEntity commentEntity = new CommentEntity();
		commentEntity.setIssueId(commentModel.getIssueId());
		commentEntity.setCreatedBy(commentModel.getCreatedBy());
		commentEntity.setCommentText(commentModel.getCommentText());
		commentEntity.setCreatedTimestamp(new Date());
		int response = commentDao.postComment(commentEntity);
		return response;
	}

	public List<CommentModel> getComments(int issueId) {
		List<CommentEntity> commentEntityList = commentDao.getComments(issueId);
		List<CommentModel> commentList = new ArrayList<CommentModel>();
		for (CommentEntity commentEntity : commentEntityList) {
			CommentModel commentModel = new CommentModel();
			commentModel.setCommentId(commentEntity.getCommentId());
			commentModel.setCommentText(commentEntity.getCommentText());
			commentModel.setCreatedBy(commentEntity.getCreatedBy());
			commentModel.setCreatedTimeStamp(commentEntity.getCreatedTimestamp());
			commentModel.setIssueId(commentEntity.getIssueId());
			commentModel.setCommentedBy(issueDao.getName(commentEntity.getCreatedBy()));
			commentList.add(commentModel);
		}
		return commentList;
	}

}
