package com.infoSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infoSystem.dao.LoginDao;
import com.infoSystem.entity.LoginEntity;
import com.infoSystem.model.LoginModel;

@Service
public class LoginService {
	
	@Autowired
	LoginDao loginDao;
	
	public String validateUser(LoginModel loginModel) {
		LoginEntity loginEntity = new LoginEntity();
		loginEntity.setUserRegistrationNumber(loginModel.getUserRegistrationNumber());
		loginEntity.setUserPassword(loginModel.getUserPassword());
		String response = loginDao.checkUser(loginEntity);
		return response;
	}

}
