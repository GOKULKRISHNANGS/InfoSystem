package com.infoSystem.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblnotification", schema = "dbo")
public class NotificationEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "notification_id")
	private int notificationId;

	@Column(name = "notification_summary")
	private String notificationSummary;

	@Column(name = "notification_txt")
	private String notificationText;

	@Column(name = "created_by")
	private int createdBy;

	@Column(name = "created_timestamp")
	private Date createdTimestamp;

	public int getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(int notificationId) {
		this.notificationId = notificationId;
	}

	public String getNotificationText() {
		return notificationText;
	}

	public void setNotificationText(String notificationText) {
		this.notificationText = notificationText;
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

	public String getNotificationSummary() {
		return notificationSummary;
	}

	public void setNotificationSummary(String notificationSummary) {
		this.notificationSummary = notificationSummary;
	}

}
