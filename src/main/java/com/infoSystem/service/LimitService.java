package com.infoSystem.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infoSystem.dao.LimitDao;
import com.infoSystem.dao.UserDao;
import com.infoSystem.entity.LimitEntity;
import com.infoSystem.entity.UserEntity;
import com.infoSystem.model.LimitModel;

@Service
public class LimitService {

	@Autowired
	LimitDao limitDao;

	@Autowired
	UserDao userDao;

	public int putLimit(LimitModel limitModel) {
		LimitEntity limitEntity = new LimitEntity();
		limitEntity.setCreatedTimestamp(new Date());
		limitEntity.setUserId(limitModel.getUserId());
		limitEntity.setCreatedBy(limitModel.getCreatedBy());
		int response = limitDao.insertLimit(limitEntity);
		return response;
	}

	public Boolean getLimit(int userId) {
		Boolean response = limitDao.checkLimitations(userId);
		return response;
	}

	public Boolean checkIssues(String userId) {
		int count = limitDao.noOfIssues(Integer.parseInt(userId));
		if (count >= 2) {
			return false;
		} else {
			return true;
		}
	}

	public List<UserEntity> getStudentsList() {
		List<UserEntity> userList = userDao.getStudents();
		return userList;
	}

}
