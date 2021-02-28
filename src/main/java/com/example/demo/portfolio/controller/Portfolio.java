package com.example.demo.portfolio.controller;

import com.example.demo.common.service.dao.FileUploadDAO;
import com.example.demo.common.vo.FileVO;
import com.example.demo.common.vo.SearchVO;
import com.example.demo.member.service.MemberService;
import com.example.demo.member.util.SecurityUtils;
import com.example.demo.member.vo.MemberVO;
import com.example.demo.portfolio.service.PortfolioService;
import com.example.demo.portfolio.vo.PortfolioVO;
import com.example.demo.project.vo.ProjectVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("port/*")
public class Portfolio {

    private final String PATH = "C:\\spring-project\\src\\main\\resources\\static\\resources\\uploadImg\\";

    @Autowired
    @Qualifier("portfolioServiceImpl")
    private PortfolioService portfolioService;

    @Autowired
    @Qualifier("fileUploadDAO")
    private FileUploadDAO fileUploadDAO;

    @Autowired
    @Qualifier("memberServiceImpl")
    private MemberService memberService;

    //포트폴리오 등록
    @GetMapping("addPort")
    public String addPortView(@RequestParam("projectNo") int projectNo, Model model) {
        if (projectNo != 0) {
            model.addAttribute("getProjectInfo", portfolioService.getProjectInfo(projectNo));
        }
        return "portfolio/addPortfolio";
    }

    //포트폴리오 등록
    @PostMapping("addPort")
    public String addPort(@ModelAttribute("portfolioVO") PortfolioVO portfolioVO,
                          @ModelAttribute("fileVO") FileVO fileVO, MultipartHttpServletRequest request,
                          HttpSession session) throws IOException {

        portfolioVO.setUserId(((MemberVO) session.getAttribute("user")).getUserId());
        portfolioService.addPort(portfolioVO);

        if (request.getFiles("file").get(0).getSize() != 0) {
            List<MultipartFile> fileList = request.getFiles("file");
            for (MultipartFile mf : fileList) {
                fileVO.setUploadFileName(mf.getOriginalFilename());
                fileVO.setFileSize(mf.getSize());
                fileVO.setPortfolioNo(portfolioVO.getPortNo());

                String safeFile = PATH + mf.getOriginalFilename();
                mf.transferTo(new File(safeFile));

                fileUploadDAO.uploadFile(fileVO);
            }
        }

        session.removeAttribute("user");
        MemberVO memberVO = memberService.selectMember(SecurityUtils.getLoginSessionMemberInfo().getUsername());
        if (memberVO != null) {
            session.setAttribute("user", memberVO);
        }

        return "redirect:/port/portList";

    }

    //포트폴리오 수정
    @GetMapping("updatePort")
    public String updatePortView(@RequestParam("portNo") int param, Model model) {
        PortfolioVO portfolioVO = portfolioService.getPort(param);
        model.addAttribute("portfolio", portfolioVO);
        return "portfolio/updatePortfolio";
    }

    @PostMapping("updatePort")
    public String updatePort(@ModelAttribute PortfolioVO portfolioVO, HttpSession session, Model model) {
        portfolioVO.setUserId(((MemberVO) session.getAttribute("user")).getUserId());
        portfolioService.updatePort(portfolioVO);
        model.addAttribute("portfolio", portfolioService.getPort(portfolioVO.getPortNo()));
        return "portfolio/getPortfolio";
    }

    @GetMapping("deletePort")
    public String deletePort(@ModelAttribute PortfolioVO portfolioVO, HttpSession session, Model model) {
        /*System.out.println("포트폴리오삭제합니다."+portfolioVO);
        session.setAttribute("userId","user01");*/
        portfolioVO.setUserId(((MemberVO) session.getAttribute("user")).getUserId());
        portfolioService.deletePort(portfolioVO);
        /*model.addAttribute("portfolio",portfolioVO);*/
        return "redirect:/port/portList";
    }

    //포트폴리오 상세조회
    @GetMapping("getPort")
    public String getPort(@RequestParam("portNo") int portNo, Model model) {
        PortfolioVO portfolioVO = portfolioService.getPort(portNo);
        model.addAttribute("portfolio", portfolioVO);
        return "portfolio/getPortfolio";
    }

    //포트폴리오 목록조회
    @GetMapping("portList")
    public String portList(@ModelAttribute SearchVO searchVO, HttpSession session, Model model) {
        searchVO.setPageSize(20);
//        session.setAttribute("userId","user01");
//        searchVO.setUserId((String)session.getAttribute("userId"));

        searchVO.setUserId(((MemberVO) session.getAttribute("user")).getUserId());

        if (searchVO.getCurrentPage() == 0) {
            searchVO.setCurrentPage(1);
        }

        Map<String, Object> map = portfolioService.getPortList(searchVO);
        List<ProjectVO> endProjectList = portfolioService.getEndProjectList(((MemberVO) session.getAttribute("user")).getUserId());
        List<PortfolioVO> portList = (List<PortfolioVO>) map.get("list");

//        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+portList.get(0).getPortNo());
        model.addAttribute("endProjectList", endProjectList);
        model.addAttribute("portList", portList);
//        model.addAttribute("portList", map.get("list"));


        return "portfolio/getPortfolioList";
    }
}
