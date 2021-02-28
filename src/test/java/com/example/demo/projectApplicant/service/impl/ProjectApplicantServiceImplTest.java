//package com.example.demo.projectApplicant.service.impl;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.util.Date;
//
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//
//import com.example.demo.project.service.ProjectService;
//import com.example.demo.project.vo.ProjectVO;
//import com.example.demo.projectApplicant.service.ProjectApplicantService;
//import com.example.demo.projectApplicant.vo.ApplicantVO;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class ProjectApplicantServiceImplTest {
//
//    @Autowired
//    @Qualifier("projectApplicantServiceImpl")
//    private ProjectApplicantService projectApplicantService;
//
//    public ProjectApplicantServiceImplTest() {
//        System.out.println("TEST APP @@@@@");
//    }
//
//    //@Test
//    public void getProject(){
//
//        ProjectVO projectVO = new ProjectVO();
//
//        projectVO = projectApplicantService.getProject(1);
//        System.out.println(projectVO);
//
//        Assert.assertEquals("testProject", projectVO.getProjectName());
//        Assert.assertEquals(3, projectVO.getProjectReply().get(0).getReplyNo());
//        Assert.assertEquals(1,projectVO.getProjectReply().size());
//        Assert.assertEquals(1,projectVO.getApplicantsCnt());
//    }
//
//    //@Test
//    public void addProject() {
//
//        //Change the project number to sequence... : hyein
//        //Check userVO projectNO : hyein
//        ProjectVO projectVO = new ProjectVO();
//        Date deadLine = new Date(2021-01-10);
//        Date preStartDate = new Date(2021-01-11);
//        Date today = new Date();
//
//
//        projectVO.setApplicantQuestionA("test질문A");
//        projectVO.setApplicantQuestionB("test질문B");
//        projectVO.setApplicantQuestionC("test질문C");
//        projectVO.setApplicationDeadline(deadLine);
//        projectVO.setLeaderId("user02");
//        projectVO.setMeetingLocation("서울시 중랑구");
//        projectVO.setMeetingMethod(2);
//        projectVO.setPrePeriod(3);
//        projectVO.setPreStartDate(preStartDate);
//        projectVO.setProgressClassification(2);
//        projectVO.setProjectCategory(1);
//        projectVO.setProjectName("기존 유지 보수 프로젝트");
//        projectVO.setProjectNo(3);
//        projectVO.setRegDate(today);
//        projectVO.setRecruitmentMemberCnt(4);
//        projectVO.setProjectDetail("test 상세 정보");
//
//        projectApplicantService.addProject(projectVO);
//
//        projectVO = projectApplicantService.getProject(3);
//
//        Assert.assertEquals("user02", projectVO.getLeaderId());
//    }
//
//    //@Test
//    public void getApplicant() {
//
//        ApplicantVO applicantVO = new ApplicantVO();
//
//        applicantVO = projectApplicantService.getApplicant(1);
//
//        System.out.println(applicantVO);
//
//        Assert.assertEquals("없습니다", applicantVO.getApplicantAnswerA());
//    }
//
//    @Test
//    public void addApplicant() {
//
//        ApplicantVO applicantVO = new ApplicantVO();
//        ProjectVO projectVO = new ProjectVO();
//        projectVO.setProjectNo(1);
//
//        applicantVO.setApplicantAnswerA("답변입니다");
//        applicantVO.setApplicantNo(2);
//        applicantVO.setIntroToMember("잘하겠습니다");
//        applicantVO.setProjectVO(projectVO);
//        applicantVO.setUserId("user05");
//
//        System.out.println(applicantVO);
//
//        projectApplicantService.addApplicant(applicantVO);
//
//        applicantVO = projectApplicantService.getApplicant(1);
//        System.out.println(applicantVO);
//
//        Assert.assertEquals("user05", applicantVO.getUserId());
//    }
//
//
//}