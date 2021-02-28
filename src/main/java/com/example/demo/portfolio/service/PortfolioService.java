package com.example.demo.portfolio.service;

import com.example.demo.common.vo.SearchVO;
import com.example.demo.portfolio.vo.PortfolioVO;
import com.example.demo.project.vo.ProjectVO;

import java.util.List;
import java.util.Map;

public interface PortfolioService {

    //포트폴리오 등록
    public int addPort(PortfolioVO addPort);

    //내부 포트폴리오 등록
    public ProjectVO getProjectInfo(int projectNo);

    //완료된 프로젝트 목록 조회
    public List<ProjectVO> getEndProjectList(String userId);

    //포트폴리오 수정
    public int updatePort(PortfolioVO updatePortDTO);

    //포트폴리오 삭제
    public int deletePort(PortfolioVO portfolioVO);

    //포트폴리오 상세 조회
    public PortfolioVO getPort(int portNo);

    //포트폴리오 목록 조회
//    public List<PortfolioVO> getPortList(PortfolioVO portfolioVO);
    public Map<String,Object> getPortList(SearchVO searchVO);

    //첨부파일
    public void portFileUpload(int portNo, String originalName,long filesSize);
}
