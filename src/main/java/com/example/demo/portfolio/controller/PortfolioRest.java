
package com.example.demo.portfolio.controller;

import com.example.demo.common.vo.SearchVO;
import com.example.demo.member.vo.MemberVO;
import com.example.demo.portfolio.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
@RequestMapping("/restPortfolio/*")
public class PortfolioRest {

    @Autowired
    PortfolioService portfolioService;
    //
    @GetMapping("portList")
    public Map<String,Object> portList(@ModelAttribute SearchVO searchVO, HttpSession session){
        searchVO.setUserId(((MemberVO)session.getAttribute("user")).getUserId());
        Map<String,Object> portfolioVOList = portfolioService.getPortList(searchVO);
//        List<PortfolioVO> portfolioVOList = portfolioService.getPortList(((MemberVO)session.getAttribute("user")).getUserId());
        return portfolioVOList;
/*레스트는 데이터만 보내주니까*/

    }
}

