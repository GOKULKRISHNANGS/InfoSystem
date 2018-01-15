package com.infoSystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbluser", schema = "dbo")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private int userId;

	@Column(name = "user_registration_number")
	private String userRegistrationNumber;

	@Column(name = "user_first_name")
	private String userFirstName;

	@Column(name = "user_last_name")
	private String userLastName;

	@Column(name = "role_txt")
	private String roleTxt;

	@Column(name = "branch_name")
	private String branchName;

	@Column(name = "email")
	private String email;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserRegistrationNumber() {
		return userRegistrationNumber;
	}

	public void setUserRegistrationNumber(String userRegistrationNumber) {
		this.userRegistrationNumber = userRegistrationNumber;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getRoleTxt() {
		return roleTxt;
	}

	public void setRoleTxt(String roleTxt) {
		this.roleTxt = roleTxt;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
