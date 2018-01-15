package com.infoSystem.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblissue", schema = "dbo")
public class IssueEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "issue_id")
	private int issueId;

	@Column(name = "issue_txt")
	private String issueTxt;

	@Column(name = "created_by")
	private int createdBy;

	@Column(name = "created_timestamp")
	private Date createdTimestamp;

	public int getIssueId() {
		return issueId;
	}

	public void setIssueId(int issueId) {
		this.issueId = issueId;
	}

	public String getIssueTxt() {
		return issueTxt;
	}

	public void setIssueTxt(String issueTxt) {
		this.issueTxt = issueTxt;
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
