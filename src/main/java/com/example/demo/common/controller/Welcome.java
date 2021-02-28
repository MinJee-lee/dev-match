package com.example.demo.common.controller;

import com.example.demo.common.vo.SearchVO;
import com.example.demo.community.service.PostService;
import com.example.demo.project.dto.ProjectSearchDTO;
import com.example.demo.project.service.ProjectService;
import com.example.demo.project.vo.ProjectVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
import java.util.Map;

@Slf4j
@Controller
public class Welcome {
	
	public Welcome() {
		log.info(":: " + getClass().getName() + " Start::");
	}

	@Autowired
    @Qualifier("projectServiceImpl")
    ProjectService projectService;
	
	@Autowired
    @Qualifier("postServiceImpl")
    PostService postService;
	
	private final int DEFAULT_PAGE = 1;
    private final int PAGE_SIZE = 7;

    @GetMapping("/welcome")
    public String welcomePage(@ModelAttribute("projectSearchDTO") ProjectSearchDTO projectSearchDTO, 
    						  Model model,
    						  @ModelAttribute("searchVO") SearchVO  searchVO) {

    	// project 
        if (projectSearchDTO.getCurrentPage() == 0) {
            projectSearchDTO.setCurrentPage(DEFAULT_PAGE);
        }
        projectSearchDTO.setPageSize(PAGE_SIZE);

        List<ProjectVO> projectList = projectService.getProjectList(projectSearchDTO);

        log.info(projectSearchDTO.toString());
        
        // community
        searchVO.setPageSize(7);

        if(searchVO.getCurrentPage() == 0 ){
            searchVO.setCurrentPage(1);
        }

        Map<String,Object> map = postService.getPostList(searchVO);

        model.addAttribute("postList",map.get("list"));
        model.addAttribute("projectList", projectList);
    	
        //공통모듈은 통일해서 사용하면 참 좋겠어요 ㅠㅠ
        
        return "welcome";
    }
}
