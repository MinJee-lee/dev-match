package com.example.demo.projectApplicant.test;

import com.example.demo.projectApplicant.vo.TestHashVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service("TestService")
public class TestService {
	
	@Autowired
	@Qualifier("TestDao")
	TestDao dao;
	public void setTestDao(TestDao dao) {
		this.dao = dao;
	}
	
	///Constructor
	public TestService() {

	}
	
	public void Test(TestHashVO vo) throws Exception {
		dao.Test(vo);
	}

}
