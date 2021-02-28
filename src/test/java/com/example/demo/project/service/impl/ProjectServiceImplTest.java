//package com.example.demo.project.service.impl;
//
//import com.example.demo.common.vo.ReviewVO;
//import com.example.demo.common.vo.SearchVO;
//import com.example.demo.project.dto.ProjectBookmarkDTO;
//import com.example.demo.project.dto.ProjectReplyDTO;
//import com.example.demo.project.service.ProjectService;
//import com.example.demo.project.vo.MyProjectVO;
//import com.example.demo.project.vo.ProjectVO;
//import com.example.demo.project.vo.TodoVO;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.*;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class ProjectServiceImplTest {
//
//    @Autowired
//    @Qualifier("projectServiceImpl")
//    private ProjectService projectService;
//
//    //@Test
//    public void addProject() {
//
//        ProjectVO projectVO = new ProjectVO();
//
//        projectVO.setLeaderId("user07");
//        projectVO.setProjectName("프로젝트 등록 테스트");
//        projectVO.setProgressClassification(2);
//        projectVO.setProjectCategory(1);
//        projectVO.setPreStartDate(new Date());
//        projectVO.setPrePeriod(200);
//        projectVO.setMeetingMethod(1);
//        projectVO.setMeetingLocation("경기도 수원시");
//        projectVO.setApplicationDeadline(new Date());
//        projectVO.setProjectDetail("project detail");
//        projectVO.setApplicantQuestionA("applicantQuestionA");
//        projectVO.setRecruitmentMemberCnt(5);
//
//        projectService.addProject(projectVO);
//
//
//    }
//
//    //@Test
//    public void addProjectReply() {
//
//        ProjectReplyDTO projectReplyDTO = new ProjectReplyDTO();
//        projectReplyDTO.setProjectNo(1);
//        projectReplyDTO.setReplyContent("addReplyTest");
//        projectReplyDTO.setReplyUserId("user02");
//
//        Assert.assertEquals(1, projectService.addProjectReply(projectReplyDTO));
//
//    }
//
//    //@Test
//    public void getProject() {
//
//        ProjectVO projectVO = projectService.getProject(1, "user01");
//
////        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+projectVO);
////        //테스트 데이터 프로젝트 명
////        Assert.assertEquals("testProject", projectVO.getProjectName());
////        //테스트 데이터 댓글 수
////        Assert.assertEquals(3, projectVO.getProjectReply().get(0).getReplyNo());
////        //테스트 데이터 지원자 수
////        Assert.assertEquals(2, projectVO.getApplicantsCnt());
////        //테스트 데이터 첫번째 해시태그
////        Assert.assertEquals("test", projectVO.getSkillHashTag().get(0));
////        //테스트 데이터 팀원
////        Assert.assertEquals("user01", projectVO.getTeamMember().get(0).getUserId());
////        Assert.assertEquals("DEFAULTImage.jpg", projectVO.getTeamMember().get(0).getProfileImg());
////        //테스트 데이터 북마크여부
////        Assert.assertEquals(1, projectVO.getBookmarkCheck());
//
//    }
//
//    //@Test
//    public void getMyProject() {
//
//        MyProjectVO myProjectVO = projectService.getMyProject(1);
//
//        Assert.assertEquals(1, myProjectVO.getTodoList().get(0).getProjectNO());
//        Assert.assertEquals(1, myProjectVO.getTodoList().get(0).getTodoNo());
//        Assert.assertEquals("Todo Test1", myProjectVO.getTodoList().get(0).getTodoContent());
//        Assert.assertEquals("user01", myProjectVO.getTodoList().get(0).getUserId());
//        Assert.assertEquals(2, myProjectVO.getTodoList().get(0).getTodoStatus());
//        Assert.assertEquals(2, myProjectVO.getTodoList().get(1).getTodoNo());
//        Assert.assertEquals(3, myProjectVO.getTodoList().get(2).getTodoNo());
//
//    }
//
//    //@Test
//    public void addTodo() {
//
//        TodoVO todoVO = new TodoVO();
//        todoVO.setProjectNO(1);
//        todoVO.setUserId("user01");
//        todoVO.setTodoContent("Todo Add Test");
//
//        Assert.assertEquals(1, projectService.addTodo(todoVO));
//
//    }
//
//    //@Test
//    public void addBookmark() {
//
//        ProjectBookmarkDTO projectBookmarkDTO = new ProjectBookmarkDTO();
//        projectBookmarkDTO.setProjectNo(2);
//        projectBookmarkDTO.setUserId("user06");
//
//        Assert.assertEquals(1, projectService.addBookmark(projectBookmarkDTO));
//
//    }
//
//    //@Test
//    public void deleteBookmark() {
//
//        ProjectBookmarkDTO projectBookmarkDTO = new ProjectBookmarkDTO();
//        projectBookmarkDTO.setBookmarkNo(10);
//
//        //Assert.assertEquals(1, projectService.deleteBookmark(projectBookmarkDTO));
//
//    }
//
//    @Test
//    public void getProjectList() {
//
//        SearchVO searchVO = new SearchVO();
//
//        searchVO.setCurrentPage(1);
//        searchVO.setPageSize(10);
//
//        //searchConditionA 프로젝트 카테고리 = 1:개발, 2:기획, 3:디자인
//        //searchVO.setSearchConditionA(1);
//
//        //searchConditionB 미팅방식 = 1:대면, 2:비대면
//        //searchVO.setSearchConditionB(1);
//
//        //searchConditionC 검색어 조건 = 1:제목, 2:해시태그, 3:프로젝트 내용
//        //searchVO.setSearchConditionC(1);
//
//        //searchConditionD 프로젝트 상태 조건 = 1:모집중, 2:모집완료, 3:종료
//        searchVO.setSearchConditionD(1);
//
//
//        searchVO.setSearchKeyword("test");
//
//        //sort 정렬조건 = 1: 최신등록순, 2:모집 마감 임박 순
//        searchVO.setSort(1);
//
//        searchVO.setUserId("user01"); //로그인 된 아이디 ( 북마크 체킹용 )
//
//        List<ProjectVO> projectVOList = projectService.getProjectList(searchVO);
//        Assert.assertEquals(6, projectVOList.size());
//
//
//    }
//
//    //@Test
//    public void deleteProject() {
//        /*
//
//        TODO 테이블 데이터 날리기 vs 컬럼추가해서 플래그처리 선택
//
//        TODO 테이블 데이터 날리기 = 연관컬럼 on set NULL or on delete cascade 설정해주기
//        TODO 컬럼추가해서 플래그처리 = MEMBER 테이블 연관 데이터만 null처리 해주기
//
//        */
//
//        //Assert.assertEquals(1, projectService.deleteProject(4));
//    }
//
//    //@Test
//    public void withdrawProject() {
//        Assert.assertEquals(1, projectService.withdrawProject("user07"));
//    }
//
//    //@Test
//    public void updateProjectLeader() {
//
//        Assert.assertEquals(1, projectService.updateProjectLeader(1, "user07", "user01"));
//
//    }
//
//    //@Test
//    public void addReview() {
//
//        ReviewVO reviewVO1 = new ReviewVO();
//        ReviewVO reviewVO2 = new ReviewVO();
//        ReviewVO reviewVO3 = new ReviewVO();
//
//        reviewVO1.setReviewGrade(1);
//        reviewVO1.setProjectNo(1);
//        reviewVO1.setReviewComment("nice!");
//        reviewVO1.setUserId("user01");
//
//        reviewVO2.setReviewGrade(1);
//        reviewVO2.setProjectNo(1);
//        reviewVO2.setReviewComment("goooood");
//        reviewVO2.setUserId("user01");
//
//        reviewVO3.setReviewGrade(-1);
//        reviewVO3.setProjectNo(1);
//        reviewVO3.setReviewComment("baddddd");
//        reviewVO3.setUserId("user01");
//
//        List<ReviewVO> list = new ArrayList<>();
//        list.add(reviewVO1);
//        list.add(reviewVO2);
//        list.add(reviewVO3);
//
//        Assert.assertEquals(3, projectService.addReview(list));
//
//    }
//
//}