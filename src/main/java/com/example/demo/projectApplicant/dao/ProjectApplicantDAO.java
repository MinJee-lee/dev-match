package com.example.demo.projectApplicant.dao;

import com.example.demo.common.vo.SearchVO;
import com.example.demo.project.vo.ProjectVO;
import com.example.demo.projectApplicant.dto.UpdateApplicantStatusDTO;
import com.example.demo.projectApplicant.vo.ApplicantVO;

import java.util.HashMap;
import java.util.List;

public interface ProjectApplicantDAO {
	
	void addProject(ProjectVO projectVO);
	
	ProjectVO getProject(int projectNo);
	
	void addApplicant(ApplicantVO applicantVO);
	
	void addProApplicant(ProjectVO projectVO);

	ApplicantVO getApplicant(int applicantNo);
	
	List<ApplicantVO> getApplicantList(SearchVO searchVO);
	
	List<ApplicantVO> getAppliedApplicantList(SearchVO searchVO);
	
	void updateApplicantStatus(UpdateApplicantStatusDTO updateApplicantStatusDTO);
	
	void updateProjectMember(UpdateApplicantStatusDTO updateApplicantStatusDTO);

	void uploadFile(HashMap<String, Object> hm);

	int getAppliedTotalCount(SearchVO searchVO);

}
