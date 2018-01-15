package com.infoSystem.model;

import java.util.Date;

public class IssueModel {

	private int issueId;

	private String issueText;
	
	private int createdBy;

	private Date createdTimeStamp;

	public int getIssueId() {
		return issueId;
	}

	public void setIssueId(int issueId) {
		this.issueId = issueId;
	}

	public String getIssueText() {
		return issueText;
	}

	public void setIssueText(String issueText) {
		this.issueText = issueText;
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
