package com.infoSystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infoSystem.dao.UserDao;
import com.infoSystem.entity.UserEntity;
import com.infoSystem.model.UserModel;

@Service
public class UserService {

	@Autowired
	UserDao userDao;

	@Autowired
	LimitService limitService;

	public UserModel getUser(String registrationNumber) {
		UserModel userModel = new UserModel();
		UserEntity userEntity = userDao.getUser(registrationNumber);
		userModel.setRole(userEntity.getRoleTxt());
		userModel.setBranchName(userEntity.getBranchName());
		userModel.setFirstName(userEntity.getUserFirstName());
		userModel.setLastName(userEntity.getUserLastName());
		return userModel;
	}

	public List<UserModel> getStudents() {
		List<UserEntity> userEntityList = userDao.getStudents();
		List<UserModel> userModelList = new ArrayList<UserModel>();
		for (UserEntity userEntity : userEntityList) {
			UserModel userModel = new UserModel();
			userModel.setBranchName(userEntity.getBranchName());
			userModel.setFirstName(userEntity.getUserFirstName());
			userModel.setLastName(userEntity.getUserLastName());
			userModel.setRegistrationNumber(userEntity.getUserRegistrationNumber());
			userModel.setUserId(userEntity.getUserId());
			userModel.setEmailId(userEntity.getEmail());
			userModel.setIsLimited(limitService.getLimit(userEntity.getUserId()));
			userModelList.add(userModel);
		}
		return userModelList;
	}

}
