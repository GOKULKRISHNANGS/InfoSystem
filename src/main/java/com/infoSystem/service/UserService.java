package com.infoSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infoSystem.dao.UserDao;
import com.infoSystem.entity.UserEntity;
import com.infoSystem.model.UserModel;

@Service
public class UserService {

	@Autowired
	UserDao userDao;
	
	public UserModel getUser() {
		UserEntity userEntity = new UserEntity();
		userEntity.setUserFirstName("Gokul");
		userEntity.setUserLastName("kris");
//		userDao.createUser(userEntity);
		userDao.getUser();
		return null;
	}

}
