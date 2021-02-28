package com.example.demo.portfolio.service.impl;

import com.example.demo.common.vo.SearchVO;
import com.example.demo.portfolio.dao.PortfolioDAO;
import com.example.demo.portfolio.service.PortfolioService;
import com.example.demo.portfolio.vo.PortfolioVO;
import com.example.demo.project.vo.ProjectVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("portfolioServiceImpl")
public class PortfolioServiceImpl implements PortfolioService {

    @Autowired
    @Qualifier("portfolioDAOImpl")
    PortfolioDAO portfolioDAO;

    @Override
    public int addPort(PortfolioVO addPort){
        return portfolioDAO.addPort(addPort);
    }


    @Override
    public ProjectVO getProjectInfo(int projectNo) {
        return portfolioDAO.getProjectInfo(projectNo);
    }

    @Override
    public List<ProjectVO> getEndProjectList(String userId){
        List<ProjectVO> getEndProjectList = portfolioDAO.getEndProjectList(userId);
        return getEndProjectList;

    }


    @Override
    public int updatePort(PortfolioVO updatePort){
        return portfolioDAO.updatePort(updatePort);
    }

    @Override
    public int deletePort(PortfolioVO portfolioVO){
        return portfolioDAO.deletePort(portfolioVO);
    }

    @Override
    public PortfolioVO getPort(int portNo){
        return portfolioDAO.getPort(portNo);
    }

    @Override
    public Map<String,Object> getPortList(SearchVO searchVO){
        List<PortfolioVO> list = portfolioDAO.getPortList(searchVO);
        int totalCount = portfolioDAO.getTotalCount(searchVO);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("list",list);
        map.put("totalCount", new Integer(totalCount));
        return map;

    }
//    public List<PortfolioVO> getPortList(PortfolioVO portfolioVO) {
//        return portfolioDAO.getPortList(portfolioVO);
//    }


    @Override
    public void portFileUpload(int portNo, String originalName, long filesSize) {
        HashMap<String,Object> files = new HashMap<>();
        files.put("portNo", portNo);
        files.put("originalName", originalName);
        files.put("fileSize",filesSize);

        portfolioDAO.portUploadFile(files);
    }
}

