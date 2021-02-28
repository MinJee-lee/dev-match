package com.example.demo.project.controller;

import com.example.demo.common.service.dao.FileUploadDAO;
import com.example.demo.common.vo.FileVO;
import com.example.demo.member.service.MemberService;
import com.example.demo.member.util.SecurityUtils;
import com.example.demo.member.vo.MemberVO;
import com.example.demo.project.dto.AddReviewDTO;
import com.example.demo.project.dto.ProjectSearchDTO;
import com.example.demo.project.service.ProjectService;
import com.example.demo.project.vo.ProjectVO;
import com.example.demo.projectApplicant.service.ProjectApplicantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Transactional(rollbackFor = Exception.class, timeout = 10)
@Controller
@RequestMapping("/project")
@Slf4j
public class Project {

    private final String PATH = "C:\\spring-project\\src\\main\\resources\\static\\resources\\uploadImg\\";

    public Project(ProjectService projectService) {
        log.info(":: " + getClass().getName() + " Start::");
        this.projectService = projectService;
    }

    @Autowired
    @Qualifier("projectServiceImpl")
    ProjectService projectService;
    
    @Autowired
	@Qualifier("projectApplicantServiceImpl")
	private ProjectApplicantService projectApplicantService;

    @Autowired
    @Qualifier("fileUploadDAO")
    FileUploadDAO fileUploadDAO;

    @Autowired
    @Qualifier("memberServiceImpl")
    MemberService memberService;

    private final int DEFAULT_PAGE = 1;
    private final int PAGE_SIZE = 10;

    @GetMapping("/addProject")
    public String addProject(HttpSession session) {
        MemberVO memberVO = (MemberVO)session.getAttribute("user");

        if (memberVO.getProjectNo() == 0 ) {
            if (memberVO.getProjectWithdrawalDate() != null) {
                return isWithinRange(memberVO.getProjectWithdrawalDate()) ? "project/addProject" : "project/accessRestriction";
            } else {
                return "project/addProject";
            }
        }

        return "project/accessRestriction";

    }


    @PostMapping("/addProject")
    public String addProject(@ModelAttribute("project") ProjectVO projectVO,
                             MultipartHttpServletRequest request,
                             HttpSession session) throws Exception{

        ProjectVO addProjectResultVO = projectService.addProject(projectVO);
        projectApplicantService.addProApplicant(projectVO);

        if (request.getFiles("files").get(0).getSize() != 0) {
            List<MultipartFile> fileList = request.getFiles("files");

            for (MultipartFile mf : fileList) {

                FileVO fileVO = new FileVO();


                fileVO.setUploadFileName(mf.getOriginalFilename());
                fileVO.setFileSize(mf.getSize());
                fileVO.setProjectNo(addProjectResultVO.getProjectNo());

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

        return "redirect:/welcome";

    }

    @GetMapping("/getProject")
    public String getProject(@RequestParam("projectNo") int projectNo, Model model, HttpSession session) {

        if(session.getAttribute("user") ==null) return "/login";
        Map<String, Object> map = projectService.getProject(projectNo, SecurityUtils.getLoginSessionMemberInfo().getUsername());

        model.addAttribute("project", map.get("projectVO"));
        model.addAttribute("existApplicant", map.get("existApplicant"));
        model.addAttribute("hashList", map.get("hashList"));
        model.addAttribute("resultPage",map.get("resultPage"));
        return "project/getProject";
    }

    @GetMapping("/getProjectList")
    public String getProjectList(@ModelAttribute("projectSearchDTO") ProjectSearchDTO projectSearchDTO, Model model) {
        projectSearchDTO.setUserId(SecurityUtils.getLoginSessionMemberInfo().getUsername());
        System.out.println("projectSearchDTO" + projectSearchDTO);
        if (projectSearchDTO.getCurrentPage() == 0) {
            projectSearchDTO.setCurrentPage(DEFAULT_PAGE);
        }
        projectSearchDTO.setPageSize(PAGE_SIZE);


        List<ProjectVO> projectList = projectService.getProjectList(projectSearchDTO);

        log.info(projectSearchDTO.toString());

        model.addAttribute("checkedStatus", projectSearchDTO);
        model.addAttribute("projectList", projectList);


        return "project/getProjectList";

    }

    @GetMapping("/myProject")
    public String getMyProject(HttpSession session, Model model) {

        int projectNo = ((MemberVO) session.getAttribute("user")).getProjectNo();

        if (projectNo == 0) {
            return "project/notParticipating";
        } else {
            model.addAttribute("myProject", projectService.getMyProject(projectNo));
            return "project/getMyProject";
        }

    }

    @GetMapping("/addReview")
    public String addReview(HttpSession session, Model model) {

        int projectNo = ((MemberVO) session.getAttribute("user")).getProjectNo();

        if (projectNo == 0) {
            return "project/notParticipating";
        } else {
            model.addAttribute("myProject", projectService.getMyProject(projectNo));
            return "project/addReview";
        }
    }

    @PostMapping("/addReviewer")
    public String addReview(@ModelAttribute("addReviewDTO") AddReviewDTO addReviewDTO) {

        projectService.addReview(addReviewDTO);
        return "redirect:getProjectList";

    }

    private boolean isWithinRange(Date userWithdrawalDate) {

        Calendar aWeekAgo = Calendar.getInstance();
        aWeekAgo.add(Calendar.DATE , -7);
        String startDate = new SimpleDateFormat("yyyy-MM-dd").format(aWeekAgo.getTime());

        String withdrawalDate = new SimpleDateFormat("yyyy-MM-dd").format(userWithdrawalDate.getTime());

        Date today = new Date();
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        String endDate = date.format(today);

        LocalDate localdate = LocalDate.parse(withdrawalDate);
        LocalDate startLocalDate = LocalDate.parse(startDate);
        LocalDate endLocalDate = LocalDate.parse(endDate);
        endLocalDate = endLocalDate.plusDays(1); // endDate 는 포함하지 않으므로 +1일을 해줘야함.

        return ( localdate.isBefore( startLocalDate ) ) && ( localdate.isBefore( endLocalDate ) );

    }

}
