package com.infoSystem.model;

import java.util.Date;

public class LimitModel {

	private int limitId;

	private int userId;

	private int createdBy;

	private Date createdTimeStamp;

	public int getLimitId() {
		return limitId;
	}

	public void setLimitId(int limitId) {
		this.limitId = limitId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedTimeStamp() {
		return createdTimeStamp;
	}

	public void setCreatedTimeStamp(Date createdTimeStamp) {
		this.createdTimeStamp = createdTimeStamp;
	}

}
