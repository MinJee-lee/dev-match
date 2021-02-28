package com.example.demo.projectApplicant.vo;

import com.example.demo.member.vo.MemberVO;
import com.example.demo.project.vo.ProjectVO;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class ApplicantVO {
	
	private int applicantNo;
	private String userId;
	private String profileImg;
	private int applicantStatus;
	private String applicantAnswerA;
	private String applicantAnswerB;
	private String applicantAnswerC;
	private String introToMember;
	private ProjectVO projectVO;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date aRegDate;
	private List<MemberVO> teamMember;
	
	
	public List<MemberVO> getTeamMember() {
		return teamMember;
	}

	public void setTeamMember(List<MemberVO> teamMember) {
		this.teamMember = teamMember;
	}

	public Date getaRegDate() {
		return aRegDate;
	}

	public void setaRegDate(Date aRegDate) {
		this.aRegDate = aRegDate;
	}

	public ApplicantVO() {
	}

	public int getApplicantNo() {
		return applicantNo;
	}

	public void setApplicantNo(int applicantNo) {
		this.applicantNo = applicantNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getProfileImg() {
		return profileImg;
	}

	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}

	public int getApplicantStatus() {
		return applicantStatus;
	}

	public void setApplicantStatus(int applicantStatus) {
		this.applicantStatus = applicantStatus;
	}

	public String getApplicantAnswerA() {
		return applicantAnswerA;
	}

	public void setApplicantAnswerA(String applicantAnswerA) {
		this.applicantAnswerA = applicantAnswerA;
	}

	public String getApplicantAnswerB() {
		return applicantAnswerB;
	}

	public void setApplicantAnswerB(String applicantAnswerB) {
		this.applicantAnswerB = applicantAnswerB;
	}

	public String getApplicantAnswerC() {
		return applicantAnswerC;
	}

	public void setApplicantAnswerC(String applicantAnswerC) {
		this.applicantAnswerC = applicantAnswerC;
	}

	public String getIntroToMember() {
		return introToMember;
	}

	public void setIntroToMember(String introToMember) {
		this.introToMember = introToMember;
	}

	public ProjectVO getProjectVO() {
		return projectVO;
	}

	public void setProjectVO(ProjectVO projectVO) {
		this.projectVO = projectVO;
	}

	@Override
	public String toString() {
		return "ApplicantVO [applicantNo=" + applicantNo + ", userId=" + userId + ", profileImg=" + profileImg
				+ ", applicantStatus=" + applicantStatus + ", applicantAnswerA=" + applicantAnswerA
				+ ", applicantAnswerB=" + applicantAnswerB + ", applicantAnswerC=" + applicantAnswerC
				+ ", introToMember=" + introToMember + ", projectVO=" + projectVO + ", aRegDate=" + aRegDate + "]";
	}

}