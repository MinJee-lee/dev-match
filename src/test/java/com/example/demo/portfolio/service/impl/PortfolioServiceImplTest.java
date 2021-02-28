//package com.example.demo.portfolio.service.impl;
//
//import com.example.demo.portfolio.service.PortfolioService;
//import com.example.demo.portfolio.vo.PortfolioVO;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import javax.sound.sampled.Port;
//import java.util.Collections;
//import java.util.Date;
//import java.util.List;
//import java.util.Map;
//
//import static org.junit.Assert.*;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class PortfolioServiceImplTest {
//
//    @Autowired
//    @Qualifier("portfolioServiceImpl")
//    private PortfolioService portfolioService;
//
//    //@Test
//    public void addPort() {
//
//        PortfolioVO addPort = new PortfolioVO();
//        addPort.setUserId("user02");
//        addPort.setProjectNo(3);
////        addPort.setPortProjectStartDate(new Date());
////        addPort.setPortProjectEndDate(new Date());
//        addPort.setPortDescription("아 맛있는 거 먹고 싶다 예를들면 팥빙수");
//        addPort.setPortTitle("새벽공부가 집중이 더 잘 되는 이유");
//        addPort.setPortMemberCnt(2);
////        addExPortDTO.setPortFileName("메일인증코드.docx");
////        addExPortDTO.setPortThumbnailImg("Vv.jpg");
////        addExPortDTO.setPortSkillTag(Collections.singletonList("Java"));
//
//
//        Assert.assertEquals(1,portfolioService.addPort(addPort));
//
//    }
//
//    //@Test
//    public void getPort() {
//        PortfolioVO getPort = new PortfolioVO();
//
//        getPort = portfolioService.getPort(12);
//
//        Assert.assertEquals(12,getPort.getPortNo());
//        Assert.assertEquals("user02",getPort.getUserId());
//        Assert.assertEquals(1,getPort.getProjectNo());
//        System.out.println(getPort.getPortProjectStartDate());
//        System.out.println(getPort.getPortProjectEndDate());
//        Assert.assertEquals(2,getPort.getPortMemberCnt());
//    }
//
//    //@Test
//    public void deletePort() {
//        PortfolioVO deletePort = new PortfolioVO();
//        deletePort.setPortNo(16);
//
//        Assert.assertEquals(1,portfolioService.deletePort(deletePort));
//    }
//
//    //@Test
//    public void updatePort(){
//        PortfolioVO updatePort = new PortfolioVO();
//        updatePort.setPortNo(13);
////        updatePort.setPortProjectStartDate(new Date());
////        updatePort.setPortProjectEndDate(new Date());
//        updatePort.setPortDescription("오늘은 규리언니가 치즈감자튀김을 자랑했다 도영이는 떡 먹고 있던데 다들 잘 먹고 다니네");
//        updatePort.setPortMemberCnt(3);
//        updatePort.setPortTitle("3조 먹성");
//
//        Assert.assertEquals(1,portfolioService.updatePort(updatePort));
//    }
//
//    @Test
//    public void getPortList(){
//
//        PortfolioVO getPortList = new PortfolioVO();
//
//        getPortList.setUserId("user01");
//
//        List<PortfolioVO> getPortList01 = portfolioService.getPortList("user01");
//        Assert.assertEquals(9,getPortList01.size());
//
//
//    }
//}