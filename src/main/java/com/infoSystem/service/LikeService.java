package com.infoSystem.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infoSystem.dao.LikeDao;
import com.infoSystem.entity.LikeEntity;
import com.infoSystem.model.LikeModel;

@Service
public class LikeService {
	
	@Autowired
	LikeDao likeDao;
	
	public int voteIssue(LikeModel likeModel){
		LikeEntity likeEntity = new LikeEntity();
		likeEntity.setCreatedBy(likeModel.getCreatedBy());
		likeEntity.setCreatedTimestamp(new Date());
		likeEntity.setIssueId(likeModel.getIssueId());
		int response = likeDao.voteIssue(likeEntity);
		return response;
	}
	
	public int getTotalVotes(int issueId){
		int reponse = likeDao.getTotalVotes(issueId);
		return reponse;
	}

}
