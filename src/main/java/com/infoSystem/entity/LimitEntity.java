package com.infoSystem.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbllimit", schema = "dbo")
public class LimitEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "limit_id")
	private int limitId;

	@Column(name = "user_id")
	private int userId;

	@Column(name = "created_by")
	private int createdBy;

	@Column(name = "created_timestamp")
	private Date createdTimestamp;

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

	public Date getCreatedTimestamp() {
		return createdTimestamp;
	}

	public void setCreatedTimestamp(Date createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}

}
