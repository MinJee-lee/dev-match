package com.example.demo.projectApplicant.dao.impl;

import com.example.demo.common.vo.SearchVO;
import com.example.demo.project.vo.ProjectVO;
import com.example.demo.projectApplicant.dao.ProjectApplicantDAO;
import com.example.demo.projectApplicant.dto.UpdateApplicantStatusDTO;
import com.example.demo.projectApplicant.vo.ApplicantVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository("projectApplicantDAOImpl")
public class ProjectApplicantDAOImpl implements ProjectApplicantDAO{
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	 }
	
	//Constructor
	public ProjectApplicantDAOImpl() {
		System.out.println("::"+getClass()+".default Constructor Call....");
	}

	@Override
	public void addProject(ProjectVO projectVO) {
		sqlSession.insert("projectMapper.addProject",projectVO);
	}

	@Override
	public ProjectVO getProject(int projectNo) {
		return sqlSession.selectOne("projectMapper.getProject",projectNo);
	}

	@Override
	public void addApplicant(ApplicantVO applicantVO) {
		sqlSession.insert("applicantMapper.addApplicant",applicantVO);
	}

	@Override
	public ApplicantVO getApplicant(int applicantNo) {
		return sqlSession.selectOne("applicantMapper.getApplicant",applicantNo);
	}

	@Override
	public void updateApplicantStatus(UpdateApplicantStatusDTO updateApplicantStatusDTO) {
		sqlSession.update("applicantMapper.updateApplicantStatus",updateApplicantStatusDTO);
	}

	@Override
	public void updateProjectMember(UpdateApplicantStatusDTO updateApplicantStatusDTO) {
		sqlSession.update("applicantMapper.updateProjectMember",updateApplicantStatusDTO);
	}

	@Override
	public List<ApplicantVO> getApplicantList(SearchVO searchVO) {
		return sqlSession.selectList("applicantMapper.getApplicantList",searchVO);
	}

	@Override
	public List<ApplicantVO> getAppliedApplicantList(SearchVO searchVO) {
		return sqlSession.selectList("applicantMapper.getAppliedApplicantList",searchVO);
	}

	@Override
	public void uploadFile(HashMap<String, Object> hm) {
		sqlSession.insert("applicantMapper.uploadFile",hm);
	}

	@Override
	public int getAppliedTotalCount(SearchVO searchVO) {
		return sqlSession.selectOne("applicantMapper.appliedTotalCount", searchVO);
	}

	@Override
	public void addProApplicant(ProjectVO projectVO) {
		sqlSession.insert("applicantMapper.addProApplicant",projectVO);
	}

}
