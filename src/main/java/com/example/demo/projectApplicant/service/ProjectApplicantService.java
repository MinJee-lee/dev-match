package com.example.demo.projectApplicant.service;

import com.example.demo.common.vo.SearchVO;
import com.example.demo.project.vo.ProjectVO;
import com.example.demo.projectApplicant.dto.UpdateApplicantStatusDTO;
import com.example.demo.projectApplicant.vo.ApplicantVO;

import java.util.Map;

public interface ProjectApplicantService {
	
	void addProject(ProjectVO projectVO);
	
	ProjectVO getProject(int projectNo);

    void addApplicant(ApplicantVO applicantVO);
    
    void addProApplicant(ProjectVO projectVO);

    ApplicantVO getApplicant(int applicantNo);

    Map<String,Object> getAppliedProjectList(SearchVO searchVO);

    Map<String,Object> getApplicantList(SearchVO searchVO);
    
    void fileUpload(int projectNo, String originFileName, long fileSize);

    //Rest - DTO
    void updateApplicantStatus(UpdateApplicantStatusDTO updateApplicantStatusDTO);

}

