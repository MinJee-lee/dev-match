package com.example.demo.projectApplicant.controller;

import com.example.demo.member.service.MemberService;
import com.example.demo.member.util.SecurityUtils;
import com.example.demo.member.vo.MemberVO;
import com.example.demo.projectApplicant.dto.UpdateApplicantStatusDTO;
import com.example.demo.projectApplicant.service.ProjectApplicantService;
import com.example.demo.projectApplicant.vo.ApplicantVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


@RestController
@RequestMapping("/applicant/*")
public class ProjectApplicantRest {
	
	@Autowired
	@Qualifier("projectApplicantServiceImpl")
	private ProjectApplicantService projectApplicantService;
	
	@Autowired
    @Qualifier("memberServiceImpl")
    MemberService memberService;
	
	public ProjectApplicantRest() {
		System.out.println(this.getClass());
	}

	@RequestMapping(value="json/updateApplicantStatus/{applicantStatus}/{applicantNo}", method=RequestMethod.GET)
	public ApplicantVO updateApplicantStatus(@ModelAttribute("updateApplicantStatusDTO")UpdateApplicantStatusDTO updateApplicantStatusDTO,
								HttpSession session) {
		updateApplicantStatusDTO.setUserId(((MemberVO)session.getAttribute("user")).getUserId());
		int applicantNo = updateApplicantStatusDTO.getApplicantNo();
		
		projectApplicantService.updateApplicantStatus(updateApplicantStatusDTO);
		ApplicantVO applicantVO = projectApplicantService.getApplicant(applicantNo);
		
		session.removeAttribute("user");
        MemberVO memberVO = memberService.selectMember(SecurityUtils.getLoginSessionMemberInfo().getUsername());
        if (memberVO != null) {
            session.setAttribute("user", memberVO);
        }
        
		return applicantVO;
	}
	

}
