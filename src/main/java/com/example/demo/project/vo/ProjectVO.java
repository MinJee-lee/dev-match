package com.example.demo.project.vo;

import com.example.demo.common.vo.FileVO;
import com.example.demo.community.vo.ReplyVO;
import com.example.demo.member.vo.MemberVO;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class ProjectVO {

    private int projectNo;
    private String leaderId;
    private List<MemberVO> teamMember;
    private String projectName;
    private int progressClassification;
    private int projectCategory;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date preStartDate;
    private Date startDate;
    private int prePeriod;
    private Date regDate;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date applicationDeadline;
    private int meetingMethod;
    private String meetingLocation;
    private String skillHashTag;
    private String applicantQuestionA;
    private String applicantQuestionB;
    private String applicantQuestionC;
    private List<ReplyVO> projectReply;
    private int applicantsCnt;
    private int recruitmentMemberCnt;
    private int projectViewCnt;
    private int projectStatus;
    private String projectDetail;
    private Date endDate;
    private int bookmarkNo;
    private List<FileVO> uploadFiles;
    private int endProjectCnt;
    private String detailHtml;

	public ProjectVO() {
	}

	public int getProjectNo() {
		return projectNo;
	}

	public void setProjectNo(int projectNo) {
		this.projectNo = projectNo;
	}

	public String getLeaderId() {
		return leaderId;
	}

	public void setLeaderId(String leaderId) {
		this.leaderId = leaderId;
	}

	public List<MemberVO> getTeamMember() {
		return teamMember;
	}

	public void setTeamMember(List<MemberVO> teamMember) {
		this.teamMember = teamMember;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public int getProgressClassification() {
		return progressClassification;
	}

	public void setProgressClassification(int progressClassification) {
		this.progressClassification = progressClassification;
	}

	public int getProjectCategory() {
		return projectCategory;
	}

	public void setProjectCategory(int projectCategory) {
		this.projectCategory = projectCategory;
	}

	public Date getPreStartDate() {
		return preStartDate;
	}

	public void setPreStartDate(Date preStartDate) {
		this.preStartDate = preStartDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public int getPrePeriod() {
		return prePeriod;
	}

	public void setPrePeriod(int prePeriod) {
		this.prePeriod = prePeriod;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Date getApplicationDeadline() {
		return applicationDeadline;
	}

	public void setApplicationDeadline(Date applicationDeadline) {
		this.applicationDeadline = applicationDeadline;
	}

	public int getMeetingMethod() {
		return meetingMethod;
	}

	public void setMeetingMethod(int meetingMethod) {
		this.meetingMethod = meetingMethod;
	}

	public String getMeetingLocation() {
		return meetingLocation;
	}

	public void setMeetingLocation(String meetingLocation) {
		this.meetingLocation = meetingLocation;
	}

	public String getSkillHashTag() {
		return skillHashTag;
	}

	public void setSkillHashTag(String skillHashTag) {
		this.skillHashTag = skillHashTag;
	}

	public String getApplicantQuestionA() {
		return applicantQuestionA;
	}

	public void setApplicantQuestionA(String applicantQuestionA) {
		this.applicantQuestionA = applicantQuestionA;
	}

	public String getApplicantQuestionB() {
		return applicantQuestionB;
	}

	public void setApplicantQuestionB(String applicantQuestionB) {
		this.applicantQuestionB = applicantQuestionB;
	}

	public String getApplicantQuestionC() {
		return applicantQuestionC;
	}

	public void setApplicantQuestionC(String applicantQuestionC) {
		this.applicantQuestionC = applicantQuestionC;
	}

	public List<ReplyVO> getProjectReply() {
		return projectReply;
	}

	public void setProjectReply(List<ReplyVO> projectReply) {
		this.projectReply = projectReply;
	}

	public int getApplicantsCnt() {
		return applicantsCnt;
	}

	public void setApplicantsCnt(int applicantsCnt) {
		this.applicantsCnt = applicantsCnt;
	}

	public int getRecruitmentMemberCnt() {
		return recruitmentMemberCnt;
	}

	public void setRecruitmentMemberCnt(int recruitmentMemberCnt) {
		this.recruitmentMemberCnt = recruitmentMemberCnt;
	}

	public int getProjectViewCnt() {
		return projectViewCnt;
	}

	public void setProjectViewCnt(int projectViewCnt) {
		this.projectViewCnt = projectViewCnt;
	}

	public int getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(int projectStatus) {
		this.projectStatus = projectStatus;
	}

	public String getProjectDetail() {
		return projectDetail;
	}

	public void setProjectDetail(String projectDetail) {
		this.projectDetail = projectDetail;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getBookmarkNo() {
		return bookmarkNo;
	}

	public void setBookmarkNo(int bookmarkNo) {
		this.bookmarkNo = bookmarkNo;
	}

	public List<FileVO> getUploadFiles() {
		return uploadFiles;
	}

	public void setUploadFiles(List<FileVO> uploadFiles) {
		this.uploadFiles = uploadFiles;
	}

	public int getEndProjectCnt() {
		return endProjectCnt;
	}

	public void setEndProjectCnt(int endProjectCnt) {
		this.endProjectCnt = endProjectCnt;
	}

	public String getDetailHtml() {
		return detailHtml;
	}

	public void setDetailHtml(String detailHtml) {
		this.detailHtml = detailHtml;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("ProjectVO{");
		sb.append("projectNo=").append(projectNo);
		sb.append(", leaderId='").append(leaderId).append('\'');
		sb.append(", teamMember=").append(teamMember);
		sb.append(", projectName='").append(projectName).append('\'');
		sb.append(", progressClassification=").append(progressClassification);
		sb.append(", projectCategory=").append(projectCategory);
		sb.append(", preStartDate=").append(preStartDate);
		sb.append(", startDate=").append(startDate);
		sb.append(", prePeriod=").append(prePeriod);
		sb.append(", regDate=").append(regDate);
		sb.append(", applicationDeadline=").append(applicationDeadline);
		sb.append(", meetingMethod=").append(meetingMethod);
		sb.append(", meetingLocation='").append(meetingLocation).append('\'');
		sb.append(", skillHashTag='").append(skillHashTag).append('\'');
		sb.append(", applicantQuestionA='").append(applicantQuestionA).append('\'');
		sb.append(", applicantQuestionB='").append(applicantQuestionB).append('\'');
		sb.append(", applicantQuestionC='").append(applicantQuestionC).append('\'');
		sb.append(", projectReply=").append(projectReply);
		sb.append(", applicantsCnt=").append(applicantsCnt);
		sb.append(", recruitmentMemberCnt=").append(recruitmentMemberCnt);
		sb.append(", projectViewCnt=").append(projectViewCnt);
		sb.append(", projectStatus=").append(projectStatus);
		sb.append(", projectDetail='").append(projectDetail).append('\'');
		sb.append(", endDate=").append(endDate);
		sb.append(", bookmarkNo=").append(bookmarkNo);
		sb.append(", uploadFiles=").append(uploadFiles);
		sb.append(", endProjectCnt=").append(endProjectCnt);
		sb.append(", detailHtml='").append(detailHtml).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
