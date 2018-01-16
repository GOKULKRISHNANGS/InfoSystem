package com.infoSystem.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infoSystem.dao.IssueDao;
import com.infoSystem.entity.IssueEntity;
import com.infoSystem.model.IssueModel;

@Service
public class IssueService {

	@Autowired
	IssueDao issueDao;

	public List<IssueModel> getAllIssues() {
		List<IssueModel> issueList = new ArrayList<IssueModel>();
		List<IssueEntity> issueEntityList = issueDao.getIssues();
		for (IssueEntity issueEntity : issueEntityList) {
			IssueModel issueModel = new IssueModel();
			issueModel.setCreatedBy(issueEntity.getCreatedBy());
			issueModel.setIssueId(issueEntity.getIssueId());
			issueModel.setIssueText(issueEntity.getIssueTxt());
			issueModel.setCreatedTimeStamp(issueEntity.getCreatedTimestamp());
			issueModel.setPostedBy(issueDao.getName(issueEntity.getCreatedBy()));
			issueList.add(issueModel);
		}
		return issueList;
	}

	public int postIssue(IssueModel issueModel) {
		IssueEntity issueEntity = new IssueEntity();
		issueEntity.setCreatedBy(issueModel.getCreatedBy());
		issueEntity.setCreatedTimestamp(new Date());
		issueEntity.setIssueTxt(issueModel.getIssueText());
		int response = issueDao.postIssue(issueEntity);
		return response;
	}

}
