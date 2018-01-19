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

	public UserModel getUser(String registrationNumber) {
		UserModel userModel = new UserModel();
		UserEntity userEntity = userDao.getUser(registrationNumber);
		userModel.setRole(userEntity.getRoleTxt());
		userModel.setBranchName(userEntity.getBranchName());
		userModel.setFirstName(userEntity.getUserFirstName());
		userModel.setLastName(userEntity.getUserLastName());
		return userModel;
	}

}
