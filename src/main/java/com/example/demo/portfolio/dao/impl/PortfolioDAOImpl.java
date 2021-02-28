package com.example.demo.portfolio.dao.impl;

import com.example.demo.common.vo.SearchVO;
import com.example.demo.portfolio.dao.PortfolioDAO;
import com.example.demo.portfolio.vo.PortfolioVO;
import com.example.demo.project.vo.ProjectVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository("portfolioDAOImpl")
public class PortfolioDAOImpl implements PortfolioDAO {

    @Autowired
    @Qualifier("sqlSessionTemplate")
    private SqlSession sqlSession;


    /**

     todo 포트폴리오 수정시 해시태그 부분도 같이 수정하는 코드도 작성해주세요. 2/10일까지 입니다.

     */


    @Override
    public int addPort(PortfolioVO addPort){


        if (addPort.getProjectNo() != 0){
            sqlSession.update("portfolioMapper.updateApplicantStatus",addPort);
        }
        return sqlSession.insert("portfolioMapper.addPort", addPort);
//        return sqlSession.insert("portfolioMapper.addHashTag", addPort);
    }

    //내부 포트폴리오 등록
    @Override
    public ProjectVO getProjectInfo(int projectNo) {
        return sqlSession.selectOne("portfolioMapper.getProjectInfo",projectNo);
    }

    @Override
    public List<ProjectVO> getEndProjectList(String userId){
        return sqlSession.selectList("portfolioMapper.getEndProjectList",userId);
    }

    @Override
    public int updatePort(PortfolioVO updatePort){
//        sqlSession.update("portfolioMapper.updateHashTag",updatePort);
        return sqlSession.update("portfolioMapper.updatePort", updatePort);
    }

    @Override
    public int deletePort(PortfolioVO portfolioVO){
        return sqlSession.delete("portfolioMapper.deletePort", portfolioVO);
    }

    @Override
    public PortfolioVO getPort(int portNo){
//        sqlSession.selectOne("portfolioMapper.getHashTag",portNo);
        return sqlSession.selectOne("portfolioMapper.getPort", portNo);
    }

    @Override
    public List<PortfolioVO> getPortList(SearchVO searchVO) {
        return sqlSession.selectList("portfolioMapper.getPortList",searchVO);
    }

    @Override
    public int getTotalCount(SearchVO searchVO){
        return sqlSession.selectOne("portfolioMapper.getTotalCount",searchVO);
    }

    @Override
    public void portUploadFile(HashMap<String, Object> files) {
        sqlSession.insert("portfolioMapper.portUploadFile",files);
    }
}
