package com.example.demo.project.service.impl;

import com.example.demo.common.vo.PageVO;
import com.example.demo.common.vo.SearchVO;
import com.example.demo.community.vo.ReplyVO;
import com.example.demo.project.dao.ProjectDAO;
import com.example.demo.project.dto.*;
import com.example.demo.project.service.ProjectService;
import com.example.demo.project.vo.MyProjectVO;
import com.example.demo.project.vo.ProjectVO;
import com.example.demo.project.vo.TodoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional(rollbackFor = Exception.class, timeout = 10)
@Service("projectServiceImpl")
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    @Qualifier("projectDAOImpl")
    ProjectDAO projectDAO;

    @Override
    public ProjectVO addProject(ProjectVO projectVO) {
        Map<String, Object> map = new HashMap<>();
        map.put("projectNo", projectDAO.addProject(projectVO));
        map.put("userId", projectVO.getLeaderId());
        map.put("searchVO", new SearchVO(1,5));

        return projectDAO.updateMemberStatus(map) == 1 ? projectDAO.getProject(map) : null;
    }

    @Override
    public Map<String, Object> getProject(int projectNo, String userId) {

        Map<String, Object> getProjectMap = new HashMap<>();
        SearchVO searchVO = new SearchVO(1, 5);
        getProjectMap.put("projectNo", projectNo);
        getProjectMap.put("userId", userId);
        getProjectMap.put("searchVO", searchVO);


        ProjectVO projectVO = projectDAO.getProject(getProjectMap);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("projectVO", projectVO);
        map.put("existApplicant", projectDAO.existApplicant(getProjectMap));

        int totalCount = projectDAO.getReplyTotalCount(getProjectMap);

        PageVO resultPage = new PageVO( searchVO.getCurrentPage(), totalCount,5, searchVO.getPageSize());
        map.put("resultPage", resultPage);

        if(projectVO.getSkillHashTag() != null) {
            String[] hashTagList = projectVO.getSkillHashTag().split("  ");
            map.put("hashList",hashTagList);
        }

        return map;
    }

    @Override
    public ReplyVO addProjectReply(ProjectReplyDTO projectReplyDTO) {
        return projectDAO.addProjectReply(projectReplyDTO);
    }

    @Override
    public MyProjectVO getMyProject(int projectNo) {
        return projectDAO.getMyProject(projectNo);
    }

    @Override
    public TodoVO addTodo(AddTodoDTO addTodoDTO) {
        return projectDAO.addTodo(addTodoDTO);
    }

    @Override
    public int addBookmark(ProjectBookmarkDTO projectBookmarkDTO) {
        return projectDAO.addBookmark(projectBookmarkDTO);
    }

    @Override
    public int deleteBookmark(ProjectBookmarkDTO projectBookmarkDTO) {
        return projectDAO.deleteBookmark(projectBookmarkDTO);
    }

    @Override
    public List<ProjectVO> getProjectList(ProjectSearchDTO projectSearchDTO) {
        if(projectSearchDTO.getUserId()==null) projectSearchDTO.setUserId("jack");
        return projectDAO.getProjectList(projectSearchDTO);
    }

    @Override
    public int deleteProject(int projectNo) {

        if (projectDAO.getMyProject(projectNo).getTeamMember().size() == 1) {
            return projectDAO.deleteProject(projectNo);
        } else {
            return 0;
        }
    }

    @Override
    public int withdrawProject(String userId) {
        return projectDAO.withdrawProject(userId);
    }

    @Override
    public int updateProjectLeader(Map<String, Object> updateProjectLeaderMap) {
        return projectDAO.updateProjectLeader(updateProjectLeaderMap);
    }

    @Override
    public int addEndProjectCount(Map<String, Object> endProjectCountMap) {

        int teamMemberCnt = Integer.parseInt((String) endProjectCountMap.get("teamMemberCnt"));
        int votedMemberCnt = Integer.parseInt((String) endProjectCountMap.get("votedMemberCnt"));
        if (teamMemberCnt - 1 == votedMemberCnt) {
            projectDAO.updateProjectStatus(endProjectCountMap);
        }

        return projectDAO.addEndProjectCount(endProjectCountMap);

    }

    @Override
    public int addReview(AddReviewDTO addReviewDTO) {
        List<AddReviewDTO> addReviewDTOList = addReviewDTO.getReviewList();
        return projectDAO.addReview(addReviewDTOList);
    }

    @Override
    public int updateTodoStatus(Map updateTodoStatusMap) {
        return projectDAO.updateTodoStatus(updateTodoStatusMap);
    }

    @Override
    public List<ReplyVO> getReplyList(SearchVO searchVO, int projectNo) {
        Map<String, Object> map = new HashMap<>();

        map.put("searchVO", searchVO);
        map.put("projectNo", projectNo);
        return projectDAO.getReplyList(map);
    }

}
