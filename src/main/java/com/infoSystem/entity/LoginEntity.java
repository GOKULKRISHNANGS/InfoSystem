package com.infoSystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblogin", schema = "dbo")
public class LoginEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "login_id")
	private int loginId;

	@Column(name = "user_registration_number")
	private String userRegistrationNumber;

	@Column(name = "user_password")
	private String userPassword;

	public int getLoginId() {
		return loginId;
	}

	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}

	public String getUserRegistrationNumber() {
		return userRegistrationNumber;
	}

	public void setUserRegistrationNumber(String userRegistrationNumber) {
		this.userRegistrationNumber = userRegistrationNumber;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

}
