package com.infoSystem.model;

import java.util.Date;

public class NotificationModel {

	private int notificationId;

	private String notificationSummary;

	private String notificationText;

	private int createdBy;

	private Date createdTimestamp;

	public int getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(int notificationId) {
		this.notificationId = notificationId;
	}

	public String getNotificationSummary() {
		return notificationSummary;
	}

	public void setNotificationSummary(String notificationSummary) {
		this.notificationSummary = notificationSummary;
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

}
