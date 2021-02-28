package com.example.demo.projectApplicant.controller;

import com.example.demo.common.vo.PageVO;
import com.example.demo.common.vo.SearchVO;
import com.example.demo.member.service.MemberService;
import com.example.demo.member.util.SecurityUtils;
import com.example.demo.member.vo.MemberVO;
import com.example.demo.projectApplicant.dto.UpdateApplicantStatusDTO;
import com.example.demo.projectApplicant.service.ProjectApplicantService;
import com.example.demo.projectApplicant.vo.ApplicantVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/applicant/*")
public class ProjectApplicant {
	
	@Autowired
	@Qualifier("projectApplicantServiceImpl")
	private ProjectApplicantService projectApplicantService;
	
	@Autowired
    @Qualifier("memberServiceImpl")
	private MemberService memberService;
	
	public ProjectApplicant() {
		System.out.println(this.getClass());
	}
	
	@RequestMapping(value = "/addApplicant", method = RequestMethod.GET)
	public String addApplicant() throws Exception{
		System.out.println("/addApplicant GET");
		return "projectApplicant/addApplicant";
	}
	
	@RequestMapping(value="/addApplicant", method=RequestMethod.POST)
	public String addApplicant(@ModelAttribute("applicant") ApplicantVO applicantVO,
							   Model model) {
		System.out.println("/addApplicant");
		System.out.println(applicantVO);
		projectApplicantService.addApplicant(applicantVO);
		
		return "redirect:../project/getProject?projectNo="+applicantVO.getProjectVO().getProjectNo();
	}
	
	@RequestMapping(value = "/applicantList")
	public String applicantList(@ModelAttribute("searchVO") SearchVO searchVO,
								Model model,
								HttpSession session) throws Exception{
		searchVO.setPageSize(30);
		searchVO.setUserId(((MemberVO)session.getAttribute("user")).getUserId());
		if(searchVO.getCurrentPage() == 0 ){
			searchVO.setCurrentPage(1);
		}
		
		Map<String , Object> map=projectApplicantService.getApplicantList(searchVO);
		
		model.addAttribute("applicantList", map.get("list"));

		return "projectApplicant/applicantList";
	}
	
	@RequestMapping(value = "/appliedProjectList", method = RequestMethod.GET)
	public String appliedProjectList(@ModelAttribute("searchVO") SearchVO searchVO,
									Model model,
									HttpSession session)throws Exception{
		System.out.println("/appliedProjectList GET");
		
		searchVO.setPageSize(3);
		searchVO.setUserId(((MemberVO)session.getAttribute("user")).getUserId());
		if(searchVO.getCurrentPage() == 0 ){
			searchVO.setCurrentPage(1);
		}
		Map<String , Object> map=projectApplicantService.getAppliedProjectList(searchVO);
		
		PageVO resultPage = new PageVO( searchVO.getCurrentPage(), ((Integer)map.get("totalCount")).intValue(), 5, 3);
		System.out.println(resultPage);
		
		model.addAttribute("appliedList", map.get("list"));
		model.addAttribute("resultPage", resultPage);
		return "projectApplicant/appliedProjectList";
	}
	
	@RequestMapping(value = "/endProjectList", method = RequestMethod.GET)
	public String endProjectList(@ModelAttribute("searchVO") SearchVO searchVO,
								 Model model,
								 HttpSession session)throws Exception{
		System.out.println("/endProjectList GET");
		searchVO.setPageSize(3);
		searchVO.setUserId(((MemberVO)session.getAttribute("user")).getUserId());
		searchVO.setSearchConditionB(6);
		if(searchVO.getCurrentPage() == 0 ){
			searchVO.setCurrentPage(1);
		}
		Map<String , Object> map=projectApplicantService.getAppliedProjectList(searchVO);
		
		PageVO resultPage = new PageVO( searchVO.getCurrentPage(), ((Integer)map.get("totalCount")).intValue(), 5, 3);
		System.out.println(resultPage);
		
		model.addAttribute("appliedList", map.get("list"));
		model.addAttribute("resultPage", resultPage);
		return "projectApplicant/endProjectList";
	}
	
	@RequestMapping(value = "/getApplicant", method = RequestMethod.GET)
	public String getApplicant(@RequestParam("applicantNo")String applicantNo,
							   Model model)throws Exception {
		int intApplicantNo = Integer.parseInt(applicantNo);
		ApplicantVO applicantVO = projectApplicantService.getApplicant(intApplicantNo);
		
		model.addAttribute("applicantVO",applicantVO);
		return "projectApplicant/getApplicant";
	}
	
	@RequestMapping(value = "/updateApplicantStatus", method = RequestMethod.GET)
	public String updateApplicantStatus(@ModelAttribute("updateApplicantStatusDTO")UpdateApplicantStatusDTO updateApplicantStatusDTO,
										@ModelAttribute("searchVO") SearchVO searchVO,
										Model model,
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
        
        searchVO.setPageSize(30);
		searchVO.setUserId(((MemberVO)session.getAttribute("user")).getUserId());
		if(searchVO.getCurrentPage() == 0 ){
			searchVO.setCurrentPage(1);
		}
		
		Map<String , Object> map=projectApplicantService.getApplicantList(searchVO);
		
		model.addAttribute("applicantList", map.get("list"));
        
        return "projectApplicant/applicantList";
	}
	
}
