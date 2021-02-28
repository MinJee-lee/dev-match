package com.example.demo.projectApplicant.test;

import com.example.demo.projectApplicant.vo.TestHashVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hash/*")
public class TestClass {
	
	@Autowired
	@Qualifier("TestService")
	private TestService testService;
	
	public TestClass() {

	}
	
	@RequestMapping(value="/test")
	public String testProject() throws Exception{
		TestHashVO hash = new TestHashVO();
		hash.setHashNo(1);
		hash.setHashTag("test");
		
		testService.Test(hash);
		
		return "forward:test.jsp";
	}

}
