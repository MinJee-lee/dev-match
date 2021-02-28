package com.example.demo.project.dao.impl;

import com.example.demo.community.vo.ReplyVO;
import com.example.demo.project.dao.ProjectDAO;
import com.example.demo.project.dto.*;
import com.example.demo.project.vo.MyProjectVO;
import com.example.demo.project.vo.ProjectVO;
import com.example.demo.project.vo.TodoVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional(rollbackFor = Exception.class, timeout = 10)
@Repository("projectDAOImpl")
public class ProjectDAOImpl implements ProjectDAO {

    @Autowired
    @Qualifier("sqlSessionTemplate")
    private SqlSession sqlSession;

    private final String NAMESPACE = "projectMapper.";

    @Override
    public int addProject(ProjectVO projectVO) {
        sqlSession.insert(NAMESPACE + "addProject", projectVO);
        sqlSession.insert(NAMESPACE + "addHashtag", projectVO);
        return projectVO.getProjectNo();
    }

    @Override
    public int updateMemberStatus(Map<String, Object> map) {
        return sqlSession.update(NAMESPACE + "updateMemberProjectNo", map);

    }

    @Override
    public ProjectVO getProject(Map<String, Object> getProjectMap) {
        return sqlSession.update(NAMESPACE + "updateViewCnt", getProjectMap) == 1 ?
                sqlSession.selectOne(NAMESPACE + "getProject", getProjectMap) : null;
    }

    @Override
    public ReplyVO addProjectReply(ProjectReplyDTO projectReplyDTO) {
        return sqlSession.insert(NAMESPACE + "addProjectReply", projectReplyDTO) == 1 ?
                sqlSession.selectOne(NAMESPACE + "getProjectReply", projectReplyDTO.getReplyNo()) : null;
    }

    @Override
    public MyProjectVO getMyProject(int projectNo) {
        return sqlSession.selectOne(NAMESPACE + "getMyProject", projectNo);
    }

    @Override
    public TodoVO addTodo(AddTodoDTO addTodoDTO) {
        sqlSession.insert(NAMESPACE + "addTodo", addTodoDTO);
        return sqlSession.selectOne(NAMESPACE + "getTodo", addTodoDTO.getTodoNo());
    }

    @Override
    public int addBookmark(ProjectBookmarkDTO projectBookmarkDTO) {
        return sqlSession.insert(NAMESPACE + "addBookmark", projectBookmarkDTO) == 1 ?
                projectBookmarkDTO.getBookmarkNo() : 0;
    }

    @Override
    public int deleteBookmark(ProjectBookmarkDTO projectBookmarkDTO) {
        return sqlSession.delete(NAMESPACE + "deleteBookmark", projectBookmarkDTO);
    }

    @Override
    public List<ProjectVO> getProjectList(ProjectSearchDTO projectSearchDTO) {
        return sqlSession.selectList(NAMESPACE + "getProjectList", projectSearchDTO);
    }

    @Override
    public int deleteProject(int projectNo) {
        return sqlSession.delete(NAMESPACE + "deleteProject", projectNo);
    }

    @Override
    public int withdrawProject(String userId) {
        return sqlSession.update(NAMESPACE + "withdrawProject", userId);
    }

    @Override
    public int updateProjectLeader(Map<String, Object> updateProjectLeaderMap) {
        sqlSession.update(NAMESPACE + "updateProjectLeader", updateProjectLeaderMap);
        sqlSession.update(NAMESPACE + "updateMemberProjectToNull", updateProjectLeaderMap.get("beforeLeaderId"));
        return sqlSession.update(NAMESPACE + "updateApplicantStatus", updateProjectLeaderMap);
    }

    @Override
    public int addEndProjectCount(Map<String, Object> addEndProjectCountMap) {
        return sqlSession.insert(NAMESPACE + "addEndProjectCount", addEndProjectCountMap);
    }

    @Override
    public int updateProjectStatus(Map<String, Object> updateProjectStatusMap) {
        sqlSession.update(NAMESPACE + "updateProjectStatus", updateProjectStatusMap);
        return sqlSession.update(NAMESPACE + "updateProjectNoOfTeamMembers", updateProjectStatusMap);
    }

    @Override
    public int addReview(List<AddReviewDTO> addReviewDTOList) {
        return sqlSession.insert(NAMESPACE + "addReview", addReviewDTOList);
    }

    @Override
    public int updateTodoStatus(Map updateTodoStatusMap) {
        return sqlSession.update(NAMESPACE + "updateTodoStatus", updateTodoStatusMap);
    }

    @Override
    public int getReplyTotalCount(Map<String, Object> getProjectMap) {
        return sqlSession.selectOne(NAMESPACE+"replyTotalCount", getProjectMap);
    }

    @Override
    public List<ReplyVO> getReplyList(Map<String, Object> map) {
        return sqlSession.selectList(NAMESPACE+"getProjectReplyByProjectNo", map);
    }

    @Override
    public int existApplicant(Map<String, Object> getProjectMap) {
        return sqlSession.selectOne("applicantMapper.existApplicant", getProjectMap);
    }


}
