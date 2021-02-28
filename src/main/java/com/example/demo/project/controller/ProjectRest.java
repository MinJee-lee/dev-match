package com.example.demo.project.controller;

import com.example.demo.common.vo.SearchVO;
import com.example.demo.community.vo.ReplyVO;
import com.example.demo.member.service.MemberService;
import com.example.demo.member.util.SecurityUtils;
import com.example.demo.member.vo.MemberVO;
import com.example.demo.project.dto.AddTodoDTO;
import com.example.demo.project.dto.ProjectBookmarkDTO;
import com.example.demo.project.dto.ProjectReplyDTO;
import com.example.demo.project.dto.ProjectSearchDTO;
import com.example.demo.project.service.ProjectService;
import com.example.demo.project.vo.ProjectVO;
import com.example.demo.project.vo.TodoVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/project")
@Slf4j
public class ProjectRest {

    @Autowired
    @Qualifier("projectServiceImpl")
    ProjectService projectService;

    @Autowired
    @Qualifier("memberServiceImpl")
    MemberService memberService;

    public ProjectRest(ProjectService projectService) {
        log.info(":: " + getClass().getName() + " Start::");
        this.projectService = projectService;
    }

    @PostMapping("/addBookmark")
    public int addBookmark(@RequestBody ProjectBookmarkDTO projectBookmarkDTO) {

        if (projectBookmarkDTO.getBookmarkControl() == 1) {
            return projectService.addBookmark(projectBookmarkDTO);
        } else if (projectBookmarkDTO.getBookmarkControl() == 2) {
            return projectService.deleteBookmark(projectBookmarkDTO);
        } else {
            return 0;
        }
    }

    @PostMapping("/addReply")
    public ReplyVO addReply(@RequestBody ProjectReplyDTO projectReplyDTO) {
        return projectService.addProjectReply(projectReplyDTO);
    }

    @PostMapping("/addTodo")
    public TodoVO addTodo(@RequestBody AddTodoDTO addTodoDTO) {
        return projectService.addTodo(addTodoDTO);
    }

    @PostMapping("/updateTodoStatus")
    public int updateTodoStatus(@RequestBody Map updateTodoStatusMap) {
        return projectService.updateTodoStatus(updateTodoStatusMap);
    }

    @GetMapping("/withdraw")
    public int withdrawProject(@RequestParam("userId") String userId, HttpSession session) {
        return projectService.withdrawProject(userId) == 1 ? sessionUpdateUtil(session) : 0;
    }

    @PostMapping("/endProject")
    public int addEndProjectCount(@RequestBody Map<String, Object> endProjectCountMap,HttpSession session) {
        return projectService.addEndProjectCount(endProjectCountMap) == 1 ? sessionUpdateUtil(session) : 0;
    }

    @GetMapping("/deleteProject")
    public int deleteProject(@RequestParam("projectNo") int projectNo, HttpSession session) {
        return projectService.deleteProject(projectNo) == 1 ? sessionUpdateUtil(session) : 0;
    }

    @PostMapping("/updateProjectLeader")
    public int updateProjectLeader(@RequestBody Map<String, Object> updateProjectLeaderMap, HttpSession session) {
        return projectService.updateProjectLeader(updateProjectLeaderMap) == 1 ? sessionUpdateUtil(session) : 0;
    }

    @GetMapping("/getReplyList")
    public List<ReplyVO> getReplyList(@RequestParam("projectNo") int projectNo,
                                      @ModelAttribute("currentPage") SearchVO searchVO) {

        return projectService.getReplyList(searchVO, projectNo);
    }

    @PostMapping("/getProjectList")
    public List<ProjectVO> getProjectList(@RequestBody ProjectSearchDTO projectSearchDTO) {
        projectSearchDTO.setUserId(SecurityUtils.getLoginSessionMemberInfo().getUsername());
        return projectService.getProjectList(projectSearchDTO);

    }

    private int sessionUpdateUtil(HttpSession session) {
        session.removeAttribute("user");
        MemberVO memberVO = memberService.selectMember(SecurityUtils.getLoginSessionMemberInfo().getUsername());
        if (memberVO != null) {
            session.setAttribute("user", memberVO);
            return 1;
        }
        return 0;
    }



}
