package com.example.demo.projectApplicant.dto;

public class UpdateApplicantStatusDTO {
	
	private int applicantNo;
	private int applicantStatus;
	private int projectNo;
	private String userId;
	
	public UpdateApplicantStatusDTO() {
		super();
	}
	
	public int getProjectNo() {
		return projectNo;
	}

	public void setProjectNo(int projectNo) {
		this.projectNo = projectNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getApplicantNo() {
		return applicantNo;
	}

	public void setApplicantNo(int applicantNo) {
		this.applicantNo = applicantNo;
	}

	public int getApplicantStatus() {
		return applicantStatus;
	}

	public void setApplicantStatus(int applicantStatus) {
		this.applicantStatus = applicantStatus;
	}

	@Override
	public String toString() {
		return "UpdateApplicantStatusDTO [applicantNo=" + applicantNo + ", applicantStatus=" + applicantStatus
				+ ", projectNo=" + projectNo + ", userId=" + userId + "]";
	}
}
