package com.infoSystem.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

	public Boolean getLimit(String userId) {
		String response = limitDao.checkUser(userId);
		if (!response.equals("NOTFOUND")) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			String date = sdf.format(new Date());
			try {
				Date newDate = sdf.parse(response);
				String parsedDate = sdf.format(newDate);
				if (parsedDate.equals(date)) {
					return true;
				} else {
					return false;
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public List<UserEntity> getStudentsList() {
		List<UserEntity> userList = userDao.getStudents();
		return userList;
	}

}
