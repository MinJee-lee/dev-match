package com.example.demo.projectApplicant.test;

import com.example.demo.projectApplicant.vo.TestHashVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;


@Repository("TestDao")
public class TestDao {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
	    this.sqlSession = sqlSession;
	 }
	//Constructor
	public TestDao() {

	}

	public void Test(TestHashVO vo) {
		System.out.println("TEST METHOD@@@@@@");
		sqlSession.insert("testMapper.test", vo);
	}

}
