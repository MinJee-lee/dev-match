package com.example.demo.common.service.dao;

import com.example.demo.common.vo.FileVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository("fileUploadDAO")
public class FileUploadDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	 }
	
	public void uploadFile(FileVO fileVO) {
		sqlSession.insert("fileuploadMapper.uploadFile",fileVO);
	}

}
