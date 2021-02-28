package com.example.demo.project.service;

import com.example.demo.common.vo.SearchVO;
import com.example.demo.community.vo.ReplyVO;
import com.example.demo.project.dto.*;
import com.example.demo.project.vo.MyProjectVO;
import com.example.demo.project.vo.ProjectVO;
import com.example.demo.project.vo.TodoVO;

import java.util.List;
import java.util.Map;

public interface ProjectService {

    //프로젝트 등록
    ProjectVO addProject(ProjectVO projectVO);

    //프로젝트 상세정보 조회
    Map<String, Object> getProject(int projectNo, String userId);

    //프로젝트 댓글 작성
    ReplyVO addProjectReply(ProjectReplyDTO projectReplyDTO);

    //진행중인 프로젝트 조회
    MyProjectVO getMyProject(int projectNo);

    //TodoList 추가
    TodoVO addTodo(AddTodoDTO addTodoDTO);

    //BookMark 추가
    int addBookmark(ProjectBookmarkDTO projectBookmarkDTO);

    //BookMark 삭제
    int deleteBookmark(ProjectBookmarkDTO projectBookmarkDTO);

    //프로젝트 목록 조회
    List<ProjectVO> getProjectList(ProjectSearchDTO projectSearchDTO);

    //프로젝트 삭제
    int deleteProject(int projectNo);

    //프로젝트 탈퇴
    int withdrawProject(String userId);

    //팀장 프로젝트 탈퇴 ( 권한 위임 )
    int updateProjectLeader(Map<String ,Object> updateProjectLeaderMap);

    //프로젝트 종료 투표
    int addEndProjectCount(Map<String , Object> endProjectCountMap);

    //신청서 모집마감 체크 후 상태변경 - 스케쥴러
    //void applicationDeadlineCheck();

    //리뷰작성
    int addReview(AddReviewDTO addReviewDTO);

    //todolist 상태변경
    int updateTodoStatus(Map updateTodoStatusMap);

    List<ReplyVO> getReplyList(SearchVO searchVO, int projectNo);


    //파일 다운로드 - 보류
    //String getProjectFile(String fileName);


}
